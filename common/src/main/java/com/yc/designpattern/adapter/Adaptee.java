package com.yc.designpattern.adapter;

/**
 * 需要适配的类
 * 中国的手机有自己的充电方法
 *
 * @author gs
 * @date 2018年08月08日 11:11:49
 */
public class Adaptee {

    void anotherRequest() {
        System.out.println("调用适配后的请求方法");
    }
}
