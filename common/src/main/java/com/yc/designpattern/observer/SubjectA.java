package com.yc.designpattern.observer;

import java.util.Vector;

/**
 * 被观察者A
 *
 * @author gs
 * @date 2018年08月09日 18:18:53
 */
public class SubjectA extends Subject {


    @Override
    public void doSomething() {
        System.out.println("被观察者A正在干活，触发事件");
        this.call();
    }
}
