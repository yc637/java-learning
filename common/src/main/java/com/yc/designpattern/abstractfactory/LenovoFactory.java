package com.yc.designpattern.abstractfactory;

/**
 * 文字描述
 *
 * @author gs
 * @date 2018年08月09日 17:17:48
 */
public class LenovoFactory implements Factory {

    @Override
    public Productor produceKeyboard() {
        return new LenovoKeyboard();
    }

    @Override
    public Productor produceScreen() {
        return new LenovoScreen();
    }

    @Override
    public Productor produceMouse() {
        return new LenovoMouse();
    }
}
