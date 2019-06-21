package com.myspringtest.test.studyTest;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @author xcr
 */
public class NioServer {
    public static void main(String[] args) throws Exception{
    //创建网络服务断
        ServerSocketChannel serverSocketChannel=ServerSocketChannel.open();
        //设置非阻塞式编程
        serverSocketChannel.configureBlocking(false);
        //绑定端口
        serverSocketChannel.socket().bind(new InetSocketAddress(8080));
        System.out.println("启动成功");
        while (true){
            SocketChannel socketChannel=serverSocketChannel.accept();
            //tcp请求：读取响应
            if(socketChannel!=null){
                System.out.println("收到响应，响应端口味"+socketChannel.getRemoteAddress());
                socketChannel.configureBlocking(false);
                try {

                    ByteBuffer byteBuffer=ByteBuffer.allocate(1024);

                    while (socketChannel.isOpen()&&socketChannel.read(byteBuffer)!=-1){
                        //长链接情况下，需要判断数据有没有读取结束（此处认为超过0字节就认为是成功饿了）
                        if (byteBuffer.position()>0){break;}
                    }
                    if (byteBuffer.position()==0){continue;}
                    byteBuffer.flip();
                    byte[] b=new byte[byteBuffer.limit()];
                    byteBuffer.get(b);
                    System.out.println(new String(b));

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

                }

            }

        }






    }



    }
