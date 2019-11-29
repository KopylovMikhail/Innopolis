package lesson08.task01;

/**Класс Pet (домашнее животное) с полями – уникальный идентификационный номер, кличка, вес*/
public class Pet {

    private String country = "RU";
    private int uid;
    private String name;
    private double weight;
    private Person owner;

    public Pet() {
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public Pet(int uid, String name, double weight, Person owner) {
        this.uid = uid;
        this.name = name;
        this.weight = weight;
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "uid=" + uid +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                ", owner=" + owner.getName() +
                ", country=" + country +
                '}';
    }
}
