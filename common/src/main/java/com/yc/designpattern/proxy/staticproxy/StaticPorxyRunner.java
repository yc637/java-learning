package com.yc.designpattern.proxy.staticproxy;

/**
 * 文字描述
 *
 * @author gs
 * @date 2018年08月10日 15:15:28
 */
public class StaticPorxyRunner {

    public static void main(String[] args) {

        Subject subject = new DataQueryStaticProxy();
        DataEntity entity = subject.query();
        System.out.println(entity.toString());
    }
}
