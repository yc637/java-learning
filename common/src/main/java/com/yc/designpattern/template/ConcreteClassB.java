package com.yc.designpattern.template;

/**
 * 文字描述
 *
 * @author gs
 * @date 2018年08月08日 11:11:25
 */
public class ConcreteClassB extends Template{

    @Override
    protected boolean step1() {
        System.out.println("实现类B的第一步操作，返回false");
        return false;
    }

    @Override
    protected void step2() {
        System.out.println("实现类B的第二步操作");
    }
}
