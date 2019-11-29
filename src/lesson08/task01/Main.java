package lesson08.task01;

import java.io.*;
import java.lang.reflect.Field;

/**
 * Необходимо разработать класс, реализующий следующие методы:
 * void serialize (Object object, String file);
 * Object deSerialize(String file).
 * ДЗ_8.1
 * @author Михаил Копылов
 * @version 1.1
 */
public class Main {

    public static void main(String[] args) throws IOException, NoSuchFieldException, IllegalAccessException {

        Person bob = new Person("Bob", 15, true);
        Pet pet = new Pet(1, "Jimmy", 5.5, bob);
        String path = "C:\\temp\\ser.txt";

        System.out.println(pet); //выводим на экран созданный объект Pet
        serialize(pet, path);
        Pet pet1 = deSerialize(path);
        System.out.println(pet1); //выводим на экран объект Pet после десериализации

    }

    /**
     * Метод выполняет сериализацию объекта Pet в файл file
     */
    private static void serialize(Pet pet, String file) throws IOException, NoSuchFieldException, IllegalAccessException {

        BufferedWriter writer = new BufferedWriter(new FileWriter(file));

        Field field = pet.getClass().getDeclaredField("country"); //получаем приватное поле country с помощью рефлексии
        field.setAccessible(true);  //разрешаем доступ к полю country
        //записываем поля объекта pet в txt-файл, каждое с новой строки
        writer.write(pet.getUid()+ "\r\n");
        writer.write(pet.getName()+ "\r\n");
        writer.write(pet.getWeight()+ "\r\n");
        writer.write(pet.getOwner().serString()+ "\r\n");
        writer.write((String) field.get(pet));
        writer.flush();
        writer.close();
    }

    /**
     * Метод выполняет десериализацию объекта из файла file
     */
    private static Pet deSerialize(String file) throws IOException, NoSuchFieldException, IllegalAccessException {

        Pet pet = new Pet();
        BufferedReader reader = new BufferedReader(new FileReader(file));

        Field field = pet.getClass().getDeclaredField("country");
        field.setAccessible(true);
        //считываем построчно поля из txt-файла, записываем в объект pet
        pet.setUid(Integer.parseInt(reader.readLine()));
        pet.setName(reader.readLine());
        pet.setWeight(Double.parseDouble(reader.readLine()));
        pet.setOwner(new Person(reader.readLine(), Integer.parseInt(reader.readLine()), Boolean.parseBoolean(reader.readLine())));
        field.set(pet, reader.readLine());
        return pet;
    }
}
