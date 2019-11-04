package lesson02.task03;

import java.util.ArrayList;

/**
 * Первый вариант сортировки массива методом пузырька
 */
public class SortPerson1 implements sortable {

    @Override
    public void sort(ArrayList<Person> persons) {
        sortPersonByName(persons);
        sortPersonByAge(persons);
        sortPersonBySex(persons);
    }

    /**
     * Метод сортировки по имени
     * @param persons массив элементов Person
     */
    private void sortPersonByName(ArrayList<Person> persons) {
        boolean sorted = false;
        Person temp;
        while(!sorted) {
            sorted = true;
            for (int i = 0; i < persons.size() - 1; i++) {
                if (persons.get(i).name.compareTo(persons.get(i+1).name) > 0) {
                    temp = persons.get(i);
                    persons.set(i, persons.get(i+1));
                    persons.set(i+1, temp);
                    sorted = false;
                }
                //выбрасывание исключения, если имена людей и возраст совпадают
                if (persons.get(i).name.compareTo(persons.get(i+1).name) == 0 & persons.get(i).age == persons.get(i+1).age)
                    throw new IllegalArgumentException();
            }
        }
    }

    /**
     * Метод сортировки по возрасту
     * @param persons массив элементов Person
     */
    private void sortPersonByAge(ArrayList<Person> persons) {
        boolean sorted = false;
        Person temp;
        while(!sorted) {
            sorted = true;
            for (int i = 0; i < persons.size() - 1; i++) {
                if (persons.get(i).age < persons.get(i+1).age) {
                    temp = persons.get(i);
                    persons.set(i, persons.get(i+1));
                    persons.set(i+1, temp);
                    sorted = false;
                }
            }
        }
    }
    /**
     * Метод сортировки по полу
     * @param persons массив элементов Person
     */
    private void sortPersonBySex(ArrayList<Person> persons) {
        boolean sorted = false;
        Person temp;
        while(!sorted) {
            sorted = true;
            for (int i = 0; i < persons.size() - 1; i++) {
                if (persons.get(i).sex.compareTo(persons.get(i+1).sex) > 0) {
                    temp = persons.get(i);
                    persons.set(i, persons.get(i+1));
                    persons.set(i+1, temp);
                    sorted = false;
                }
            }
        }
    }
}
