package com.yc.designpattern.template;

/**
 * 模板类，模板中规定了操作流程，子类实现具体每一步需要做什么
 *
 * @author gs
 * @date 2018年08月08日 11:11:21
 */
public abstract class Template {

    protected void process() {
        if (step1()) {
            step2();
        }
        step3();
    }

    protected abstract boolean step1();

    protected abstract void step2();

    protected void step3() {
        System.out.println("模板中的step3");
    }


}
