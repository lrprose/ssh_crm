package com.rose.service;

import com.rose.domain.User;

public interface UserService {

	//登录方法
	User getUserByCodePassword(User u);
	
	//注册用户
	void saveUser(User u);
}
