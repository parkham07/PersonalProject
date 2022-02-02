package kr.co.parkham.dao.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class RedisTestService {

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    public void test() {
        String key = "test";
        ValueOperations<String, Object> vo = redisTemplate.opsForValue();

        vo.set(key, "1111");
        vo.set(key + "2", "2222", 1000, TimeUnit.MILLISECONDS);
        vo.set(key + "3", "3333", 1000, TimeUnit.MILLISECONDS);

        String result1 = (String) vo.get(key);
        String result2 = (String) vo.get(key + "2");
        String result3 = (String) vo.get(key + "3");

        System.out.println("Redis First value check : " + result1 + ", " + result2 + ", " + result3);

        redisTemplate.expire(key, 5000, TimeUnit.MILLISECONDS);

        try {
            redisTemplate.expire(key + "3", 5000, TimeUnit.MILLISECONDS);

            Thread.sleep(2000);

            result1 = (String) vo.get(key);
            result2 = (String) vo.get(key + "2");
            result3 = (String) vo.get(key + "3");

            System.out.println("Redis second value check : " + result1 + ", " + result2 + ", " + result3);

            Thread.sleep(4000);

            result1 = (String) vo.get(key);
            result2 = (String) vo.get(key + "2");
            result3 = (String) vo.get(key + "3");

            System.out.println("Redis third value check : " + result1 + ", " + result2 + ", " + result3);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("redis test finish");
    }
}
