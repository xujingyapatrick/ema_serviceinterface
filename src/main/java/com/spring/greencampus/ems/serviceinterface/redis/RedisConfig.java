package com.spring.greencampus.ems.serviceinterface.redis;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

//@Configuration
//@EnableCaching
public class RedisConfig{
//	  @Bean
//	  public JedisConnectionFactory redisConnectionFactory() {
//	    JedisConnectionFactory redisConnectionFactory = new JedisConnectionFactory();
//
//	    // Defaults
//	    redisConnectionFactory.setHostName("localhost");
//	    redisConnectionFactory.setPort(6379);
//	    return redisConnectionFactory;
//	  }
//
//	  @Bean
//	  public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory cf) {
//	    RedisTemplate<String, String> redisTemplate = new RedisTemplate<String, String>();
//	    redisTemplate.setConnectionFactory(cf);
//	    return redisTemplate;
//	  }
//	  
//	  @Bean
//	  public RedisCacheManager createRedisCacheManager(RedisTemplate<?, ?> redisTemplate){
//		  return new RedisCacheManager(redisTemplate);
//	  }


}
