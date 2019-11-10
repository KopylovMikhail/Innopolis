package lesson03.task02;
/**
 * Программа проверяет работу методов созданного класса ObjectBox
 * ДЗ_3, задание 2
 * @author Михаил Копылов
 * @version 1.1
 */
public class Main {
    public static void main(String[] args) {

        ObjectBox ob = new ObjectBox();

        ob.addObject((Integer) 5);
        ob.addObject((Double) 6.3);
        ob.addObject("Hello!");
        ob.addObject(new int[]{3, 4, 5});
        ob.addObject(new Object());
        System.out.println(ob.dump());
        ob.deleteObject(5);
        System.out.println(ob.dump());
    }
}
