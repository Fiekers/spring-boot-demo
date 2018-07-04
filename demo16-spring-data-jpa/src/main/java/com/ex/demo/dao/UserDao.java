package com.ex.demo.dao;

import com.ex.demo.util.base.Page;
import com.ex.demo.bean.User;

public interface UserDao {

	int insert(User User);

	int deleteById(int id);

	int updateById(User User);

	User selectById(int id);

	Page<User> queryForPage(int i, int j, String string);

}
