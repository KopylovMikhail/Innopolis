package lesson10.task01;

import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * Клиентская часть многопользовательского чата по протоколу UDP
 * ДЗ_10
 * @author Михаил Копылов
 * @version 1.1
 */
public class ClientUDP {

    private static final int SERVER_PORT = 4999; // порт для отправки сообщений серверу
    private static final int REPLY_PORT = 5001; // порт для получения ответа от сервера
    private static final String SERVER_IP = "192.168.0.242"; //IP-адрес сервера

    public static void main(String[] args) {

        try {
            DatagramSocket socketOut = new DatagramSocket(); //создаем сокет для отправки сообщений
            DatagramSocket socketIn = new DatagramSocket(REPLY_PORT); //создаем сокет для получения сообщений и задаем ему порт
            MessageSender sender = new MessageSender(SERVER_IP, SERVER_PORT, socketOut); //объект класса отправки сообщений
            MessageReceiver receiver = new MessageReceiver(socketIn); //объект класса получения сообщений

            //стартуем отправку и получение сообщений в двух разных потоках
            Thread sendT = new Thread(sender);
            Thread receiveT = new Thread(receiver);
            sendT.start();
            receiveT.start();
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }
}
