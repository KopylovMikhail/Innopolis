package lesson03.task001;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**Класс получает массив Number и раскладывает элементы в коллекцию HashSet*/
public class MathBox<T extends Number> {

    private Set<Number> number = new HashSet<>(); //коллекция HashSet не допускает дублирования, что и нужно по условию задачи

    public MathBox(T[] arrNumber) { //Конструктор на вход получает массив Number
        Collections.addAll(this.number, arrNumber);
    }

    /**метод summator, возвращающий сумму всех элементов коллекции*/
    public double summator () {
        double sum = 0;
        for (Number n : number) {
            sum += n.doubleValue();
        }
        return sum;
    }

    /**метод splitter, выполняющий поочередное деление всех хранящихся в объекте элементов на делитель
     * хранящиеся в объекте данные полностью заменяются результатами деления*/
    public void splitter(double div) {
        Set<Number> tmpNum = new HashSet<>();
        for (Number n: number) {
            tmpNum.add(n.doubleValue()/div);
        }
        number = tmpNum;
    }
/**метод delete получает на вход Integer и если такое значение есть в коллекции, удаляет его*/
    public void delete(Integer i) {
        number.remove((double) i);
    }
/**Getter возвращает коллекцию*/
    public Set<Number> getNumber() {
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
}
