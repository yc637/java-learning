
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.util.concurrent.RateLimiter;


/**
 * @Auther yc637
 * @Date 2019-09-30
 */
public class LimitUtil {


    private static Map<String, Map<Long, Long>> appSecendTimesMap = new ConcurrentHashMap<String, Map<Long, Long>>();

    private static Cache<String, RateLimiter> cache = CacheBuilder.newBuilder().expireAfterWrite(30, TimeUnit.SECONDS).build();

    /**
     * 判断是否限流，限流规则每秒n次
     *
     * @param appName
     * @param methodName
     * @param limitCount
     * @return
     */
    public static boolean isLimit(String appName, String methodName, int limitCount) {
        String key = appName + methodName;
        // 当前秒
        long second = System.currentTimeMillis() / 1000;
        // 访问次数
        long times = 1;
        Map<Long, Long> secondTimesMap = null;
        // 判断appName是否存在
        if (appSecendTimesMap.containsKey(key.toString())) {
            secondTimesMap = appSecendTimesMap.get(key);
            if (secondTimesMap.containsKey(second)) {
                times = secondTimesMap.get(second);
                // 判断是否限流，如果没有到限流阀值调用次数+1
                if (times >= limitCount) {
                    return true;
                } else {
                    times++;
                    secondTimesMap.put(second, times);
                }
            } else {
                // 如果没有当前时间的key，将原数据清空，加入新map
                secondTimesMap.clear();
                secondTimesMap.put(second, times);
            }
        } else {
            secondTimesMap = new ConcurrentHashMap<Long, Long>();
            secondTimesMap.put(second, times);
            appSecendTimesMap.put(key, secondTimesMap);
        }

        return false;
    }

    /**
     * 根据系统名称、方法名称、限制调用次数，判断是否限流
     *
     * @param appName    系统名称
     * @param methodName 方法名称
     * @param limitCount 限制调用次数
     * @return 限流返回true，不限流返回false
     */
    public static boolean isLimitByGuava(String appName, String methodName, final int limitCount) {
        boolean result = false;
        StringBuilder key = new StringBuilder(appName).append(methodName);
        try {
            RateLimiter limiter = cache.get(key.toString(), () -> RateLimiter.create(limitCount));
            if (!limiter.tryAcquire()) {
                result = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}