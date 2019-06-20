package com.myspringtest.test.studyTest;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

public class NIOClient {
    public static void main(String[] args) throws Exception{
        SocketChannel socketChannel= SocketChannel.open();
        socketChannel.configureBlocking(false);
        socketChannel.connect(new InetSocketAddress("127.0.0.1",8080));
        while (!socketChannel.finishConnect()){
            //没连接上一直等待
            Thread.yield();
        }
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入：");
        //发送内容
        String content=scanner.nextLine();
        ByteBuffer buffer=ByteBuffer.wrap(content.getBytes());
        while (buffer.hasRemaining()){
            socketChannel.write(buffer);
        }
        //读取响应
        System.out.println("收到服务端响应：");
        ByteBuffer requestBuffer=ByteBuffer.allocate(1024);

        while (socketChannel.isOpen()&&socketChannel.read(requestBuffer)!=-1){
            //长链接情况下，需要判断数据有没有读取结束（此处认为超过0字节就认为是成功饿了）
            if (requestBuffer.position()>0){break;}
        }
        requestBuffer.flip();
        byte[] receiveContent=new byte[requestBuffer.limit()];
        requestBuffer.get(receiveContent);
        System.out.println(new String(receiveContent));
        scanner.close();
        socketChannel.close();

    }





}
