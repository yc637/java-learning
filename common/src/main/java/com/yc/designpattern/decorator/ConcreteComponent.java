package com.yc.designpattern.decorator;

/**
 * 被装饰的原始对象，待装饰对象
 *
 * @author gs
 * @date 2018年08月08日 10:10:22
 */
public class ConcreteComponent implements Component {

    @Override
    public void method() {
        System.out.println("原始对象");
    }
}
