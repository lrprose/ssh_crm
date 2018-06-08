package com.rose.dao;

import com.rose.domain.User;

public interface UserDao extends BaseDao<User>{
	//根据登录名称查询user对象
	User getUserByCode(String usercode);


}
