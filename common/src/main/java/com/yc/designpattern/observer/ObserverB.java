package com.yc.designpattern.observer;

/**
 * 观察者B
 *
 * @author gs
 * @date 2018年08月09日 18:18:45
 */
public class ObserverB implements Observer{
    @Override
    public void callBack() {
        System.out.println("观察者B收到通知，开始干活....");
    }
}
