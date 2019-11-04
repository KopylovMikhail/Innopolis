package lesson02.task03;

import java.util.ArrayList;
/**
 * Второй вариант сортировки массива методом быстрой сортировки
 */
public class SortPerson2 implements sortable {

    @Override
    public void sort(ArrayList<Person> persons) {
        int leftBorder = 0;
        int rightBorder = persons.size() - 1;
        quickSortByName(persons, leftBorder, rightBorder);
        quickSortByAge(persons, leftBorder, rightBorder);
        quickSortBySex(persons);
    }

    /**
     * Метод сортировки по имени
     * @param persons массив элементов Person
     * @param leftBorder начало массива
     * @param rightBorder конец массива
     */
    private void quickSortByName(ArrayList<Person> persons, int leftBorder, int rightBorder) {
        int leftMarker = leftBorder;
        int rightMarker = rightBorder;
        int pivotId = (leftMarker + rightMarker) / 2;
        Person pivot = persons.get(pivotId);
        do {
            // Двигаем левый маркер слева направо пока элемент меньше, чем pivot
            while (persons.get(leftMarker).name.compareTo(pivot.name) < 0) {
                leftMarker++;
            }
            // Двигаем правый маркер, пока элемент больше, чем pivot
            while (persons.get(rightMarker).name.compareTo(pivot.name) > 0) {
                rightMarker--;
            }
            // Проверим, не нужно обменять местами элементы, на которые указывают маркеры
            if (leftMarker <= rightMarker) {
                // Левый маркер будет меньше правого только если мы должны выполнить swap
                if (leftMarker < rightMarker) {
                    Person tmp = persons.get(leftMarker);
                    persons.set(leftMarker, persons.get(rightMarker));
                    persons.set(rightMarker, tmp);
                }
                // Сдвигаем маркеры, чтобы получить новые границы
                leftMarker++;
                rightMarker--;
            }
        } while (leftMarker <= rightMarker);

        // Выполняем рекурсивно для частей
        if (leftMarker < rightBorder) {
            quickSortByName(persons, leftMarker, rightBorder);
        }
        if (leftBorder < rightMarker) {
            quickSortByName(persons, leftBorder, rightMarker);
        }
    }
    /**
     * Метод сортировки по возрасту
     * @param persons массив элементов Person
     * @param leftBorder начало массива
     * @param rightBorder конец массива
     */
    private void quickSortByAge(ArrayList<Person> persons, int leftBorder, int rightBorder) {
        int leftMarker = leftBorder;
        int rightMarker = rightBorder;
        Person pivot = persons.get((leftMarker + rightMarker) / 2);
        do {
            // Двигаем левый маркер слева направо пока элемент меньше, чем pivot
            while (persons.get(leftMarker).age > pivot.age) {
                leftMarker++;
            }
            // Двигаем правый маркер, пока элемент больше, чем pivot
            while (persons.get(rightMarker).age < pivot.age) {
                rightMarker--;
            }
            // Проверим, не нужно обменять местами элементы, на которые указывают маркеры
            if (leftMarker <= rightMarker) {
                // Левый маркер будет меньше правого только если мы должны выполнить swap
                if (leftMarker < rightMarker) {
                    Person tmp = persons.get(leftMarker);
                    persons.set(leftMarker, persons.get(rightMarker));
                    persons.set(rightMarker, tmp);
                }
                // Сдвигаем маркеры, чтобы получить новые границы
                leftMarker++;
                rightMarker--;
            }
        } while (leftMarker <= rightMarker);

        // Выполняем рекурсивно для частей
        if (leftMarker < rightBorder) {
            quickSortByAge(persons, leftMarker, rightBorder);
        }
        if (leftBorder < rightMarker) {
            quickSortByAge(persons, leftBorder, rightMarker);
        }
    }

    /**
     * Метод сортировки по полу
     * @param persons массив элементов Person
     */
    private void quickSortBySex(ArrayList<Person> persons) {
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
