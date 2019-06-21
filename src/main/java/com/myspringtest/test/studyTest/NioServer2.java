package com.myspringtest.test.studyTest;

import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author xcr
 */
public class NioServer2 {

    public static void main(String[] args) throws Exception{
        //创建网络服务断
        ServerSocketChannel serverSocketChannel=ServerSocketChannel.open();
        //设置非阻塞式编程
        serverSocketChannel.configureBlocking(false);
        //构建一个selector选择器，并且将channel注册上去
        Selector selector=Selector.open();
        SelectionKey selectionKey =serverSocketChannel.register(selector,0,serverSocketChannel);
        selectionKey.interestOps(SelectionKey.OP_ACCEPT);

        //绑定端口
        serverSocketChannel.socket().bind(new InetSocketAddress(8080));
        System.out.println("启动成功");
        while (true){
//            SocketChannel socketChannel=serverSocketChannel.accept();
            //不再轮循
            selector.select();
            //获取事件
            Set<SelectionKey> selectionKeys=selector.selectedKeys();
            //便利查询结果
            Iterator<SelectionKey> iterator=selectionKeys.iterator();

            while (iterator.hasNext()){
                SelectionKey key=iterator.next();
                iterator.remove();
                if (key.isAcceptable()){
                    ServerSocketChannel socketChannel= (ServerSocketChannel) key.attachment();
                //将拿到的客户端连接通道，注册到selector上面
                    SocketChannel clientSocketChannel=socketChannel.accept();
                    clientSocketChannel.configureBlocking(false);
                    clientSocketChannel.register(selector,SelectionKey.OP_READ,clientSocketChannel);

                    System.out.println("收到数据。来自："+clientSocketChannel.getRemoteAddress());

                }

                if (key.isReadable()){
                    SocketChannel socketChannel= (SocketChannel) key.attachment();
                    ByteBuffer requestBuffer=ByteBuffer.allocate(1024);
                    try {
                        while (socketChannel.isOpen()&&socketChannel.read(requestBuffer)!=-1){
                            if (requestBuffer.position()>0){break;}
                        }
                        if (requestBuffer.position()==0){continue;}
                        requestBuffer.flip();
                        byte[] c=new byte[requestBuffer.limit()];
                        requestBuffer.get(c);
                        System.out.println(new String(c));

                        System.out.println("收到数据。来自："+socketChannel.getRemoteAddress());

                        //响应结果
                        String response="HTTP/1.1 200 OK\r" +
                                "Content-Length: 11\r\n \r\n" +
                                "Hello Word";
                        ByteBuffer buffer=ByteBuffer.wrap(response.getBytes());
                        while (buffer.hasRemaining()){
                            socketChannel.write(buffer);
                        }

                    }catch (Exception e){
                        e.printStackTrace();
                    }

                }
            }



            }

        }






    }





