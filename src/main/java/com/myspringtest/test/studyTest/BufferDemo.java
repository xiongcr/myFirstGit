package com.myspringtest.test.studyTest;
import java.nio.ByteBuffer;

public class BufferDemo {
    public static void main(String[] args){

        //构建一个byte缓冲区，容量是4
        ByteBuffer byteBuffer=ByteBuffer.allocate(4);
        //默认写入模式，查看三个重要指标
        System.out.println(String.format("初始化:capacity容量:%s，location位置:%s，limit限制:%s",byteBuffer.capacity(),byteBuffer.position(),byteBuffer.limit()));
        //写入两字节数据
        byteBuffer.put((byte)1);
        byteBuffer.put((byte)2);

        byteBuffer.put((byte)3);
       //在看数据
        System.out.println(String.format("写入两字节后：初始化:capacity容量:%s，location位置:%s，limit限制:%s",byteBuffer.capacity(),byteBuffer.position(),byteBuffer.limit()));

      //转换为读取模式，不调用flip方法，也是可以读取数据的，但是position位置不对
        System.out.println("开始读区");
        byteBuffer.flip();
        byte a=byteBuffer.get();
        System.out.println("a的值"+a);
        byte b=byteBuffer.get();
        System.out.println("b的值"+b);
        System.out.println(String.format("读取2字节后：初始化:capacity容量:%s，location位置:%s，limit限制:%s",byteBuffer.capacity(),byteBuffer.position(),byteBuffer.limit()));

        //继续写入3字节，此时读取模式下，limit=3，position=2    继续写入只能覆盖一条写入数据
        //clear方法清除整个缓冲区，compact方法仅清除已阅读的数据，转换为写入模式

        byteBuffer.compact();
        byteBuffer.put((byte)3);
        byteBuffer.put((byte)4);

        byteBuffer.put((byte)5);
        System.out.println(String.format("最终情况：初始化:capacity容量:%s，location位置:%s，limit限制:%s",byteBuffer.capacity(),byteBuffer.position(),byteBuffer.limit()));


    }

}
