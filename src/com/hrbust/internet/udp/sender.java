package com.hrbust.internet.udp;

import java.io.IOException;
import java.net.*;

/**
 * @program: reviewJava
 * @description: 发送端
 * @author: Abner
 * @create: 2020-03-01 21:03
 */
public class sender {
    public static void main(String[] args)  {
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket();
            String str = "长的真好看";
            byte[] data = str.getBytes();
            DatagramPacket packet = new DatagramPacket(data, 0, data.length, InetAddress.getLocalHost(), 6666);
            socket.send(packet);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                socket.close();

            }
        }

    }
}
