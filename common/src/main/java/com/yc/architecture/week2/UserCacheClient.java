package com.yc.architecture.week2;

public class UserCacheClient {

    private CacheClientAdapter cacheClientAdapter;

    public UserCacheClient(CacheClientAdapter cacheClientAdapter) {
        this.cacheClientAdapter = cacheClientAdapter;
    }

    public Object get(Object key) {
        return cacheClientAdapter.get(key);
    }

    public void put(Object key, Object value) {
        cacheClientAdapter.put(key, value);
    }

    public void delete(Object key) {
        cacheClientAdapter.delete(key);
    }

}
