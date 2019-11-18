package lesson06.task02;

/**Генератор текста*/
import static java.lang.Math.random;

public class TextGenerator {
    private char[] alphabet = new char[]{'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    private char[] marks = new char[]{'.', '!', '?'}; //знаки пунктуации в конце предложения

    /**метод генерирует строку текста размером size. С вероятностью probability добавляет слова из массива words*/
    public String generate(int size, String[] words, int probability) {
        String text = ""; //строка итогового текста
        int letterCount; //количество букв в слове (1<=n2<=15)
        int wordCount; //количество слов в предложении (1<=n1<=15)
        int sentenceCount; //количество предложений в абзаце (1<=n3<=20)
        boolean comma; //флаг наличия запятой
        boolean probX; //результат вероятности

        while (size > 0) { //пока размер > 0 генерируем текст
            sentenceCount = rnd(1, 20);
            for (int j = 0; j < sentenceCount; j++) { //генерируем заданное количество предложений в абзаце
                wordCount = rnd(1, 15);
                for (int k = 0; k < wordCount; k++) { //генерируем предложение из слов
                    letterCount = rnd(1, 15);
                    probX = random() < 1.0 / probability; //проверяем вероятность появления слова из массива
                    if (!probX) size -= letterCount;
                    for (int l = 0; l < letterCount & !probX; l++) { //генерируем слово из букв, если результат вероятности слова из массива отрицательный
                        if (k == 0 & l == 0)
                            text += Character.toUpperCase(alphabet[rnd(0, 25)]); //если первое слово в предложении и первая буква в слове, то пишем с большой буквы
                        else text += alphabet[rnd(0, 25)];
                    }
                    if (probX) { //если результат вероятности слова из массива положительный
                        String s = words[rnd(0, words.length - 1)]; //берем любое слово из массива
                        if (k == 0)
                            s = s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase(); //если первое слово в предложении, то пишем с большой буквы
                        text += s;
                        size -= s.length();
                        k++;
                    }
                    comma = random() < 0.5; //генерируем флаг запятой
                    if (k < wordCount - 1) { //если не последнее слово в предложении
                        if (comma) {
                            text += ","; //если выставлен флаг запятой, то ставим запятую
                            size -= 1;
                        }
                        text += " "; //ставим пробел
                        size -= 1;
                    }
                }
                text += marks[rnd(0, 2)] + " ";
                size -= 1;
            }
            text += "\n\r";
        }
        return text;
    }

    /**
     * Метод получения псевдослучайного целого числа от min до max (включая max)
     */
    private static int rnd(int min, int max)
    {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }
}
