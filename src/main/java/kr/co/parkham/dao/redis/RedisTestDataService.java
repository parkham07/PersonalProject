package kr.co.parkham.dao.redis;

import kr.co.parkham.dto.redis.TestRedisData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RedisTestDataService implements MessageListener {
    public static List<String> messageList = new ArrayList<>();

    @Override
    public void onMessage(Message message, byte[] pattern) {
        messageList.add(message.toString());

        System.out.println("Message received: " + message.toString());
    }

    @Autowired
    RedisTemplate<String, Object> redisTemplateTestObj;

    public void test() {
        String key = "test";
        ValueOperations<String, Object> vo = redisTemplateTestObj.opsForValue();
        TestRedisData testRedisData = new TestRedisData();

        testRedisData.setId("아이디");
        testRedisData.setValue("패스워드");

        vo.set(key, testRedisData);

        TestRedisData result = (TestRedisData) vo.get(key);

        System.out.println("Redis Json value check : " + result);

        System.out.println("redis test finish");
    }
}
