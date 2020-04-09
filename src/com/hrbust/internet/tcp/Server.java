package com.hrbust.internet.tcp;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @program: reviewJava
 * @description: 服务端
 * @author: Abner
 * @create: 2020-03-01 16:01
 */
public class Server {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream inputStream = null;
        ByteArrayOutputStream baos = null;
        try {
            //建立socktserver连接
            serverSocket = new ServerSocket(6666);
            //接受连接
            socket = serverSocket.accept();
            //获取流
            inputStream = socket.getInputStream();
            baos = new ByteArrayOutputStream();
            byte[] bucf=new byte[20];
            int len;
            while ((len = inputStream.read(bucf)) != -1) {
                baos.write(bucf, 0, len);
            }
            //输出资源
            System.out.println(baos.toString());
            System.out.println("受到来自" + socket.getInetAddress().getHostAddress());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (baos != null) {
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if (inputStream!= null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if (socket!= null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }


        }


    }
}
