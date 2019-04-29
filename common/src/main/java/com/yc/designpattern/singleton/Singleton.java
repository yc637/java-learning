package com.yc.designpattern.singleton;

/**
 * 单例
 *
 * @author gs
 * @date 2018年08月08日 16:16:31
 */
public class Singleton {

    private static final Singleton singleton = new Singleton();

    private Singleton(){}

    public static Singleton getInstance() {
        return singleton;
    }

}
