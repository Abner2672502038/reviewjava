package com.hrbust.internet.nio;

import com.sun.corba.se.impl.interceptors.PICurrent;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

/**
 * @program: reviewJava
 * @description: 管道:用于两个线程传输数据
 * @author: Abner
 * @create: 2020-03-02 22:02
 */
public class PipeDemo {
    public static void main(String[] args) {
        try {
            Pipe pipe = Pipe.open();
            WritableByteChannel sinkChannel = pipe.sink();
            ReadableByteChannel sourceChannel = pipe.source();
            new Thread1(sinkChannel).start();
            new Thread2(sourceChannel).start();

         /*   ByteBuffer buffer = ByteBuffer.allocate(1024);
            //while (readableByteChannel.read(buffer) >= 0) {
            sourceChannel.read(buffer);
            buffer.flip();
           *//* byte[] bytes = new byte[buffer.remaining()];
            buffer.get(bytes);
            String str = new String(bytes);*//*
            System.out.println(new String(buffer.array(),0,buffer.limit()));
            buffer.clear();*/

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

class Thread1 extends Thread {
    private  WritableByteChannel sinkChannel = null;

    public Thread1( WritableByteChannel sinkChannel) {
        this.sinkChannel = sinkChannel;
    }

    @Override
    public void run() {
        try {
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            //将缓存区中的数据读入到管道中
            buffer.put("你真好看".getBytes());
            buffer.flip();
            sinkChannel.write(buffer);
            buffer.clear();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sinkChannel != null) {

                try {
                    sinkChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}

class Thread2 extends Thread {
    ReadableByteChannel sourceChannel= null;

    public Thread2(ReadableByteChannel sourceChannel) {

        this.sourceChannel = sourceChannel;
    }

    @Override
    public void run() {
        try {
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            //注意sourceChannel.read(buffer);buffer.flip();的前后顺序
            sourceChannel.read(buffer);
            buffer.flip();
            System.out.println(new String(buffer.array(),0,buffer.limit()));
            buffer.clear();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sourceChannel != null) {

                try {
                    sourceChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}