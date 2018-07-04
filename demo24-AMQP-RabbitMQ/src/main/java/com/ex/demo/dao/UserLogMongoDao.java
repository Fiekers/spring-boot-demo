package com.ex.demo.dao;

import com.ex.demo.bean.UserLog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserLogMongoDao extends MongoRepository<UserLog,Integer> {
    UserLog findByUserName(String string);

    UserLog findByUserNameAndUserIp(String string, String ip);

    Page<UserLog> findByUserName(String string, Pageable pageable);
}
