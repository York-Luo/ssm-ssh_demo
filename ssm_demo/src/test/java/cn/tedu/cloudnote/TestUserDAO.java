package cn.tedu.cloudnote;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.cloudnote.dao.UserDAO;
import cn.tedu.cloudnote.entity.User;

public class TestUserDAO {
	private UserDAO userDAO;
	@Before
	public void init(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("conf/spring-mybatis.xml");
		userDAO=(UserDAO) ac.getBean("userDAO");
	}
	@Test
	public void test1(){
		User user=userDAO.findUserByName("demo");
		System.out.println(user);
	}
	@Test 
	public void TestAddUser(){
		User user=new User();
		user.setId("2");
		user.setName("sq");
		user.setNick("xiaoquan");
		user.setPassword("123456");
		user.setToken(null);
		userDAO.addUser(user);
	}
}
