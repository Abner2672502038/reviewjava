package com.hrbust.internet.nio.tcp;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * @program: reviewJava
 * @description: 服务端
 * @author: Abner
 * @create: 2020-03-02 21:02
 */
public class Server {
    public static void main(String[] args) {
        ServerSocketChannel serverSocketChannel = null;
        try {
            //获取通道
            serverSocketChannel = ServerSocketChannel.open();
            //切换非阻塞模式
            serverSocketChannel.configureBlocking(false);
            //绑定连接
            serverSocketChannel.bind(new InetSocketAddress(6666));
            //获取一个选择器
            Selector selector = Selector.open();
            //将通道注册到选择器上,并指定监听事件,
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);//接受
            //轮询的获取选择器上的已经准备就绪的事件
            while (selector.select() > 0) {
                //获取当前选择器所有注册"选择键"(已经准备就绪的监听是事件)
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                //获取准备就绪的事件
                while (iterator.hasNext()) {
                    SelectionKey selectionKey = iterator.next();
                    //判断具体是什么事件就绪
                    if (selectionKey.isAcceptable()) {//就收就绪
                        //若准备就绪,获取客户端连接
                        SocketChannel socketChannel = serverSocketChannel.accept();
                        //切换到非阻塞模式
                        socketChannel.configureBlocking(false);
                        //将该通道注册到选择器上,并检测读事件
                        socketChannel.register(selector, SelectionKey.OP_READ);

                    } else if (selectionKey.isReadable()) {//读就绪
                        //获取读就绪通道
                        SocketChannel readChannel = (SocketChannel) selectionKey.channel();
                        //读取数据
                        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                        int len;
                        while ((len = readChannel.read(byteBuffer)) >0) {
                            byteBuffer.flip();//读模式
                            System.out.println(new String(byteBuffer.array(), 0, len));
                            byteBuffer.clear();

                        }
                    }
                    //取消选择键
                   iterator.remove();
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocketChannel != null) {
                try {
                    serverSocketChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

        }
    }
 /*  public static void main(String[] args) throws IOException {
       //1. 获取通道
       ServerSocketChannel ssChannel = ServerSocketChannel.open();

       //2. 切换非阻塞模式
       ssChannel.configureBlocking(false);

       //3. 绑定连接
       ssChannel.bind(new InetSocketAddress(6666));

       //4. 获取选择器
       Selector selector = Selector.open();

       //5. 将通道注册到选择器上, 并且指定“监听接收事件”
       ssChannel.register(selector, SelectionKey.OP_ACCEPT);

       //6. 轮询式的获取选择器上已经“准备就绪”的事件
       while(selector.select() > 0){

           //7. 获取当前选择器中所有注册的“选择键(已就绪的监听事件)”
           Iterator<SelectionKey> it = selector.selectedKeys().iterator();

           while(it.hasNext()){
               //8. 获取准备“就绪”的是事件
               SelectionKey sk = it.next();

               //9. 判断具体是什么事件准备就绪
               if(sk.isAcceptable()){
                   //10. 若“接收就绪”，获取客户端连接
                   SocketChannel sChannel = ssChannel.accept();

                   //11. 切换非阻塞模式
                   sChannel.configureBlocking(false);

                   //12. 将该通道注册到选择器上
                   sChannel.register(selector, SelectionKey.OP_READ);
               }else if(sk.isReadable()){
                   //13. 获取当前选择器上“读就绪”状态的通道
                   SocketChannel sChannel = (SocketChannel) sk.channel();

                   //14. 读取数据
                   ByteBuffer buf = ByteBuffer.allocate(1024);

                   int len = 0;
                   while((len = sChannel.read(buf)) > 0 ){
                       buf.flip();
                       System.out.println(new String(buf.array(), 0, len));
                       buf.clear();
                   }
               }

               //15. 取消选择键 SelectionKey
               it.remove();
           }
       }
   }*/
}
