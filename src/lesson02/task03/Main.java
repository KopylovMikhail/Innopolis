package lesson02.task03;

import java.util.ArrayList;

import static java.lang.Math.*;

/**
 * Программа реализует сортировку объектов Person двумя разлтчными способами
 * ДЗ_2, задание 3
 * @author Михаил Копылов
 * @version 1.1
 */
public class Main {

    public static void main(String[] args) {

        int N = 100; //количество элементов в массиве persons
        String[] manName = new String[]{"Bob", "Jim", "Joey", "John", "Mike", "Rob", "Ross", "Roth", "Seth", "Tom"}; //массив мужских имен
        String[] womanName = new String[]{"Dora", "Elly", "Jane", "July", "Leah", "Mary", "Mia", "Nancy", "Rita", "Sia"}; //массив женских имен
        ArrayList<Person> persons = new ArrayList<>();

        //генерация массива persons
        for (int i = 0; i < N; i++) {
            int tmpAge = rnd(0, 100);
            int tmpName = rnd(0, 9);
            boolean tmpSex = random() < 0.5;
            if (tmpSex) persons.add(new Person(tmpAge, Sex.MAN, manName[tmpName]));
            else persons.add(new Person(tmpAge, Sex.WOMAN, womanName[tmpName]));
        }

//объявляем классы с методами сортировки
        SortPerson1 srt1 = new SortPerson1();
        SortPerson2 srt2 = new SortPerson2();
        long startTime, timeSpent1 = 0, timeSpent2 = 0;

        try {
            startTime = System.currentTimeMillis(); //начальное время для подсчета времени сортировки
            srt1.sort(persons); //сортируем массив первым способом
            timeSpent1 = System.currentTimeMillis() - startTime; //время сортировки класса SortPerson1
            startTime = System.currentTimeMillis();
            srt2.sort(persons); //сортируем массив вторым способом
            timeSpent2 = System.currentTimeMillis() - startTime; //время сортировки класса SortPerson2
            for (Person p : persons) {
                System.out.println(p);
            }
            System.out.println("Сортировка класса SortPerson1 выполнялась " + timeSpent1 + " миллисекунд");
            System.out.println("Сортировка класса SortPerson2 выполнялась " + timeSpent2 + " миллисекунд");
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка исключения: имена людей и возраст совпадают.");
        }
    }
    /**
     * Метод получения псевдослучайного целого числа от min до max (включая max)
     */
    private static int rnd(int min, int max)
    {
        max -= min;
        return (int) (random() * ++max) + min;
    }
}
