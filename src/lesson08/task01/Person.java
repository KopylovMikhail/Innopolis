package lesson08.task01;

/**Класс Person с полями – имя, возраст, пол*/
public class Person {

    private String name;
    private int age;
    private boolean sex; //true - man, false - woman

    public Person() {
    }

    public Person(String name, int age, boolean sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean getSex() { return sex; }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }

    public String serString() {

        return name + "\r\n" + age + "\r\n" + sex;
    }
}
