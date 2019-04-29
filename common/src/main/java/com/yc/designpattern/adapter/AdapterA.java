package com.yc.designpattern.adapter;

/**
 * 类适配器模式，继承待适配的类
 * 通过适配器，就可以用外国的充电器给中国的手机充电，所以适配器要实现外国充电标准Target，使用该标准提供的方法，调用中国手机的充电方法充电
 *
 * @author gs
 * @date 2018年08月08日 11:11:50
 */
public class AdapterA extends Adaptee implements Target {

    @Override
    public void request() {
        super.anotherRequest();
    }
}
