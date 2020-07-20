package java8.NIO;

import java.net.Socket;
import java.util.Date;

/**
 * 客户端 发起请求
 * <p>
 * 客户端创建多个线程依次连接服务端并向其发送"当前时间+:hello world"
 */
public class IOClient {

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                Socket socket = new Socket("localhost", 1234);
                while (true) {
                    // OutputStream 想服务器发送数据
                    socket.getOutputStream().write((new Date() + ": hello").getBytes());
                    Thread.sleep(2000);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }
}
