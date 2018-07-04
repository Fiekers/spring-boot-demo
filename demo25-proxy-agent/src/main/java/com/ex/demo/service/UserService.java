package com.ex.demo.service;

import com.ex.demo.bean.User;
import com.ex.demo.bean.UserLog;
import com.ex.demo.dao.UserDao;
import com.ex.demo.dao.UserLogDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserLogDao userLogDao;

    /**
     * 用户注册
     *
     * @return
     */
    @Transactional
    public String register(String name, String ip) {
        // 1.添加用户
        User user = new User();
        user.setName(name);
        user.setCreateTime(new Date());
        userDao.insert(user);

        // 测试使用
          boolean flag = true;
          if (flag) {
          	throw new RuntimeException();
          }

        // 2.添加注册日志
        UserLog userLog = new UserLog();
        userLog.setUserName(name);
        userLog.setUserIp(ip);
        userLog.setCreateTime(new Date());
        userLogDao.save(userLog);
        return "success";
    }
}