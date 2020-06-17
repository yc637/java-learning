package com.yc.architecture.week2;

public class CacheManagerClient {

    private CacheManagerAdapter cacheManagerAdapter;

    public CacheManagerClient(CacheManagerAdapter cacheManagerAdapter) {
        this.cacheManagerAdapter = cacheManagerAdapter;
    }

    public void rebuild(Config config) {
        cacheManagerAdapter.rebuild(config);
    }

}
