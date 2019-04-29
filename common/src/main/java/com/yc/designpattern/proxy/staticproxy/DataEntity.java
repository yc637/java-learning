package com.yc.designpattern.proxy.staticproxy;

/**
 * 文字描述
 *
 * @author gs
 * @date 2018年08月10日 15:15:16
 */
public class DataEntity {

    private String name;
    private String ip;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public DataEntity(){}

    public DataEntity(String name, String ip) {
        this.name = name;
        this.ip = ip;
    }

    @Override
    public String toString() {
        return "DataEntity{" +
                "name='" + name + '\'' +
                ", ip='" + ip + '\'' +
                '}';
    }
}
