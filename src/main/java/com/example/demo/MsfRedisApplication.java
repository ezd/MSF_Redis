package com.example.demo;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class MsfRedisApplication {


	public static void main(String[] args) {
		SpringApplication.run(MsfRedisApplication.class, args);
	}
	
	@Autowired
	RedisDataService redisDataService;
	
	@RequestMapping("/all")
	Map<String, Object> getAllData() {
		return redisDataService.getAllData();
	}
	
	@RequestMapping("/add")
	Map<String, Object> addData(@RequestParam("id") String id,
			@RequestParam("fname") String fname,
			@RequestParam("lname") String lname) {
		User user=new User(id,fname,lname);
		return redisDataService.addData(user);
	}
	@RequestMapping("/update")
	Map<String, Object> updateData(@RequestParam("id") String id,
			@RequestParam("fname") String fname,
			@RequestParam("lname") String lname) {
		if(redisDataService.isExist(id)) {
		User user=new User(id,fname,lname);
		return redisDataService.addData(user);
		}else {
			return redisDataService.getAllData();
		}
	}
	
	@RequestMapping("/isExist")
	boolean checkIfExist(@RequestParam("id") String id) {
		return redisDataService.isExist(id);
	}
	@RequestMapping("/get")
	User getIfExist(@RequestParam("id") String id) {
		User user=redisDataService.get(id);
		return user;
	}
}
