package lesson02.task02;
/**
 * Класс программы, которая генерирует N случайных чисел.
 * Для каждого числа k вычисляет квадратный корень q.
 * Если квадрат целой части q числа равен k, то выводит это число на экран.
 * ДЗ_2, задание 2
 * @author Михаил Копылов
 * @version 1.0
 */
public class Main {

    public  static void main(String[] args) {
        final int min = -100; // Минимальное число для диапазона
        final int max = 100; // Максимальное число для диапазона
        int N = 10; //количество случайно сгенерированных чисел
        int q; //квадратный корень числа
        int[] numbers = new int[N];

        //заполняем массив случайными числами
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rnd(min, max);
//            System.out.println(numbers[i]);
        }
        //сравниваем в цикле квадрат целой части числа с самим числом, при равенстве выводим на экран
        for (int number : numbers) {
            try {
                q = sqrtNum(number);
            } catch (ArithmeticException e) {
                System.out.println(e.toString());
                break;
            }
            if (Math.pow(q, 2) == number) System.out.println(number);
        }
    }
    /**
     * Метод получения псевдослучайного целого числа от min до max (включая max)
     */
    private static int rnd(int min, int max)
    {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }
    /**
     * Метод извлечения целой части корня числа
     * При отрицательном входном числе выбрасывает арифметическое исключение
     * @return возвращает целую часть корня числа
     */
    private static int sqrtNum(int n) {
        if (n >= 0) return (int) Math.sqrt(n);
        throw new ArithmeticException();
    }
}
