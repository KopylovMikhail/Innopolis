package lesson10.task01;

import java.net.DatagramSocket;
import java.net.SocketException;

public class ClientUDP {

    public static void main(String[] args) {

        try {
            DatagramSocket socket = new DatagramSocket();
            MessageSender sender = new MessageSender("127.0.0.1", 4999, socket);
            MessageReceiver receiver = new MessageReceiver(socket);

            Thread sendT = new Thread(sender);
            Thread receiveT = new Thread(receiver);
            sendT.start();
            receiveT.start();
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }
}
