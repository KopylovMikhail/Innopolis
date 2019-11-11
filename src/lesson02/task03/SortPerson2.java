package lesson02.task03;

import java.util.List;

/**
 * Второй вариант сортировки массива методом Gnome Sort
 */
public class SortPerson2 implements Sortable {
    /**
     * Метод сортировки по полу, возрасту и имени
     * @param persons массив элементов Person
     */
    @Override
    public void sort(List<Person> persons) {
        int i = 0;
        while (i < persons.size()) {
            if (i == 0) i++;
            if (persons.get(i).sex.compareTo(persons.get(i-1).sex) < 0) {
                Person tmp = persons.get(i);
                persons.set(i, persons.get(i-1));
                persons.set(i-1, tmp);
                i--;
            }
            else if (persons.get(i).sex.compareTo(persons.get(i-1).sex) == 0 & (persons.get(i).age > persons.get(i-1).age)) {
                Person tmp = persons.get(i);
                persons.set(i, persons.get(i-1));
                persons.set(i-1, tmp);
                i--;
            }
            else if (persons.get(i).sex.compareTo(persons.get(i-1).sex) == 0 & persons.get(i).age == persons.get(i-1).age & persons.get(i).name.compareTo(persons.get(i-1).name) < 0) {
                Person tmp = persons.get(i);
                persons.set(i, persons.get(i-1));
                persons.set(i-1, tmp);
                i--;
            }
            else i++;
        }
    }
}
