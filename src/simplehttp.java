import java.io.*;
import java.net.*;

public class simplehttp {

    public static void main(String[] args) throws IOException {

        ServerSocket server = new ServerSocket(8080);

        while (true) {
            Socket socket = server.accept();

            new Thread(new Runnable() {
                public void run() {
                    try {
                        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        String line = in.readLine();

                        socket.getOutputStream().write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                        if (line.split(" ")[0].equals("GET")) {
                            socket.getOutputStream().write("dac1u17".getBytes());
                        } else {
                            socket.getOutputStream().write("Error 404".getBytes());
                        }

                        socket.close();
                    } catch (Exception e) {
                        System.err.println(e);
                    }
                }
            }).start();
        }

    }
}