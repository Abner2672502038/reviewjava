package com.hrbust.internet.nio.tcp;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.time.LocalDateTime;
import java.util.Scanner;

/**
 * @program: reviewJava
 * @description: 客户端
 * @author: Abner
 * @create: 2020-03-02 21:01
 */
public class Client {
    public static void main(String[] args) {
        //获取通道
        SocketChannel socketChannel = null;
        try {
            socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 6666));
            //切换非阻塞模式
            socketChannel.configureBlocking(false);
            //分派缓存区
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            //发送数据到服务器
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNext()) {
                String str = scanner.next();
                byteBuffer.put((LocalDateTime.now().toString() + "\n" + str).getBytes());
                byteBuffer.flip();
                socketChannel.write(byteBuffer);
                byteBuffer.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭通道
            if (socketChannel != null) {
                try {
                    socketChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
