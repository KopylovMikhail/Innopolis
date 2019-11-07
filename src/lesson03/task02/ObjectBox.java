package lesson03.task02;

import java.util.HashSet;
import java.util.Set;

/**Класс хранит коллекцию Object*/
public class ObjectBox<T extends Object> {

    private Set<Object> setObj = new HashSet<>();

    /**метод addObject добавляет объект в коллекцию*/
    public void addObject(Object o) {
        setObj.add(o);
    }

    /**метод deleteObject проверяет наличие объекта в коллекции и при наличии удаляет его*/
    public void deleteObject(Object o) {
        setObj.remove(o);
    }

    /**метод dump выводит содержимое коллекции в строку*/
    public String dump() {
        return setObj.toString();
    }
}
