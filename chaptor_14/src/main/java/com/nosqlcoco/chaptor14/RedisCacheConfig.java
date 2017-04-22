package com.nosqlcoco.chaptor14;

import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * Redis 配置
 * @author Ke Shanqiang
 * @since 2017/03/24
 */
@Configuration
public class RedisCacheConfig extends CachingConfigurerSupport{
	@Bean
	RedisConnectionFactory connectionFactory() {
		return new JedisConnectionFactory();
	}

	@Bean
	RedisTemplate<?, ?> redisTemplate(RedisConnectionFactory connectionFactory) {

		RedisTemplate<String, String> template = new RedisTemplate<String, String>();
		template.setConnectionFactory(connectionFactory);

		return template;
	}
}
