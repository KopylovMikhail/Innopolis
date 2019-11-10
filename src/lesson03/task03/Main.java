package lesson03.task03;
/**
 * Программа проверяет работу доработанных классов MathBox и ObjectBox,
 * где MathBox является наследником ObjectBox
 * ДЗ_3, задание 3
 * @author Михаил Копылов
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        Number[] num = new Number[]{1, 2, 3, 4, 5, 5.5, 6.5, 7.5, 8L, 9L, 10F, 11F};
        MathBox mb = new MathBox(num);

        System.out.println(mb.toString()); //проверка метода toString
        System.out.println(mb.dump()); //проверка метода dump
        mb.addObject(12); //проверка метода addObject и просмотр результата добавления
        System.out.println(mb.toString());
        mb.deleteObject(9L); //проверка метода deleteObject и просмотр результата удаления
        System.out.println(mb.toString());
        try {
            mb.addObject(new Object()); //При попытке положить Object в MathBox создастся исключение ClassCastException
        } catch (ClassCastException e) {
            System.out.println(e.toString());
        }
    }
}
