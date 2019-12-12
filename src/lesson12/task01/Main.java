package lesson12.task01;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * ДЗ_12.1 программа демонстрирует утечку памяти в Java (Heap Space)
 *
 * -Xmx50m настройка размера памяти heap space, при которой происходит переполнение ~1 мин
 * -XX:MaxMetaspaceSize=10M
 */
public class Main {
    private static final int LOOP_COUNT = 100_000_000;

    public static void main(String[] args) throws InterruptedException {
        List<String> list = new ArrayList<>();

        /*в результате выполнения цикла возникнет ошибка
        Exception in thread "main" java.lang.OutOfMemoryError: Java heap space*/
        Random random = new Random();
        for (int i = 0; i < LOOP_COUNT; i++) {
            String str = "" + random.nextInt();
            list.add(str);
            if (i % 10 == 0) {
                Thread.sleep(1);
                list.remove(0);
            }
        }
        System.out.println(list.size());
    }
}
