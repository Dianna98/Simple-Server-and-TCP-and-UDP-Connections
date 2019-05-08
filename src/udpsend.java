import java.io.*;
import java.net.*;

public class udpsend {

    public static void main (String[] args) throws IOException {
        byte[] input = "dac1u17".getBytes();
        DatagramSocket socket = new DatagramSocket(5005);
        DatagramPacket packet = new DatagramPacket(input, input.length, InetAddress.getByName("svm-km2-nets.ecs.soton.ac.uk"), 5005);
        socket.send(packet);

        packet = new DatagramPacket(input, input.length);
        socket.receive(packet);
        String received = new String(packet.getData());
        socket.close();
        System.out.println(received);
    }
}
