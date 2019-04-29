package com.yc.designpattern.abstractfactory;

/**
 * 文字描述
 *
 * @author gs
 * @date 2018年08月09日 17:17:53
 */
public class DellScreen implements Productor{

    @Override
    public void use() {
        System.out.println("戴尔显示器");
    }
}
