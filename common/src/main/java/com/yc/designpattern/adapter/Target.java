package com.yc.designpattern.adapter;

/**
 * 目标类，即被适配类通过适配器适配后，要达到的目标
 * 可以理解为，中国的手机要在外国充电，Target即为外国充电标准
 *
 * @author gs
 * @date 2018年08月08日 11:11:48
 */
public interface Target {

    void request();
}
