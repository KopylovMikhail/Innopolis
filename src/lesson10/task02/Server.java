package lesson10.task02;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;

/**
 * Серверная часть многопользовательского чата по протоколу UDP
 * ДЗ_10
 * @author Михаил Копылов
 * @version 1.0
 */
public class Server {

    private static final int SERVER_PORT = 4999; // прослушиваемый порт
    private static final int REPLY_PORT = 5001; // порт для широковещательного ответа
    private static final String IP_BROADCAST = "192.168.0.255"; //широковещательный IP-адрес


    public static void main(String[] args) {

        try {

            DatagramSocket socket = new DatagramSocket(SERVER_PORT); //создаем сокет
            byte[] buffer = new byte[65536]; //буфер для получения входящих данных
            DatagramPacket incoming = new DatagramPacket(buffer, buffer.length); //входящий пакет
            Map<InetAddress, String> map = new HashMap<>(); //карта IP-адресов клиентов и их имен
            InetAddress broadcastAddr = InetAddress.getByName(IP_BROADCAST); //устанавливаем широковещательный адрес

            System.out.println("Ожидаем данные...");

            while(true) {
                //Получаем данные
                socket.receive(incoming);
                InetAddress clientAddr = incoming.getAddress(); //получаем адрес клиента
                byte[] data = incoming.getData();
                String inStr = new String(data, 0, incoming.getLength()); //полученная строка
                String s; //строка для вывода в чат
                String firstWord; //первое слово сообщения
                InetAddress unicastAddr = null; //unicast-адрес для отправки личного сообщения
                boolean flagUnicast = false;

                System.out.println("Сервер получил: " + inStr);
                //если клиент написал впервые - присваиваем ему имя, иначе - выводим его сообщение в чат
                if (!map.containsKey(clientAddr)) {
                    map.put(clientAddr, inStr);
                    s = "К чату присоединился: " + inStr;
                } else {
                    firstWord = inStr.contains(" ") ? inStr.substring(0, inStr.indexOf(' ')) : inStr;
                    //если первое слово совпадает с именем клиента, то присваиваем адрес клиента переменной unicastAddr
                    for(Map.Entry<InetAddress, String> entry : map.entrySet()) {
                        if (entry.getValue().equals(firstWord)) {
                            unicastAddr = entry.getKey();
                            flagUnicast = true;
                            break;
                        }
                    }
                    s = map.get(clientAddr) + " написал: " + inStr;
                }

                System.out.println(s);

                if (flagUnicast) {
                    //Отправляем данные конкретному клиенту
                    s = "(приватно) " + s;
                    DatagramPacket packet = new DatagramPacket(s.getBytes() , s.getBytes().length , unicastAddr , REPLY_PORT);
                    socket.send(packet);
                } else if (inStr.equals("quit")) { //выполняем действия если написана команда выхода из чата
                    s = map.get(clientAddr) + " покинул чат";
                    map.remove(clientAddr); //удаляем из карты имя и IP-адрес вышедшего клиента
                    //Отправляем данные по широковещательному адресу
                    DatagramPacket packet = new DatagramPacket(s.getBytes() , s.getBytes().length , broadcastAddr , REPLY_PORT);
                    socket.setBroadcast(true); //разрешаем широковещательную рассылку
                    socket.send(packet);
                    //Отправляем сообщение обратно клиенту
                    DatagramPacket packetQuit = new DatagramPacket(inStr.getBytes() , inStr.getBytes().length , incoming.getAddress() , REPLY_PORT);
                    socket.send(packetQuit);
                } else {
                    //Отправляем данные по широковещательному адресу
                    DatagramPacket packet = new DatagramPacket(s.getBytes() , s.getBytes().length , broadcastAddr , REPLY_PORT);
                    socket.setBroadcast(true); //разрешаем широковещательную рассылку
                    socket.send(packet);
                }
                //Отправляем данные конкретному клиенту
//                DatagramPacket packet = new DatagramPacket(s.getBytes() , s.getBytes().length , incoming.getAddress() , incoming.getPort());
                //Отправляем данные по широковещательному адресу
//                DatagramPacket packet = new DatagramPacket(s.getBytes() , s.getBytes().length , broadcastAddr , REPLY_PORT);
//                socket.setBroadcast(true); //разрешаем широковещательную рассылку
//                socket.send(packet);
            }
        }

        catch(IOException e) {
            e.printStackTrace();
        }
    }
}
