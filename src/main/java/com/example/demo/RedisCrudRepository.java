package com.example.demo;

import java.util.Map;

public interface RedisCrudRepository {

	Map<String, Object> getAll();
	Map<String, Object> add(String id, Object value);
	Object getById(String id);
	Map<String, Object> update(String id, Object value);
	boolean isExist(String id);
	
}
