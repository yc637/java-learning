package com.yc.designpattern.factory;

/**
 * 文字描述
 *
 * @author gs
 * @date 2018年08月09日 10:10:31
 */
public class BikeFactory implements Factory {

    @Override
    public Product create() {
        return new Bike();
    }
}
