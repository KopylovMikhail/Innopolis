package lesson06.task01;

import java.io.*;
import java.util.*;

/**
 * Программа, читающая текстовый файл и составлящая отсортированный по алфавиту список слов.
 * ДЗ_6
 * @author Михаил Копылов
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) throws IOException {

        List<String> list = new ArrayList<>();
        Set<String> set = new HashSet<>();

        BufferedReader reader = new BufferedReader(new FileReader("words.txt")); //читаем из файла
        String line = "";
        while ((line = reader.readLine()) != null) { //добавляем в коллекцию Set, т.к. слова не должны повторяться
            set.add(line.toLowerCase()); //приводим все строки к нижнему регистру
        }

        list.addAll(set); //перемещаем коллекцию Set в List для сортировки
        Collections.sort(list);
        list.forEach(s -> System.out.println(s)); //проверяем результат сортировки

        BufferedWriter writer = new BufferedWriter(new FileWriter("words_new.txt")); //записываем в файл
        for (String s : list) {
            writer.write(s + "\n");
            writer.flush();
        }
    }
}
