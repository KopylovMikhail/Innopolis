package lesson10.task01;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class MessageReceiver implements Runnable {

    private DatagramSocket socket;

    public MessageReceiver(DatagramSocket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        while (true) {
            try {
                byte[] buffer = new byte[65536];
                DatagramPacket reply = new DatagramPacket(buffer, buffer.length);
                socket.receive(reply);
                byte[] data = reply.getData();
                String str = new String(data, 0, reply.getLength());
                System.out.println(str);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
