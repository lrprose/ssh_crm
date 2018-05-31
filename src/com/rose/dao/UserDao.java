package com.rose.dao;

import com.rose.domain.User;

public interface UserDao {
	//根据登录名称查询user对象
	User getUserByCode(String usercode);

	//保存用户
	void save(User u);

}
