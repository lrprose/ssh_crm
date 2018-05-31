package com.rose.test;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.rose.dao.UserDao;
import com.rose.domain.User;
import com.rose.service.UserService;

//测试hibernate
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class Hibernate_test {
	@Resource(name="sessionFactory")
	private SessionFactory sf;
	
	@Test
	//单独测试hibernate
	public void fun1() {
		
		Configuration conf = new Configuration().configure();
		SessionFactory sf = conf.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		//------------------------------------------
		User u = new User();
		u.setUser_code("mike");
		u.setUser_name("麦克");
		u.setUser_password("1234");
		session.save(u);
		
		
		//------------------------------------------
		tx.commit();
		session.close();
		sf.close();
	}
	
	//测试spring管理SessionFactory
	@Test
	public void fun2() {
		
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		//------------------------------------------
		User u = new User();
		u.setUser_code("mark");
		u.setUser_name("马");
		u.setUser_password("1234");
		session.save(u);
		
		
		//------------------------------------------
		tx.commit();
		session.close();
	}
	
	//测试Dao hibernateTemplate模板
	@Resource(name="userDao")
	private UserDao ud;
	@Test
	public void fun3() {
		User u = ud.getUserByCode("tom");
		System.out.println(u);
	
	}
	
	//测试事务
		@Resource(name="userService")
		private UserService us;
		@Test
		public void fun4() {
			
			User u = new User();
			u.setUser_code("park");
			u.setUser_name("帕克");
			u.setUser_password("1234");
			us.saveUser(u);
		
		}
	
	
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
}
