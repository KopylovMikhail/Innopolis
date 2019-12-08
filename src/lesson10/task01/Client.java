package lesson10.task01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Класс клиентской части многопользовательского чата
 * ДЗ_10
 * @author Михаил Копылов
 * @version 1.0
 */
public class Client {

    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String serverAddr;
    int serverPort;

    public Client(String serverAddr, int serverPort) {
        this.serverAddr = serverAddr;
        this.serverPort = serverPort;
    }

    void start() throws IOException {
        DatagramSocket socket = new DatagramSocket();

        System.out.println("Введите имя: ");

        while(true) {
            //Ожидаем ввод сообщения серверу
            String s = reader.readLine();
            byte[] b = s.getBytes();

            //Отправляем сообщение
            DatagramPacket packet = new DatagramPacket(b, b.length, InetAddress.getByName(serverAddr), serverPort);
            socket.send(packet);

            //буфер для получения входящих данных
            byte[] buffer = new byte[65536];
            DatagramPacket reply = new DatagramPacket(buffer, buffer.length);

            //Получаем данные
            socket.receive(reply);
            byte[] data = reply.getData();
            s = new String(data, 0, reply.getLength());

//                System.out.println("Сервер: " + reply.getAddress().getHostAddress() + ", порт: " + reply.getPort() + ", получил: " + s);
            System.out.println(s);
        }
    }
}
