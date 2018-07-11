package com.example.demo;

import java.util.Map;

public interface RedisDataService {

	Map<String, Object> getAllData();
	Map<String, Object> addData(User user);
	boolean isExist(String id);
	User get(String id);

}
