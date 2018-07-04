package com.ex.demo.controller;
import java.util.Date;

import com.ex.demo.bean.UserLog;
import com.ex.demo.cache.UserLogCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;

@RestController
@RequestMapping(value = "/rest")
public class RestDemoController {

    @Autowired
    private UserLogCache userLogCache;

    @RequestMapping(value = "/update")
    public UserLog update(@RequestBody JsonNode jsonNode) {
        System.out.println("jsonNode=" + jsonNode);
        UserLog bean = userLogCache.selectById(jsonNode.get("id").asInt(1));
        if(bean == null){
            bean = new UserLog();
        }
        bean.setUserName("测试");
        bean.setCreateTime(new Date());
        bean.setUserIp("192.168.1.1");
        userLogCache.updateById(bean);
        return bean;
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public UserLog update2(@PathVariable(value = "id") Integer id) {
        UserLog bean = userLogCache.selectById(id);
        if(bean == null){
            bean = new UserLog();
        }
        bean.setUserName("测试");
        bean.setCreateTime(new Date());
        bean.setUserIp("192.168.1.1");
        userLogCache.updateById(bean);
        return bean;
    }
}