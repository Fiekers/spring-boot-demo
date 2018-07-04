package com.ex.demo;

import com.ex.demo.bean.UserLog;
import com.ex.demo.component.RedisComponent;

import com.ex.demo.dao.UserLogMongoDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

// 需要创建好数据库，没有做自动创建的设置
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationDemo20Tests {

	@Autowired
	private UserLogMongoDao userLogMongoDao;

	@Test
	public void insert() {
		UserLog entity = new UserLog();
		entity.setId(1);
		entity.setUserName("无境");
		entity.setUserIp("192.168.0.1");
		entity.setCreateTime(new Date());
		userLogMongoDao.save(entity);
	}

	@Test
	public void delete() {
		userLogMongoDao.delete(1);
	}

	@Test
	public void update() {
		UserLog entity = new UserLog();
		entity.setId(2);
		entity.setUserName("无境2");
		entity.setUserIp("192.168.0.1");
		entity.setCreateTime(new Date());
		userLogMongoDao.save(entity);
	}

	@Test
	public void select() {
		UserLog result = userLogMongoDao.findOne(1);
		System.out.println(result);
	}

	@Test
	public void select2() {
		UserLog result = userLogMongoDao.findByUserName("无境2");
		System.out.println(result);
	}

	// 分页
	@Test
	public void queryForPage() {
		Pageable pageable = new PageRequest(0, 20, new Sort(new Sort.Order(Sort.Direction.DESC, "id")));
		// Page<UserLog> result = UserLogDao.findByUserName("无境2", pageable);
		Page<UserLog> result = userLogMongoDao.findAll(pageable);
		System.out.println(result.getContent());
	}
}
