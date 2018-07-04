package com.ex.demo;

import com.ex.demo.bean.User;
import com.ex.demo.dao.UserDao;
import com.ex.demo.util.base.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationDemo15Tests {

    @Autowired
    private UserDao userDao;

    @Test
    public void insert() {
        User user = new User();
        user.setName("测试");
        user.setCreateTime(new Date());
        int result = userDao.insert(user);
        System.out.println(result);
    }

    @Test
    public void delete() {
        int result = userDao.deleteById(1);
        System.out.println(result);
    }

    @Test
    public void update() {
        User user = new User();
        user.setId(2);
        user.setName("测试");
        user.setCreateTime(new Date());
        int result = userDao.updateById(user);
        System.out.println(result);
    }

    @Test
    public void select() {
        User result = userDao.selectById(2);
        System.out.println(result);
    }

    // 分页测试
    @Test
    public void queryForPage() {
        Page<User> result = userDao.queryForPage(1, 20, "测试");
        System.out.println(result.getList());
    }
}