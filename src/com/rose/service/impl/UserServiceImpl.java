package com.rose.service.impl;

import com.rose.dao.UserDao;
import com.rose.domain.User;
import com.rose.service.UserService;

public class UserServiceImpl implements UserService{

	private UserDao ud;
	@Override
	public User getUserByCodePassword(User u) {
		//根据登录名称查询登录对象
		User existU = ud.getUserByCode(u.getUser_code());
		//判断用户名是否存在，不存在则抛出异常
		if(existU==null) {
			throw new RuntimeException("用户名不存在");	
		}
		//判断密码是否正确，不正确抛出异常
		if(!existU.getUser_password().equals(u.getUser_password())) {
			throw new RuntimeException("密码错误");
		}
		//返回查询到的User对象
		return existU;
	}

	@Override
	public void saveUser(User u) {
		ud.save(u);
		
	}

	public void setUd(UserDao ud) {
		this.ud = ud;
	}
	

}
