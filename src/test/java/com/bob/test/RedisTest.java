package com.bob.test;

import com.bob.bobpal.BobPalApplication;
import com.bob.bobpal.model.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import javax.annotation.Resource;

@SpringBootTest(classes = BobPalApplication.class)
public class RedisTest {
    @Resource
    private RedisTemplate redisTemplate;
    @Test
    void testCRUD(){
        ValueOperations valueOperations = redisTemplate.opsForValue();
        //增加
        valueOperations.set("bobString","bob");
        valueOperations.set("bobInt",2);
        valueOperations.set("bobDouble",1.0);
        User user = new User();
        user.setId(1);
        user.setUsername("Bob");

        valueOperations.set("bobUser",user);

        //删
        redisTemplate.delete("bobInt");
        //改
        //再次set
        //查
        Object bobString = valueOperations.get("bobString");
        Assertions.assertTrue("bob".equals((String) bobString));
        Object bobInt = valueOperations.get("bobInt");
        Assertions.assertTrue(2==(Integer) bobInt);
        Object bobDouble = valueOperations.get("bobDouble");
        Assertions.assertTrue(1.0==(Double) bobDouble);
        System.out.println(valueOperations.get("bobUser"));
    }
}
