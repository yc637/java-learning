package com.yc.designpattern.adapter;

/**
 * 文字描述
 *
 * @author gs
 * @date 2018年08月08日 11:11:51
 */
public class Runner {

    public static void main(String[] args) {
        Target target1 = new AdapterA();
        target1.request();

        Adaptee adaptee = new Adaptee();
        Target target2 = new AdapterB(adaptee);
        target2.request();
    }
}
