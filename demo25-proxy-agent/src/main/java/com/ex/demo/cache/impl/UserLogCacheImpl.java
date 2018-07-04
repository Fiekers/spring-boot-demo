package com.ex.demo.cache.impl;

import com.ex.demo.bean.UserLog;
import com.ex.demo.cache.UserLogCache;
import com.ex.demo.dao.UserLogMongoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

@CacheConfig(cacheNames = "demoCache")
@Repository
public class UserLogCacheImpl implements UserLogCache {

	@Autowired
	private UserLogMongoDao userLogMongoDao;

	@Cacheable(key = "#p0")
	@Override
	public UserLog selectById(Integer id) {
		System.out.println("查询功能，缓存找不到，直接读库, id=" + id);
		return userLogMongoDao.findOne(id);
	}


	@CachePut(key = "#p0")
	@Override
	public UserLog updateById(UserLog userLog) {
		System.out.println("更新功能，更新缓存，直接写库, id=" + userLog);
		return userLogMongoDao.save(userLog);
	}

	@CacheEvict(key = "#p0")
	@Override
	public String deleteById(Integer id) {
		System.out.println("删除功能，删除缓存，直接写库, id=" + id);
		return "清空缓存成功";
	}

}
