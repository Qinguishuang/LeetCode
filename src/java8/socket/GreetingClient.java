package java8.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class GreetingClient {
    public static void main(String[] args) {
        String serverName = args[0];
        int port = Integer.parseInt(args[1]);
        try {
            // 客户端和服务器现在可以通过对 Socket 对象的写入和读取来进行通信。
            System.out.println("连接主机 " + serverName + " 端口号 " + port);
            // 一个客户端实例化一个 Socket 对象，指定服务器名称和端口号来请求连接。
            Socket client = new Socket(serverName, port);
            System.out.println("远程主机地址" + client.getRemoteSocketAddress());

            // 发送给服务器
            OutputStream outToServer = client.getOutputStream();
            DataOutputStream out = new DataOutputStream(outToServer);
            out.writeUTF("hello from " + client.getLocalSocketAddress());

            // 接受服务器响应
            InputStream inFromServer = client.getInputStream();
            DataInputStream in = new DataInputStream(inFromServer);
            System.out.println("服务器响应 " + in.readUTF());
            client.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
