package com.ex.demo.dao;

import com.ex.demo.bean.UserLog;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserLogDao  extends JpaRepository<UserLog, Integer> {
    @Query(value="select u from UserLog u where u.userName=?1")
    UserLog findByUserName(String string);

    UserLog findByUserNameAndUserIp(String string, String ip);

    Page<UserLog> findByUserName(String string, Pageable pageable);
}
