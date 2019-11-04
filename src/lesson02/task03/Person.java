package lesson02.task03;

/**
 * Класс характеризует человека по трем параметрам: возраст, пол, имя
 */
public class Person {
    public int age;
    public Sex sex;
    public String name;

    public Person(int age, Sex sex, String name) {
        this.age = age;
        this.sex = sex;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", sex=" + sex +
                ", name='" + name + '\'' +
                '}';
    }
}
