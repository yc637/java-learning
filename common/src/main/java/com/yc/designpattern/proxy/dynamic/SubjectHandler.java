package com.yc.designpattern.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 文字描述
 *
 * @author gs
 * @date 2018年08月10日 16:16:00
 */
public class SubjectHandler implements InvocationHandler {

    private Proxyable object;

    public SubjectHandler(Proxyable object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("事务开始");
        method.invoke(object, args);
        System.out.println("提交事务");
        return null;
    }
}
