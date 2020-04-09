package com.hrbust.internet.nio.udp;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.time.LocalDateTime;
import java.util.Scanner;

/**
 * @program: reviewJava
 * @description: 发送端
 * @author: Abner
 * @create: 2020-03-02 21:36
 */
public class Sender {
    public static void main(String[] args) {
        DatagramChannel datagramChannel = null;
        try {
            //获取通道
            datagramChannel = DatagramChannel.open();
            datagramChannel.configureBlocking(false);
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNext()) {
                String str = scanner.next();
                byteBuffer.put((LocalDateTime.now().toString() + "\n" + str).getBytes());
                byteBuffer.flip();
                datagramChannel.send(byteBuffer, new InetSocketAddress("127.0.0.1", 9898));
                byteBuffer.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (datagramChannel != null) {

                try {
                    datagramChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
