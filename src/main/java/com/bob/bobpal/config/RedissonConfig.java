package com.bob.bobpal.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Redisson 配置
 */
@Configuration
public class RedissonConfig {
    @Bean
    public RedissonClient redissonClient(){
        // 1. Create config object
        Config config = new Config();
        String redisAddress = "redis://127.0.0.1:6379";
        config.useSingleServer().setAddress(redisAddress).setDatabase(3);

        // 2. Create Redisson instance

        // Sync and Async API
        RedissonClient redisson = Redisson.create(config);
        return redisson;
    }
}
