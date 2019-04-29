package com.yc.designpattern.singleton;

/**
 * 文字描述
 *
 * @author gs
 * @date 2018年08月08日 16:16:33
 */
public class Runner {

    public static void main(String[] args) {
        System.out.println(Singleton.getInstance());

        System.out.println(SingletonB.getInstance());
    }
}
