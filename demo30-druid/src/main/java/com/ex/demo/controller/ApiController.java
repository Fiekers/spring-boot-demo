package com.ex.demo.controller;

import com.ex.demo.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ex.demo.mapper.UserMapper;


@RestController
@RequestMapping("/api")
public class ApiController {

	@Autowired
	private UserMapper userMapper;

	@RequestMapping(value = "/select", method = RequestMethod.GET)
	public User get(@RequestParam(defaultValue = "1") Integer id) {
		System.out.println("==>select start");
		return userMapper.selectByPrimaryKey(id);
	}
}
