package com.example.demo;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RedisDataServiceImpl implements RedisDataService {
	
	@Autowired
	RedisCrudRepository redisCrudRepository;

	@Override
	public Map<String, Object> getAllData() {
		
		return redisCrudRepository.getAll();
	}

	@Override
	public Map<String, Object> addData(User user) {
		return redisCrudRepository.add(user.id, user);
	}

	@Override
	public boolean isExist(String id) {
		// TODO Auto-generated method stub
		return redisCrudRepository.isExist(id);
	}

	@Override
	public User get(String id) {
		User user=(User) redisCrudRepository.getById(id);
		if(user!=null) {
			System.out.println("User is found");
			return user;
		}else {
			System.out.println("user fetched from db");
			return new User("1000", "fname", "lname");
		}
		
	}
	
	

}
