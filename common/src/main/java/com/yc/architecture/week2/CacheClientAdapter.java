package com.yc.architecture.week2;

public class CacheClientAdapter implements CacheClientService {

    private CacheService cacheService;

    public CacheClientAdapter(CacheService cacheService) {
        this.cacheService = cacheService;
    }

    @Override
    public Object get(Object key) {
        return cacheService.get(key);
    }

    @Override
    public void put(Object key, Object value) {
        cacheService.put(key, value);
    }

    @Override
    public void delete(Object key) {
        cacheService.delete(key);
    }
}
