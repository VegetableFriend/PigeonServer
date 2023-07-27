package org.vf.services.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisService {

    RedisService() {
        System.out.println(1);
    }
    @Autowired
    RedisTemplate<String, String> redisTemplate;

    public void setValueForKey(String key, String value) {
        this.redisTemplate.opsForValue().set(key, value);
    }

    public String valueForKey(String key) {
        return this.redisTemplate.opsForValue().get(key);
    }
}
