package lesson03.task001;
/**
 * Программа проверяет работу методов созданного класса MathBox
 * ДЗ_3, задание 1
 * @author Михаил Копылов
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        Number[] num = new Number[]{1, 2.3, 5, 7L, -2, 1.1F, 4.5D, 12, 5, 0b10, (short) 15, 12}; //создаем массив с элементами Number
        MathBox mb = new MathBox(num);

        System.out.println(mb.toString()); //вывод получившегося множества и проверка метода toString
        System.out.println(mb.summator()); //вывод суммы всех элементов
        mb.splitter(2.0); //деление на указанный делитель всех элементов и вывод полученного множества
        System.out.println(mb.toString());
        mb.delete(6); //удаление указанного элемента и проверка множества
        System.out.println(mb.toString());
    }
}
