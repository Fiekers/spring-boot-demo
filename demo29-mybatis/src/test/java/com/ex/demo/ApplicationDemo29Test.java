package com.ex.demo;

import com.ex.demo.bean.User;
import com.ex.demo.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationDemo29Test {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void insert(){
        User u  = new User();
        u.setName("测试demo");
        u.setCreateTime(new Date());
        int res = userMapper.insert(u);
        System.out.println(res);
    }
}