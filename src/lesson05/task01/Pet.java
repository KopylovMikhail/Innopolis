package lesson05.task01;

import java.util.Comparator;

/**Класс Pet (домашнее животное) с полями – уникальный идентификационный номер, кличка, хозяин (Person), вес*/
public class Pet implements Comparable<Pet> {

    private int uid;
    private String name;
    private Person owner;
    private double weight;

    public Pet() {
    }

    public Pet(int uid, String name, Person owner, double weight) {
        this.uid = uid;
        this.name = name;
        this.owner = owner;
        this.weight = weight;
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

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setAll (String name, Person owner, double weight) {
        this.name = name;
        this.owner = owner;
        this.weight = weight;
    }

    //компаратор по хозяину, кличке животного и весу
    public static Comparator<Pet> CompByOwnerNameWeight = new Comparator<Pet>() {

        @Override
        public int compare(Pet p1, Pet p2) {
            int flag = p1.getOwner().getName().compareTo(p2.getOwner().getName());
            if (flag == 0) flag = p1.getName().compareTo(p2.getName());
            if (flag == 0) flag = (int) (p1.getWeight() - p2.getWeight());
            return flag;
        }
    };

    @Override
    public String toString() {
        return "Pet{" +
                "uid=" + uid +
                ", name='" + name + '\'' +
                ", owner=" + owner.getName() +
                ", weight=" + weight +
                '}';
    }

    @Override
    public int compareTo(Pet p) {
        return (this.uid - p.uid);
    }
}
