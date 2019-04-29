package com.yc.designpattern.decorator;

/**
 * 文字描述
 *
 * @author gs
 * @date 2018年08月08日 10:10:40
 */
public class ConcreteDecoratorB extends Decorator {
    /**
     * 将被装饰类作为参数传入构造器
     *
     * @param component
     */
    public ConcreteDecoratorB(Component component) {
        super(component);
    }

    public void methodB() {
        System.out.println("装饰器B扩展的方法");
    }

    public void method() {
        System.out.println("装饰器B对原方法装饰开始");
        super.method();
        System.out.println("装饰器B对原方法装饰结束");
    }
}
