package com.hrbust.internet.tcp;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @program: reviewJava
 * @description: 客户端
 * @author: Abner
 * @create: 2020-03-01 16:01
 */
public class Client {
    public static void main(String[] args) {
        Socket socket = null;
        OutputStream os = null;
        try {
            //1.创建Socket
            socket = new Socket("127.0.0.1", 6666);
            //2.获取输出流
            os = socket.getOutputStream();
            os.write("天王盖地虎".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //3.关闭资源
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }


    }
}
