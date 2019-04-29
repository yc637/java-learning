package com.yc.designpattern.observer;

import java.util.Vector;

/**
 * 被观察者父类，提供注册和注销观察者方法，当事件发生时，触发回调方法，遍历所有已注册的观察者进行回调
 *
 * @author gs
 * @date 2018年08月09日 18:18:50
 */
public abstract class Subject {

    Vector<Observer> observerList = new Vector<>();

    public void attach(Observer observer) {
        observerList.add(observer);
    }

    public void detach(Observer observer) {
        observerList.remove(observer);
    }

    public void call() {
        for(Observer o : observerList) {
            o.callBack();
        }
    }

    public abstract void doSomething();

}
