package com.hrbust.internet.tcp;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @program: reviewJava
 * @description: 客户端
 * @author: Abner
 * @create: 2020-03-01 17:03
 */
public class Client1 {
    //用try{}catch{}finally包裹
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 6667);
        OutputStream outputStream = socket.getOutputStream();
        FileInputStream fis = new FileInputStream(new File("E:\\WorkSpace\\Inteljidea\\reviewJava\\src\\file\\环境变量配置.txt"));
        byte[] bucf = new byte[1024];
        int len;
        while ((len = fis.read(bucf)) != -1) {
            outputStream.write(bucf,0,len);
        }
        socket.shutdownOutput();
        fis.close();
        outputStream.close();
        socket.close();

    }

}
