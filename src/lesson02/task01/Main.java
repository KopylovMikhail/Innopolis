package lesson02.task01;
/**
 * Класс программы ”Hello, World!”, которая выбрасывает различные исключения
 * ДЗ_2, задание 1
 * @author Михаил Копылов
 * @version 1.0
 */
public class Main {

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
//Для просмотра каждого вида исключений необходимо раскомментировать соответствующий метод
        try {
            methodNPE();
            //methodAI();
            //methodUserEx();
        } catch (NullPointerException e) {
            System.out.println(e.toString());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.toString());
        } catch (Exception e) {
            System.out.println(e.toString());
        }

    }

    /**
     * Метод выброса исключения NullPointerException
     */
    public static void methodNPE () {
        throw new NullPointerException();
    }
    /**
     * Метод выброса исключения ArrayIndexOutOfBoundsException
     */
    public static void methodAI () {
        throw new ArrayIndexOutOfBoundsException();
    }
    /**
     * Метод выброса своего варианта исключения
     * @throws Exception данный метод выкидывает исключение MyException
     */
    public static void methodUserEx () throws Exception {
        throw new MyException();
    }
    /**
     * Внутренний класс своего варианта исключения, наследованный от Exception
     */
    private static class MyException extends Exception {
        @Override
        public String toString() {
            return "User's exception";
        }
    }
}
