package com.luochen.financial.redis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
public class RedisTemplateTests {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Test
    public void redisTest() {
        String key = "slogan";
        // 操作 String 类型
        redisTemplate.opsForValue().set(key, "grow up");
        System.out.println("slogan 在 redis 中创建完毕");
        String value = redisTemplate.opsForValue().get(key);
        System.out.println("从 redis 中获得 2022 slogan 是：" + value);

        // 操作 List 类型
        redisTemplate.opsForList().leftPush("list", "vvv");
        System.out.println("List 类型的数据操作：" + redisTemplate.opsForList().leftPop("list"));

        // 操作 Set 类型
        redisTemplate.opsForSet().add("set", "v_v_v");
        System.out.println("Set 类型的数据操作：" + redisTemplate.opsForSet().pop("set"));

        // 操作 Hash 类型
        redisTemplate.opsForHash().put("hash", "test", "hello");
        System.out.println("Hash 类型的数据操作：" + redisTemplate.opsForHash().get("hash", "test"));

        // 操作 ZSet 类型
        redisTemplate.opsForZSet().add("zset", "z_v", 1);
        redisTemplate.opsForZSet().add("zset", "z_v_v", 2);
        System.out.println("ZSet 类型的数据操作：" + redisTemplate.opsForZSet().range("zset", 0, 2));
    }
}
