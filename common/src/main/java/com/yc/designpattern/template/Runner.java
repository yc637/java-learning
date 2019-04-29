package com.yc.designpattern.template;

/**
 * 模板方法模式测试类
 *
 * @author gs
 * @date 2018年08月08日 11:11:26
 */
public class Runner {

    public static void main(String[] args) {
        Template concreteClassA = new ConcreteClassA();
        concreteClassA.process();

        Template concreteClassB = new ConcreteClassB();
        concreteClassB.process();
    }
}
