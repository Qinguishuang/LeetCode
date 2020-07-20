package tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Service {
    private ServerSocket server;

    public Service() throws IOException {
        server = new ServerSocket(12345);
    }

    public void start() throws IOException {
        Socket socket = server.accept();
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String message = br.readLine();
        System.out.println(message);
    }

    public static void main(String[] args) throws IOException {
        Service s = new Service();
        s.start();
    }
}
