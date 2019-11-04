package lesson02.task03;

/**
 * Класс характеризут пол человека
 */
public enum Sex {

    MAN ("Man"),
    WOMAN ("Woman");

    private String title;

    Sex(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return title;
    }
}
