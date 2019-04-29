package com.yc.designpattern.observer;

/**
 * 文字描述
 *
 * @author gs
 * @date 2018年08月09日 19:19:00
 */
public class Runner {

    public static void main(String[] args) {
        Observer a = new ObserverA();
        Observer b = new ObserverB();
        Subject subjectA = new SubjectA();
        subjectA.attach(a);
        subjectA.attach(b);

        subjectA.doSomething();
    }
}
