package lesson11.task01;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;

/**
 * программа для вычисления факториалов всех элементов массива с использованием лямбда-выражений
 * ДЗ_11
 * @author Михаил Копылов
 * @version 1.0
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {

        int[] num = new int[1000];
        List<BigInteger> list = new ArrayList<>();

        //генерируем массив случайных чисел в диапазоне от 1 до 5000
        for (int i = 0; i < num.length; i++) {
            //используем предопределенный функциональный интерфейс BinaryOperator<T>
            //для получения псевдослучайного целого числа от min до max (включая max)
            BinaryOperator<Integer> r = (min, max) -> {
                max -= min;
                return (int) (Math.random() * ++max) + min;
            };
            num[i] = r.apply(1, 5000);
        }

        for (int i = 0; i < num.length; i++) {
            //Создание потока для каждого вычисления
            int finalI = i;
            //используем лямбда-выражение для создания потока
            Thread myThready = new Thread(() -> {
                list.add(factorial(num[finalI])); //добавляем в список вычисленнные факториалы
            });
            myThready.start();	//Запуск потока
            myThready.join();  //дожидаемся выполнения всех потоков
        }

        //операция forEach Stream API
        list.forEach(System.out::println);
    }

    /**
     * Метод вычисления факториала путем перемножения чисел в простом цикле
     */
    private static BigInteger factorial(int n)
    {
        BigInteger ret = BigInteger.ONE;
        for (int i = 1; i <= n; ++i) ret = ret.multiply(BigInteger.valueOf(i));
        return ret;
    }
}
