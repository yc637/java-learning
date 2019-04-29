package com.yc.concurrent.simple;

/**
 * 通过模拟生产者消费者模型测试wait和notify
 * wait/notify方法的调用必须处在该对象的锁（Monitor）中，也即，在调用这些方法时首先需要获得该对象的锁。否则会抛出IllegalMonitorStateException异常。
 *
 * @author gs
 * @date 2018年02月13日 16:16:35
 */
public class TestWaitNotify {

    static Object obj = new Object();

    /**
     * 用于判断消费队列是否有数据的参数
     */
    static boolean flag = true;

    public static void main(String[] args) {
        // 创建两个线程，交替执行任务
        Thread t1 = new Thread(new ProduceClass(), "t1");
        Thread t2 = new Thread(new ConsumeClass(), "t2");
        t1.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();
    }

    /**
     * 生产者类
     */
    static class ProduceClass implements Runnable {
        @Override
        public void run() {
            synchronized (obj) {
                System.out.println("生产者启动");
                while (true) {
                    System.out.println("生产者获取到锁，开始执行");
                    try {
                        if (flag) {
                            System.out.println("生产者正在生产数据......");
                            Thread.sleep(1000);
                            System.out.println("生产者执行完成");
                            flag = false;
                            obj.notifyAll();
                        } else {
                            System.out.println("生产者没有可执行任务，进入wait");
                            obj.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    /**
     * 消费者类
     */
    static class ConsumeClass implements Runnable {
        @Override
        public void run() {
            synchronized (obj) {
                System.out.println("消费者启动");
                while (true) {
                    System.out.println("消费者获取到锁，说明t1线程在调用wait方法后释放了锁");
                    try {
                        if (!flag) {
                            System.out.println("消费者开始执行");
                            Thread.sleep(1000);
                            System.out.println("消费者执行结束，释放锁");
                            flag = true;
                            obj.notifyAll();
                        } else {
                            System.out.println("消费者没有可消费的数据，进入wait");
                            obj.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}
