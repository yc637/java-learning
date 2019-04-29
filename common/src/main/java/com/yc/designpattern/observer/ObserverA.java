package com.yc.designpattern.observer;

/**
 * 观察者A
 *
 * @author gs
 * @date 2018年08月09日 18:18:45
 */
public class ObserverA implements Observer{
    @Override
    public void callBack() {
        System.out.println("观察者A收到通知，开始干活....");
    }
}
