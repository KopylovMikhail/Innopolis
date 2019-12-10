package lesson10.task01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Класс отправки сообщений по протоколу UDP
 */
public class MessageSender implements Runnable { //имплементим Runnable для возможности запуска в отдельном потоке

    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private String serverAddr;
    private int serverPort;
    private DatagramSocket socket;

    public MessageSender(String serverAddr, int serverPort, DatagramSocket socket) {
        this.serverAddr = serverAddr;
        this.serverPort = serverPort;
        this.socket = socket;
    }

    /**Метод отправки сообщения по протоколу UDP*/
    private void sendMessage(String s) throws IOException {
        byte[] b = s.getBytes();
        DatagramPacket packet = new DatagramPacket(b, b.length, InetAddress.getByName(serverAddr), serverPort);
        socket.send(packet);
    }

    @Override
    public void run() {

        System.out.println("Введите имя: "); //первым сообщением вводим имя
        while (true) {
            try {
                String s;
                s = reader.readLine(); //считываем с консоли и отправляем
                sendMessage(s);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
