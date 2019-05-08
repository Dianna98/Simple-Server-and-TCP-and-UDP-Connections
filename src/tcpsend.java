import java.io.*;
import java.net.*;


public class tcpsend {

    public static void main (String[] args ) throws IOException {
        Socket socket = new Socket("svm-km2-nets.ecs.soton.ac.uk",5002);

        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        out.println("dac1u17");
        System.out.println(in.readLine());
    }
}