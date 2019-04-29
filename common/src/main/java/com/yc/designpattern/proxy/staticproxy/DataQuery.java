package com.yc.designpattern.proxy.staticproxy;

/**
 * 模拟数据库操作，被代理类
 *
 * @author gs
 * @date 2018年08月10日 15:15:15
 */
public class DataQuery implements Subject {

    @Override
    public DataEntity query(){
        System.out.println("查询数据");
        return new DataEntity("yc","127.0.0.1");
    }

}
