package lesson06.task02;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * генератор текстовых файлов
 * ДЗ_6, 2
 * @author Михаил Копылов
 * @version 1.0
 */

public class Main {
    public static void main(String[] args) throws IOException {

        char[] alphabetRu = new char[]{'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ь', 'ы', 'ъ', 'э', 'ю', 'я'};
        String text = ""; //строка итогового текста
        String str; //переменная для генерации массива слов
        int letterCount; //количество букв в слове (1<=n2<=15)
        int wordCount; //количество слов
        List<String> list = new ArrayList<>(); //массив слов

        //генерируем массив слов (1<=n4<=1000)
        wordCount = rnd(1, 1000);
        for (int k = 0; k < wordCount; k++) {
            letterCount = rnd(1, 15);
            str = "";
            for (int l = 0; l < letterCount; l++) { //генерируем слово из букв
                str += (alphabetRu[rnd(0, alphabetRu.length - 1)]); //умышленно генерируем из кириллицы, чтобы слова из массива было сразу видно в тексте
            }
            list.add(str);
        }
        String[] words = list.toArray(new String[0]);

        getFiles("C:\\temp\\", 3, 2500, words, 5); //вызов метода getFiles
    }

    /**
     * Метод получения псевдослучайного целого числа от min до max (включая max)
     */
    private static int rnd ( int min, int max){
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }

    /**метод getFiles(String path, int n, int size, String[] words, int probability),
     * который создаст n файлов размером size в каталоге path. words - массив слов, probability - вероятность.*/
    private static void getFiles(String path, int n, int size, String[] words, int probability) throws IOException {
        String txt;

        for (int i = 0; i < n; i++) {
            txt = new TextGenerator().generate(size, words, probability);
            BufferedWriter writer = new BufferedWriter(new FileWriter(path + "text" + i + ".txt")); //записываем в файл
            writer.write(txt);
            writer.flush();
            writer.close();
        }
    }
}
