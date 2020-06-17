package com.yc.architecture.week2;

public class CacheManagerAdapter implements CacheManagerService {

    private CacheService cacheService;

    public CacheManagerAdapter(CacheService cacheService) {
        this.cacheService = cacheService;
    }

    @Override
    public void rebuild(Config conf) {
        cacheService.rebuild(conf);
    }
}
