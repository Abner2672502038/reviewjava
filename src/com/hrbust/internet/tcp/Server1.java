package com.hrbust.internet.tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @program: reviewJava
 * @description: 服务器
 * @author: Abner
 * @create: 2020-03-01 17:15
 */
public class Server1 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(6667);
        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();

       // FileWriter fw = new FileWriter(new File("E:\\WorkSpace\\Inteljidea\\reviewJava\\src\\file\\环境变量配置bat1.txt"));
        FileOutputStream fos = new FileOutputStream(new File("E:\\WorkSpace\\Inteljidea\\reviewJava\\src\\file\\环境变量配置bat1.txt"));

        byte[] bucf = new byte[1024];
        int len;
        while ((len = inputStream.read(bucf)) != -1) {
            fos.write(bucf,0,len);

        }
        /*isr.close();
        osw.close();*/
        fos.close();
        inputStream.close();
        socket.close();
        serverSocket.close();

    }
}
