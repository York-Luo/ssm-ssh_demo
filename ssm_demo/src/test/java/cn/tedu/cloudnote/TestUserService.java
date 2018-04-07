package cn.tedu.cloudnote;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.cloudnote.entity.User;
import cn.tedu.cloudnote.service.UserService;

public class TestUserService {
	private UserService userService;
	@Before
	public void init(){
		String[] conf={
				"conf/spring-mybatis.xml",
				"conf/spring-mvc.xml"};
		ApplicationContext ctx
				=new ClassPathXmlApplicationContext(conf);
		
		userService=ctx.getBean("userService1", UserService.class);
	}
	@Test
	public void test1(){
		System.out.println(222);
		System.out.println(userService);
		User user=userService.login("demo", "c8837b23ff8aaa8a2dde915473ce0991");
		System.out.println(333);
		System.out.println(user);
	}
}
