package com.yc.io;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 文字描述
 *
 * @author gs
 * @date 2019年04月16日 15:15:59
 */
public class IOTest {

    public static void main(String[] args) {
        try {
            // 读取大文件可以使用BufferedInputStream
            FileInputStream fileInputStream = new FileInputStream("E:/logs/film_logs.log");
            BufferedInputStream bi = new BufferedInputStream(fileInputStream);
            int b = 0;
            while((b = bi.read()) != -1) {
                System.out.println(b);
            }
            bi.close();
            fileInputStream.close();


            // BufferedReader也可以用于读取大文件，适用于按行输出字符串的情况
            FileReader fr = new FileReader("E:/logs/film_logs.log");
            BufferedReader br = new BufferedReader(fr);
            String line = null;
            while((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
            fr.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
