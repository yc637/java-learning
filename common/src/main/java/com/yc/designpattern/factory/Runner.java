package com.yc.designpattern.factory;

/**
 * 工厂方法模式
 *
 * @author gs
 * @date 2018年08月09日 10:10:29
 */
public class Runner {

    public static void main(String[] args) {
        Factory cf = new CarFactory();
        Factory bf = new BikeFactory();
        Product p1 = cf.create();
        Product p2 = bf.create();
        p1.use();
        p2.use();
    }
}
