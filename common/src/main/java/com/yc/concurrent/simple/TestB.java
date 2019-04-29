package com.yc.concurrent.simple;

/**
 * 文字描述
 *
 * @author gs
 * @date 2017年03月02日 09:9:51
 */
public class TestB {
    private static String sync = "123";
    public static synchronized void method1() throws InterruptedException {
        System.out.println(1);
        Thread.sleep(1000);
        System.out.println(2);
    }
    public static synchronized void method2() throws InterruptedException {
        System.out.println(3);
        Thread.sleep(1000);
        System.out.println(4);
    }

    public void method3() throws InterruptedException {
        synchronized(sync){
//            sync = "456";
            System.out.println(5);
            Thread.sleep(1000);
            System.out.println(6);
        }
    }

    public void method4() throws InterruptedException {
        synchronized(sync){
            System.out.println(7);
            Thread.sleep(1000);
            System.out.println(8);
        }
    }
}