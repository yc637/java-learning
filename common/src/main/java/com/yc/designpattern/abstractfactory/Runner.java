package com.yc.designpattern.abstractfactory;

/**
 * 抽象工厂模式
 *
 * @author gs
 * @date 2018年08月09日 17:17:55
 */
public class Runner {

    public static void main(String[] args) {
//        Factory factory = new DellFactory();
        Factory factory = new LenovoFactory();
        Productor p1 = factory.produceKeyboard();
        Productor p2 = factory.produceMouse();
        Productor p3 = factory.produceScreen();
        p1.use();
        p2.use();
        p3.use();

    }
}
