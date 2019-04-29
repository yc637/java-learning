package com.yc.designpattern.abstractfactory;

/**
 * 文字描述
 *
 * @author gs
 * @date 2018年08月09日 17:17:51
 */
public class LenovoMouse implements Productor {
    @Override
    public void use() {
        System.out.println("联想鼠标");
    }
}
