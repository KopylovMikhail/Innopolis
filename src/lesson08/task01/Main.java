package lesson08.task01;

import java.io.*;

/**
 * Необходимо разработать класс, реализующий следующие методы:
 * void serialize (Object object, String file);
 * Object deSerialize(String file).
 * ДЗ_8.1
 * @author Михаил Копылов
 * @version 1.0
 */
public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Pet pet = new Pet(1, "Jimmy", 5.5);
        String path = "C:\\temp\\ser.txt";

        System.out.println(pet);
        serialize(pet, path);
//        serialize(new Pet(2, "Dick", 4.5), path);
        Pet pet2 = (Pet) deSerialize(path);
        System.out.println(pet2);
    }

    /**
     * Метод выполняет сериализацию объекта Object в файл file
     */
    private static void serialize(Object object, String file) throws IOException {

        FileOutputStream outputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

        objectOutputStream.writeObject(object);
        objectOutputStream.close();
    }

    /**
     * Метод выполняет десериализацию объекта из файла file
     */
    private static Object deSerialize(String file) throws IOException, ClassNotFoundException {

        Object object;
        FileInputStream fileInputStream = new FileInputStream(file);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        object = objectInputStream.readObject();
        return object;
    }
}
