package com.yc.designpattern.adapter;

/**
 * 对象适配器模式，推荐使用
 *
 * @author gs
 * @date 2018年08月08日 11:11:50
 */
public class AdapterB implements Target {

    private Adaptee adaptee;

    public AdapterB(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void request() {
        adaptee.anotherRequest();
    }
}
