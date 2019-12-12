package lesson12.task02;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * ДЗ_12.2 программа демонстрирует утечку памяти в Java (Metaspace /Permanent Generation)
 *
 * -XX:MaxMetaspaceSize=9M настройка размера максимольной памяти Metaspace
 *
 */
public class Main {
    private static final int LOOP_COUNT = 100_000_000;

    public static void main(String[] args) throws InterruptedException {
        List<Object> list = new ArrayList<>();

        /*в результате выполнения цикла с макс. памятью 9M возникнет ошибка:
        Caused by: java.lang.OutOfMemoryError: Compressed class space
        (Compressed class space является частью Metaspace)

        в результате выполнения цикла с макс. памятью 8M возникнет ошибка:
        Error occurred during initialization of VM
        MaxMetaspaceSize is too small.*/
        for (int i = 0; i < LOOP_COUNT; i++) {
            Metaspace mtsp = new Metaspace();
            list.add(mtsp);
            if (i % 10 == 0) {
                Thread.sleep(1);
                list.remove(0);
            }
        }
        System.out.println(list.size());
    }
}

/**
 * пустой класс для заполнения списка объектов
 * */
class Metaspace {
}