package com.yc.designpattern.factory;

/**
 * 文字描述
 *
 * @author gs
 * @date 2018年08月09日 10:10:28
 */
public class Bike implements Product{

    @Override
    public void use() {
        System.out.println("a bike");
    }
}
