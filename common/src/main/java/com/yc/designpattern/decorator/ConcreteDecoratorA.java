package com.yc.designpattern.decorator;

/**
 * 文字描述
 *
 * @author gs
 * @date 2018年08月08日 10:10:34
 */
public class ConcreteDecoratorA extends Decorator {

    /**
     * 将被装饰类作为参数传入构造器
     *
     * @param component
     */
    public ConcreteDecoratorA(Component component) {
        super(component);
    }

    public void methodA() {
        System.out.println("装饰器A扩展功能");
    }

    @Override
    public void method() {
        System.out.println("A对原方法进行装饰");
        super.method();
        System.out.println("A装饰结束");
    }
}
