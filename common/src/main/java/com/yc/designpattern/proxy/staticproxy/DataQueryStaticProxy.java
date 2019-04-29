package com.yc.designpattern.proxy.staticproxy;

/**
 * 静态代理代理类，与被代理类实现相同接口，具有相同的方法行为。维护被代理类对象，并对其进行扩展。
 *
 * @author gs
 * @date 2018年08月10日 15:15:22
 */
public class DataQueryStaticProxy implements Subject {

    private DataQuery dataQuery = null;

    @Override
    public DataEntity query() {
        if (dataQuery == null) {
            dataQuery = new DataQuery();
        }
        System.out.println("查询开始时间："+ System.currentTimeMillis());
        DataEntity dataEntity = dataQuery.query();
        System.out.println("查询结束时间："+ System.currentTimeMillis());
        return dataEntity;
    }

}
