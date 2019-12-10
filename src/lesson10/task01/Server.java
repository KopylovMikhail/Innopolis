package lesson10.task01;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;

/**
 * Серверная часть многопользовательского чата
 * ДЗ_10
 * @author Михаил Копылов
 * @version 1.0
 */
public class Server {

    private static final int SERVER_PORT = 4999; // Прослушиваемый порт

    public static void main(String[] args) {

        try {
            //Создаем сокет
            DatagramSocket socket = new DatagramSocket(SERVER_PORT);

            //буфер для получения входящих данных
            byte[] buffer = new byte[65536];
            DatagramPacket incoming = new DatagramPacket(buffer, buffer.length);

            System.out.println("Ожидаем данные...");

            Map<InetAddress, String> map = new HashMap<>(); //карта ip-адресов клиентов и их имен
            InetAddress broadcastAddr = InetAddress.getByName("255.255.255.255"); //устанавливаем широковещательный адрес

            while(true) {
                //Получаем данные
                socket.receive(incoming);
                InetAddress clientAddr = incoming.getAddress(); //получаем адрес клиента
                byte[] data = incoming.getData();
                String s = new String(data, 0, incoming.getLength());

                System.out.println("Сервер получил: " + s);
                //если клиент написал впервые - присваиваем ему имя, иначе - выводим его сообщение в чат
                if (!map.containsKey(clientAddr)) {
                    map.put(clientAddr, s);
                    s = "К чату присоединился: " + s;
                } else {
                    s = map.get(clientAddr) + " написал: " + s;
                }

                System.out.println(s);

                //Отправляем данные конкретному клиенту
//                DatagramPacket dp = new DatagramPacket(s.getBytes() , s.getBytes().length , incoming.getAddress() , incoming.getPort());
                //Отправляем данные по широковещательному адресу
                DatagramPacket packet = new DatagramPacket(s.getBytes() , s.getBytes().length , broadcastAddr , incoming.getPort());
                socket.setBroadcast(true);
                socket.send(packet);
            }
        }

        catch(IOException e) {
            e.printStackTrace();
        }
    }
}
