package com.hrbust.internet.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.nio.channels.DatagramChannel;

/**
 * @program: reviewJava
 * @description: 接收端
 * @author: Abner
 * @create: 2020-03-01 21:10
 */
public class receiver {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(6666);
        byte[] bytes = new byte[1024];
        DatagramPacket packet = new DatagramPacket(bytes, 0, bytes.length);
        socket.receive(packet);

        System.out.println(new String(packet.getData(),0,packet.getLength()));

    }
}
