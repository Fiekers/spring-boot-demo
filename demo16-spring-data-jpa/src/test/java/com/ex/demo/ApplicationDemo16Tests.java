package com.ex.demo;

import java.util.Date;

import com.ex.demo.bean.UserLog;
import com.ex.demo.dao.UserLogDao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.test.context.junit4.SpringRunner;

// 需要创建好数据库，没有做自动创建的设置
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationDemo16Tests {
    @Autowired
    private UserLogDao userLogDao;

    @Test
    public void insert() {
        UserLog entity = new UserLog();
        entity.setUserName("无境");
        entity.setUserIp("192.168.0.1");
        entity.setCreateTime(new Date());
        userLogDao.save(entity);
    }

    @Test
    public void delete() {
        userLogDao.delete(1);
    }

    @Test
    public void update() {
        UserLog entity = new UserLog();
        entity.setId(2);
        entity.setUserName("无境2");
        entity.setUserIp("192.168.0.1");
        entity.setCreateTime(new Date());
        userLogDao.save(entity);
    }

    @Test
    public void select() {
        UserLog result = userLogDao.findOne(2);
        System.out.println(result);
    }

    @Test
    public void select2() {
        UserLog result = userLogDao.findByUserName("无境2");
        System.out.println(result);
    }

    // 分页
    @Test
    public void queryForPage() {
        Pageable pageable = new PageRequest(0, 20, new Sort(new Order(Direction.DESC, "id")));
        //Page<UserLog> result = UserLogDao.findByUserName("无境2", pageable);
        Page<UserLog> result = userLogDao.findAll(pageable);
        System.out.println(result.getContent());
    }


}
