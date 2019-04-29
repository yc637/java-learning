package com.yc.concurrent.simple;

public class TestThread implements Runnable {

    private TestB testB = new TestB();
    public static void main(String[] args) {

//        List<String> list = new ArrayList<>();
//
//        System.out.println(indexFor(1223, 3));
        Runnable myRunnable = new TestThread();
        Thread t1 = new Thread(myRunnable,"t1");
        Thread t2 = new Thread(myRunnable,"t2");
        t1.start();
        t2.start();
    }

    static int indexFor(int h, int length) {
        return h & (length-1);
    }


    @Override
    public void run() {
        try {
            if (Thread.currentThread().getName().equals("t1")) {
//                TestB.method1();
                testB.method3();
            } else {
//                TestB.method2();
                testB.method4();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
