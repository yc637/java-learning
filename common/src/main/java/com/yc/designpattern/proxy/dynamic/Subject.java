package com.yc.designpattern.proxy.dynamic;

import com.yc.designpattern.proxy.staticproxy.DataEntity;

/**
 * 被代理类，可以是任意类
 *
 * @author gs
 * @date 2018年08月10日 15:15:58
 */
public class Subject implements Proxyable{

    @Override
    public DataEntity query(){
        System.out.println("查询操作");
        return new DataEntity("yc", "192.168.1.1");
    }

    @Override
    public void insertData(){
        System.out.println("插入数据操作");
    }
}
