package com.yc.nio;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

/**
 * 文字描述
 *
 * @author gs
 * @date 2019年04月16日 15:15:59
 */
public class NIOTest {

    public static void main(String[] args) {
//        nioRead();
//        nioCopyFile();
            System.out.println("1,".substring(0, "1,".length()-1));
    }

    private static void nioRead() {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream("E:/logs/film_logs.log");
            FileChannel fileChannel = fileInputStream.getChannel();
            ByteBuffer buffer = ByteBuffer.allocate( 1024 );
            int length = -1;
            while ((length = fileChannel.read(buffer)) != -1) {
                buffer.clear();
                byte[] bytes = buffer.array();
                System.out.write(bytes, 0, length);
            }
            fileChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void nioCopyFile() {
        FileInputStream fileInputStream = null;
        FileOutputStream fout = null;
        try {
            fileInputStream = new FileInputStream("E:/logs/film_logs.log");
            fout = new FileOutputStream( "E:/logs/film_logs.log.bak" );
            FileChannel fileChannel = fileInputStream.getChannel();
            FileChannel fc = fout.getChannel();
            ByteBuffer buffer = ByteBuffer.allocate( 1024 );
            while (fileChannel.read(buffer) != -1) {
                buffer.flip();
                // 调用flip后，由读变为写/或由写变为读
                fc.write(buffer);
                buffer.clear();
            }
            System.out.println("复制完成");
            fc.close();
            fileChannel.close();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                    fout.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void testSelector() throws IOException {
//        Selector selector = Selector.open();
//        SocketChannel socketChannel = new
//        channel.configureBlocking(false);
    }
}
