package lesson03.task03;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**Класс получает массив Number и раскладывает элементы в коллекцию HashSet*/
public class MathBox<T extends Number> extends ObjectBox {

    private Set<T> number = new HashSet<>(); //коллекция HashSet не допускает дублирования, что и нужно по условию задачи

    public MathBox(T[] arrNumber) { //Конструктор на вход получает массив Number
        Collections.addAll(this.number, arrNumber);
    }

    /**метод summator, возвращающий сумму всех элементов коллекции*/
    public double summator () {
        double sum = 0;
        for (T n : number) {
            sum += n.doubleValue();
        }
        return sum;
    }

    /**метод splitter, выполняющий поочередное деление всех хранящихся в объекте элементов на делитель,
     * хранящиеся в объекте данные полностью заменяются результатами деления*/
    public void splitter(double div) {
        Set<T> tmpNum = new HashSet<>();
        for (T n: number) {
            Double temp = n.doubleValue()/div;
            tmpNum.add((T) temp);
        }
        number = tmpNum;
    }
/**метод delete получает на вход Integer и если такое значение есть в коллекции, удаляет его*/
    public void delete(Integer i) {
        number.remove(i);
    }

    /**Getter возвращает коллекцию*/
    public Set<T> getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "MathBox" + number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MathBox)) return false;
        MathBox<?> mathBox = (MathBox<?>) o;
        return Objects.equals(getNumber(), mathBox.getNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumber());
    }

    @Override
    public void addObject(Object o) {
        number.add((T) o);
    }

    @Override
    public void deleteObject(Object o) {
        number.remove(o);
    }

    @Override
    public String dump() {
        return number.toString();
    }
}
