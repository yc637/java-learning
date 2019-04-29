package com.yc.designpattern.decorator;

/**
 * 装饰器父类
 *
 * @author gs
 * @date 2018年08月08日 10:10:24
 */
public class Decorator implements Component {

    private Component component;

    /**
     * 将被装饰类作为参数传入构造器
     *
     * @param component
     */
    public Decorator(Component component) {
        super();
        this.component = component;
    }

    @Override
    public void method() {
        System.out.println("装饰器父类开始装饰");
        component.method();
        System.out.println("装饰器父类结束装饰");
    }
}
