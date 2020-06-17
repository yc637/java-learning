package com.yc.architecture.week2;

public class Test {

    public static void main(String[] args) {
        String key = "";
        String value = "";
        Config conf = new Config();

        CacheService cacheService = new CacheServiceImpl();

        CacheClientAdapter cacheClientAdapter = new CacheClientAdapter(cacheService);
        UserCacheClient userCacheClient = new UserCacheClient(cacheClientAdapter);
        userCacheClient.get(key);
        userCacheClient.put(key, value);
        userCacheClient.delete(key);

        CacheManagerAdapter cacheManagerAdapter = new CacheManagerAdapter(cacheService);
        CacheManagerClient cacheManagerClient = new CacheManagerClient(cacheManagerAdapter);
        cacheManagerClient.rebuild(conf);
    }
}
