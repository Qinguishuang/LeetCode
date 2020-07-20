package tcp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    private Socket socket;

    public Client() throws IOException {
        socket = new Socket("localhost", 12345);
    }
    public void start() throws IOException {
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
        pw.println("你好，客户端");
    }

    public static void main(String[] args) throws IOException {
        Client client = new Client();
        client.start();
    }
}
