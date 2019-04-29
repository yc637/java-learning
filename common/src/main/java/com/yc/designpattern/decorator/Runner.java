package com.yc.designpattern.decorator;

/**
 * 装饰器模式测试运行类
 *
 * @author gs
 * @date 2018年08月08日 10:10:27
 */
public class Runner {

    public static void main(String[] args) {

        Component component = new ConcreteComponent();
        ConcreteDecoratorA decoratorA = new ConcreteDecoratorA(component);
        decoratorA.method();
        decoratorA.methodA();
        ConcreteDecoratorB decoratorB = new ConcreteDecoratorB(component);
        decoratorB.method();
        decoratorB.methodB();

        System.out.println("----------------装饰器B对装饰器A(装饰器A对原始类进行了装饰)进行装饰--------------");
        ConcreteDecoratorB decoratorB1 = new ConcreteDecoratorB(decoratorA);
        decoratorB1.method();
    }
}
