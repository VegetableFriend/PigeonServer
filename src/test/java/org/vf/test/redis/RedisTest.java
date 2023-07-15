package org.vf.test.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RedisTestConfig.class})
public class RedisTest {

    @Autowired
    RedisTemplate<String, String> redisTemplate;

    @Test
    public void testRedisBasicFunction() {
        redisTemplate.opsForValue().set("ame", "maybe");

        System.out.println(redisTemplate.opsForValue().get("ame"));
    }
}
