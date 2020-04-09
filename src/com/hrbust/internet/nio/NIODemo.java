package com.hrbust.internet.nio;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @program: reviewJava
 * @description: 本地文件nio
 * @author: Abner
 * @create: 2020-03-02 14:48
 */
public class NIODemo {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        //copyFile2();//139
        //copyFile();//500
       // copyFile3();//64
        //copyFile4();
        try {
            code();
        } catch (CharacterCodingException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    /**
     * 使用流获取通道和非直接缓存区的方式读取数据
     */
    public static void copyFile() {

        FileInputStream fis = null;
        FileOutputStream fos = null;
        FileChannel inchannel = null;
        FileChannel outchannel = null;
        try {
            fis = new FileInputStream("E:\\WorkSpace\\Inteljidea\\reviewJava\\src\\file\\1.avi");
            fos = new FileOutputStream("E:\\WorkSpace\\Inteljidea\\reviewJava\\src\\file\\2.avi");
            //获取通道
            inchannel = fis.getChannel();
            outchannel = fos.getChannel();

            //获取缓存区,非直接缓存区
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            int len;
            //从通道数据读取到缓存区中
            while ((len = inchannel.read(byteBuffer)) != -1) {
                //切换到读模式
                byteBuffer.flip();
                outchannel.write(byteBuffer);
                //清空缓存区
                byteBuffer.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (outchannel != null) {
                try {
                    outchannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (inchannel != null) {
                try {
                    inchannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 使用NIO.2中的方式获取通道和直接缓存区来复制文件
     * FileChannel
     * SocketChannel等
     */
    public static void copyFile2() {
        FileChannel inChannel = null;
        FileChannel outChannel = null;
        try {
            //用jdk1.7之后的FileChannel来获取通道
            inChannel = FileChannel.open(Paths.get("E:\\WorkSpace\\Inteljidea\\reviewJava\\src\\file\\1.avi"), StandardOpenOption.READ);
            outChannel = FileChannel.open(Paths.get("E:\\WorkSpace\\Inteljidea\\reviewJava\\src\\file\\3.avi"), StandardOpenOption.READ, StandardOpenOption.WRITE, StandardOpenOption.CREATE);
            //获取直接缓存区
            MappedByteBuffer inbuffer = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());
            MappedByteBuffer outbuffer = outChannel.map(FileChannel.MapMode.READ_WRITE, 0, inChannel.size());
            //直接对缓存区的数据操作
            byte[] bucf = new byte[inbuffer.limit()];
            inbuffer.get(bucf);
            outbuffer.put(bucf);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inChannel != null) {
                try {
                    inChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outChannel != null) {
                try {
                    outChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 通道之间数据传输(直接缓存区,物理内存)
     */
    public static void copyFile3() {
        FileChannel inChannel = null;
        FileChannel outChannel = null;
        try {
            inChannel = FileChannel.open(Paths.get("E:\\WorkSpace\\Inteljidea\\reviewJava\\src\\file\\1.avi"), StandardOpenOption.READ);
            outChannel = FileChannel.open(Paths.get("E:\\WorkSpace\\Inteljidea\\reviewJava\\src\\file\\4.avi"), StandardOpenOption.WRITE, StandardOpenOption.CREATE_NEW, StandardOpenOption.READ);
            //inChannel.transferTo(0, inChannel.size(), outChannel);
            outChannel.transferFrom(inChannel, 0, inChannel.size());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inChannel != null) {
                try {
                    inChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if (outChannel != null) {
                try {
                    outChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    /**
     * 分散读取,聚集写入
     */
    public static void copyFile4() {
        RandomAccessFile srcFile = null;
        FileChannel inchannel = null;
        RandomAccessFile destFile = null;
        FileChannel outchannel = null;
        try {
            srcFile = new RandomAccessFile("E:\\WorkSpace\\Inteljidea\\reviewJava\\src\\file\\环境变量配置.txt", "rw");
            //获取通道
            inchannel = srcFile.getChannel();
            //获取缓存区
            ByteBuffer buffer1 = ByteBuffer.allocate(10);
            ByteBuffer buffer2 = ByteBuffer.allocate(100);
            destFile = new RandomAccessFile("E:\\WorkSpace\\Inteljidea\\reviewJava\\src\\file\\环境变量配置4.txt", "rw");
            outchannel = destFile.getChannel();
            //分散读取
            ByteBuffer[] buffers = {buffer1, buffer2};
            int len;

            while((len= (int) inchannel.read(buffers))!=-1) {
                for (ByteBuffer buffer : buffers) {
                    buffer.flip();
                }
                System.out.println(new String(buffer1.array(), 0, buffers[0].limit()));
                System.out.println(new String(buffer2.array(), 0, buffers[1].limit()));
                outchannel.write(buffers);
                for (ByteBuffer buffer : buffers) {
                    buffer.clear();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (inchannel != null) {
                    inchannel.close();
                }
                if (outchannel != null) {
                    outchannel.close();
                }
                if (destFile != null) {
                    destFile.close();
                }
                if (srcFile != null) {
                    srcFile.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    /**
     * 字符集
     */
    public static void code() throws CharacterCodingException {
        Charset gbk = Charset.forName("GBK");
        //获取编码器
        CharsetEncoder charsetEncoder = gbk.newEncoder();
        //获取解码器
        CharsetDecoder charsetDecoder = gbk.newDecoder();
        //获取 缓存区
        CharBuffer charBuffer = CharBuffer.allocate(1024);
        charBuffer.put("哈尔滨理工大学");
        //编码
        charBuffer.flip();
        ByteBuffer byteBuffer = charsetEncoder.encode(charBuffer);
        for (int i = 0; i < byteBuffer.limit(); i++) {
            System.out.println(byteBuffer.get());
        }
        //解码
        byteBuffer.flip();
        CharBuffer charBuffer1 = charsetDecoder.decode(byteBuffer);
        System.out.println(charBuffer1.toString());
        System.out.println("------------------------------------");
        Charset charset = Charset.forName("UTF-8");
        byteBuffer.flip();
        CharBuffer buffer = charset.decode(byteBuffer);
        System.out.println(buffer.toString());
    }
}
