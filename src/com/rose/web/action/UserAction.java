package com.rose.web.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.rose.domain.User;
import com.rose.service.UserService;

public class UserAction extends ActionSupport implements ModelDriven<User>{

	private User user = new User();
	private UserService userService;
	

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	
	public String login() throws Exception {
		
		//调用service执行登录
		User u = userService.getUserByCodePassword(user);
		//将返回的User对象放入session域
		ActionContext.getContext().getSession().put("user", u);
		//重定向到项目首页
		return "toHome";
	}


	@Override
	public User getModel() {
		return user;
	}



	
	
}
