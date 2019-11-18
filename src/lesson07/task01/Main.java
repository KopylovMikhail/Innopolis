package lesson07.task01;

import java.math.BigInteger;

/**
 * программа для вычисления факториалов всех элементов массива
 * ДЗ_7
 * @author Михаил Копылов
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        int[] num = new int[1000];

        //генерируем массив случайных чисел в диапазоне от 1 до 5000
        for (int i = 0; i < num.length; i++) {
            num[i] = rnd(1, 5000);
        }

        for (int i = 0; i < num.length; i++) {
            //Создание потока для каждого вычисления
            int finalI = i;
            Thread myThready = new Thread(new Runnable()
            {
                @Override
                public void run() {
                    System.out.println(factorial(num[finalI])); //выводим результаты вычисления факториала на экран
                }
            });
            myThready.start();	//Запуск потока
        }
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

    /**
     * Метод получения псевдослучайного целого числа от min до max (включая max)
     */
    private static int rnd ( int min, int max){
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }
}
