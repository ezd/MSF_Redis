package com.example.demo;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RedisCrudRepositoryImpl implements RedisCrudRepository {
	
	private final String schema="data";
	
//	@Autowired
//	RedisTemplate<String, Object> redisTemplate;
//	
	HashOperations<String, String, Object> hashOperations;
	
	public RedisCrudRepositoryImpl(RedisTemplate<String, Object> redisTemplate) {
//		this.redisTemplate=redisTemplate;
		hashOperations = redisTemplate.opsForHash();
	}
	

	@Override
	public Map<String, Object> getAll() {
		return hashOperations.entries(schema);
	}


	@Override
	public Map<String, Object> add(String id, Object value) {
		hashOperations.put(schema, id, value);
		return getAll();
	}


	@Override
	public boolean isExist(String id) {
		return getById(id)!=null;
	}


	@Override
	public Object getById(String id) {
		// TODO Auto-generated method stub
		return hashOperations.get(schema, id);
	}


	@Override
	public Map<String, Object> update(String id, Object value) {
		// TODO Auto-generated method stub
		return null;
	}

}
