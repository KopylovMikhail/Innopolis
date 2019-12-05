package lesson09.task01;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.*;

/**
 * Программа с консоли построчно считывает код метода doWork.
 * Считанные строки добавляются в тело метода public void doWork() в файле SomeClass.java
 * Файл SomeClass.java компилируется программой (в рантайме) в файл SomeClass.class.
 * Полученный файл подгружается в программу с помощью кастомного загрузчика.
 * Метод, введенный с консоли, исполняется в рантайме.
 * ДЗ_9
 * @author Михаил Копылов
 * @version 1.0
 */
public class Main {

    private static String file = "src\\lesson09\\task01\\SomeClass.java";

    public static void main(String[] args) {

        String methodName = "doWork()";
        String code;
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();

        code = readCode(); //считываем код из консоли
//        System.out.println(code);
        writeCode(code, methodName, file); //записываем код в метод
        compiler.run(null, null, null, file); //компилируем файл SomeClass.java в файл SomeClass.class
        useCustomClassLoader(); //подгржаем файл в программу с помощью кастомного загрузчика
    }

    /**
     * Метод построчно считывает код с консоли, пока не введена пустая строка
     */
    private static String readCode() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        String s;

        try {
            do {
                s = reader.readLine();
                sb.append(s).append("\r\n");
                } while (!s.isEmpty());
            } catch (IOException e) {
            e.printStackTrace();
            }
        return sb.toString();
    }

    /**
     * Метод построчно пишет код code в метод methodName файла file
     */
    private static void writeCode(String code, String methodName, String file) {

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            StringBuffer sb = new StringBuffer();
            String line;

            while ((line = reader.readLine()) != null) {
                if (line.contains(methodName)) {
                    sb.append(line).append("\r\n").append(code);
                    line = reader.readLine();
                }
                sb.append(line).append("\r\n");
            }
//            System.out.println(sb.toString());
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(sb.toString());
            writer.flush();
            writer.close();
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод загрузки из байт-кода
     */
    private static void useCustomClassLoader() {
        ClassLoader cl = new MyClassloader("src\\lesson09\\task01\\SomeClass.class");
        Class<?> someClass = null;
        try {
            someClass = cl.loadClass("lesson09.task01.SomeClass");
            Worker someWorker = (Worker) someClass.newInstance();
            someWorker.doWork();
            } catch (ClassNotFoundException e) {
            e.printStackTrace();
            } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

}
