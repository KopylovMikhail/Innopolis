package lesson10.task01;

import java.io.IOException;

/**
 * Клиент многопользовательского чата
 */
public class Client_01 {

    public static void main(String[] args) {
        Client client_01 = new Client("127.0.0.1", 4999);
        try {
            client_01.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
