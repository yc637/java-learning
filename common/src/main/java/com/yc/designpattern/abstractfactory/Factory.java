package com.yc.designpattern.abstractfactory;

/**
 * 文字描述
 *
 * @author gs
 * @date 2018年08月09日 17:17:46
 */
public interface Factory {

    Productor produceKeyboard();

    Productor produceScreen();

    Productor produceMouse();
}
