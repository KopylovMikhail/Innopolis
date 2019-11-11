package lesson02.task03;

import java.util.List;

/**
 * Первый вариант сортировки массива методом пузырька
 */
public class SortPerson1 implements Sortable {

    /**
     * Метод сортировки по трем параметрам: полу, возрасту и имени
     * @param persons массив элементов Person
     */
    @Override
    public void sort(List<Person> persons) {
        boolean sortedName = false;
        boolean sortedAge = false;
        boolean sortedSex = false;
        Person temp;
        while(!(sortedName & sortedAge & sortedSex)) {
            sortedName = true;
            sortedAge = true;
            sortedSex = true;
            for (int i = 0; i < persons.size() - 1; i++) {
                //изначально сортируем по полу
                if (persons.get(i).sex.compareTo(persons.get(i + 1).sex) > 0) {
                    temp = persons.get(i);
                    persons.set(i, persons.get(i + 1));
                    persons.set(i + 1, temp);
                    sortedSex = false;
                }
                //если у сравниваемых объектов совпадает пол, то сортируем по возрасту
                if ((persons.get(i).sex.compareTo(persons.get(i + 1).sex) == 0) & (persons.get(i).age < persons.get(i + 1).age)) {
                    temp = persons.get(i);
                    persons.set(i, persons.get(i + 1));
                    persons.set(i + 1, temp);
                    sortedAge = false;
                }
                //если у сравниваемых объектов совпадает пол и возраст, то сортируем по имени
                if ((persons.get(i).sex.compareTo(persons.get(i + 1).sex) == 0) & (persons.get(i).age == persons.get(i + 1).age) & (persons.get(i).name.compareTo(persons.get(i + 1).name) > 0)) {
                    temp = persons.get(i);
                    persons.set(i, persons.get(i + 1));
                    persons.set(i + 1, temp);
                    sortedName = false;
                }
                //выбрасывание исключения, если имена людей и возраст совпадают
                if (persons.get(i).name.compareTo(persons.get(i+1).name) == 0 & persons.get(i).age == persons.get(i+1).age)
                    throw new IllegalArgumentException();
            }
        }
    }
}
