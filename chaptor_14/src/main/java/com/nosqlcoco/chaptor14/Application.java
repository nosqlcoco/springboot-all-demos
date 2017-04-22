package com.nosqlcoco.chaptor14;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * springboot 自定义缓存对象和有效期
 * 1. 从JedisConnectionFactory获取RedisConnectionFactory
 * 2. 创建RedisTemplate对象，并将RedisTemplate的连接工厂设置为RedisConnectionFactory
 * 3. 在其他类注入RedisTemplate, RedisTemplate.execute执行添加/删除/更新操作
 * @author nosqlcoco
 */
@SpringBootApplication
@EnableCaching
public class Application {
    public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
