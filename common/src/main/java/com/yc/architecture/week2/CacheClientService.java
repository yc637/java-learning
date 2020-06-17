package com.yc.architecture.week2;

public interface CacheClientService {

    Object get(Object key);

    void put(Object key, Object value);

    void delete(Object key);

}
