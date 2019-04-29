package com.yc.designpattern.singleton;

/**
 * 单例，饿汉，线程安全
 *
 * @author gs
 * @date 2018年08月08日 16:16:31
 */
public class SingletonB {

    private static SingletonB singleton;

    private SingletonB(){}

    public static SingletonB getInstance() {
        if (singleton == null) {
            synchronized (SingletonB.class) {
                if (singleton == null) {
                    singleton = new SingletonB();
                }
            }
        }
        return singleton;
    }

}
