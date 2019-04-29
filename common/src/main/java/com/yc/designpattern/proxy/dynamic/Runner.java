package com.yc.designpattern.proxy.dynamic;

import com.yc.designpattern.proxy.staticproxy.DataEntity;

import java.lang.reflect.Proxy;

/**
 * 文字描述
 *
 * @author gs
 * @date 2018年08月10日 16:16:13
 */
public class Runner {

    public static void main(String[] args) {
        Proxyable subject = new Subject();
        SubjectHandler handler = new SubjectHandler(subject);

        Proxyable proxy = (Proxyable) Proxy.newProxyInstance(Runner.class.getClassLoader(), new Class<?>[]{Proxyable.class}, handler);
//        proxy.insertData();
        DataEntity entity = proxy.query();
        System.out.println(entity.toString());
    }
}
