package java8.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class GreetingServer extends Thread {
    // 为服务器程序提供了一种来监听客户端，并与他们建立连接的机制。
    // 服务器实例化一个 ServerSocket 对象，表示通过服务器上的端口通信。
    private ServerSocket serverSocket;

    public GreetingServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        serverSocket.setSoTimeout(30000);
    }

    // @Override
    public void run() {
        while (true) {
            try {
                // 该方法将一直等待，直到客户端连接到服务器上给定的端口。
                System.out.println("等待远程连接, 端口号为: " + serverSocket.getLocalPort());
                // accept() 方法返回服务器上一个新的 socket 引用，该 socket 连接到客户端的 socket。
                Socket server = serverSocket.accept();
                System.out.println("远程主机地址 " + server.getRemoteSocketAddress());

                // 接受客户端的响应
                DataInputStream in = new DataInputStream(server.getInputStream());
                System.out.println(in.readUTF());

                // 发送给客户端
                DataOutputStream out = new DataOutputStream(server.getOutputStream());
                out.writeUTF("感谢连接 " + server.getLocalSocketAddress() + " bye");
                server.close();
            } catch (SocketTimeoutException e) {
                System.out.println("socket time out");
                break;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        int port = Integer.parseInt(args[0]);
        try {
            Thread t = new GreetingServer(port);
            t.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
