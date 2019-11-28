package lesson08.task01;

import java.io.Serializable;

/**Класс Pet (домашнее животное) с полями – уникальный идентификационный номер, кличка, вес*/
public class Pet implements Serializable {

    private static final long serialVersionUID = 1596928621350464933L;

    private int uid;
    private String name;
    private double weight;

    public Pet() {
    }

    public Pet(int uid, String name, double weight) {
        this.uid = uid;
        this.name = name;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "uid=" + uid +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }
}
