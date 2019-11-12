package lesson05.task01;
/**
 * Программа – картотека домашних животных.
 * У каждого животного есть уникальный идентификационный номер, кличка, хозяин (объект класс Person с полями – имя, возраст, пол), вес.
 * ДЗ_5
 * @author Михаил Копылов
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {

        Person tom = new Person("Том", 15, true);
        Person bob = new Person("Боб", 16, true);
        Person sia = new Person("Сара", 18, false);
        Pet cat1 = new Pet(1, "Мурзик", tom, 6.5);
        Pet cat2 = new Pet(2, "Пушок", sia, 5.5);
        Pet cat3 = new Pet(3, "Маркиз", bob, 4.5);
        Pet dog1 = new Pet(4, "Шарик", bob, 15.5);
        Pet dog2 = new Pet(5, "Бобик", tom, 16.5);
        Pet dog3 = new Pet(6, "Тузик", tom, 12.5);
        PetCards cards = new PetCards();

        //используем метод добавления животного в общий список
        cards.setPet(cat1);
        cards.setPet(cat2);
        cards.setPet(cat3);
        cards.setPet(dog1);
        cards.setPet(dog2);
        cards.setPet(dog3);
        try {
            cards.setPet(cat1); //добавление дубликата приводит к исключительной ситуации
        } catch (ArrayStoreException e) {
            System.out.println(e.toString());
        }

        System.out.println(cards.toString()); //проверка метода toString() и вывод на экран текущей картотеки

        Pet searchingPet1 = cards.searchPet("Борис"); //поиск несуществующего животного возвращает null
        Pet searchingPet2 = cards.searchPet("Мурзик");
        try {
            System.out.println(searchingPet1.toString()); //попытка вывода результата поиска несуществующего животного приведет к NPE
        } catch (NullPointerException e) {
            System.out.println(e.toString());
        }

        System.out.println(searchingPet2.toString()); //вывод результата поиска животного по имени "Murzik"

        cards.changePet(1, "Пушок", sia, 4.5); //проверка метода изменения данных животного по его идентификатору
        System.out.println(cards.toString());

        cards.sortString(); //вывод на экран списка животных в отсортированном порядке. Поля для сортировки –  хозяин, кличка животного, вес.
    }
}
