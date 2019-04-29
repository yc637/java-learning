package com.yc.designpattern.proxy.dynamic;

import com.yc.designpattern.proxy.staticproxy.DataEntity;

/**
 * 文字描述
 *
 * @author gs
 * @date 2018年08月10日 16:16:25
 */
public interface Proxyable {


    DataEntity query();

    void insertData();
}
