package lesson09.task01;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Кастомный загрузчик
 */
public class MyClassloader extends ClassLoader {

    /**
     * Константа с именем класса
     */
    private static final String CLASS_NAME = "lesson09.task01.SomeClass";
    private String file;

    public MyClassloader(String file) {

        this.file = file;
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        if (CLASS_NAME.equals(name)) {
            return findClass(name);
        }
        return super.loadClass(name);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        if (CLASS_NAME.equals(name)) {
            try {
                byte[] bytes = Files.readAllBytes(Paths.get(file));
                return defineClass(name, bytes, 0, bytes.length);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return super.findClass(name);
    }
}
