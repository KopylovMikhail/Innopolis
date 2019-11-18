package lesson06.task01;

import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

/**
 * Программа, читающая текстовый файл и составлящая отсортированный по алфавиту список слов.
 * ДЗ_6
 * @author Михаил Копылов
 * @version 1.1
 */
public class Main {
    public static void main(String[] args) throws IOException {

        List<String> list = new ArrayList<>();
        Set<String> set = new HashSet<>();
        Pattern pattern = Pattern.compile("\\s"); //будем искать символ пробела с помощью конструктора регулярных выражений

        BufferedReader reader = new BufferedReader(new FileReader("text.txt")); //читаем из файла
        String line = "";
        while ((line = reader.readLine()) != null) { //добавляем в коллекцию Set, т.к. слова не должны повторяться
            String[] strings = pattern.split(line,-1); //разбиваем текст на слова
            for (String s : strings) {
                String str = s.replaceAll("[,.!?:;&«»]", ""); //удаляем мусор из слов (знаки препинания)
                set.add(str.toLowerCase()); //добавляем слова в коллекцию Set, приводим все строки к нижнему регистру
            }
        }
        reader.close();

        list.addAll(set); //перемещаем коллекцию Set в List для сортировки
        Collections.sort(list);
//        list.forEach(s -> System.out.println(s)); //проверяем результат сортировки

        BufferedWriter writer = new BufferedWriter(new FileWriter("words_new.txt")); //записываем в файл
        for (String s : list) {
            writer.write(s + "\n");
            writer.flush();
        }
        writer.close();
    }
}
