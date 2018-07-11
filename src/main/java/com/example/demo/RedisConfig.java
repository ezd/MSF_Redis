package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class RedisConfig {
	
	@Bean
	static JedisConnectionFactory jedisConnectionFactory() {
//		JedisConnectionFactory jedisConnectionFactory= new JedisConnectionFactory();
//		jedisConnectionFactory.setPort(6379);
//		jedisConnectionFactory.setHostName("localhost");
		return new JedisConnectionFactory();
	}
	
	@Bean
	RedisTemplate<String, Object> redisTemplate(){
		RedisTemplate<String, Object> redisTemplate=new RedisTemplate<>();
		redisTemplate.setConnectionFactory(jedisConnectionFactory());
		return redisTemplate;
	}
	

}
