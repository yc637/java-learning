package com.yc.concurrent.simple;

/**
 * 文字描述
 *
 * @author gs
 * @date 2018年02月13日 16:16:35
 */
public class TestWhileWait {

    public static void main(String[] args) {
        TestWhileWait whileWait = new TestWhileWait();
        whileWait.test();

    }

    public synchronized void test() {
        while (true) {
            System.out.println(1);
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(2);
        }
    }
}
