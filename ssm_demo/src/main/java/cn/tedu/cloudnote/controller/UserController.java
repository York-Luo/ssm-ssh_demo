package cn.tedu.cloudnote.controller;

import java.io.Serializable;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.cloudnote.entity.User;
import cn.tedu.cloudnote.service.NameException;
import cn.tedu.cloudnote.service.PasswordException;
import cn.tedu.cloudnote.service.UserService;
import cn.tedu.cloudnote.util.JsonResult;

@Controller
@RequestMapping("/user")
public class UserController extends ExceptionController implements Serializable{

	private static final long serialVersionUID = -6894789587753349682L;
	@Resource(name="userService1")
	private UserService userService;
	
	@ExceptionHandler(NameException.class)
	@ResponseBody
	public JsonResult NameExp(NameException e){
		e.printStackTrace();
		return new JsonResult(2,e);
	}
	
	@ExceptionHandler(PasswordException.class)
	@ResponseBody
	public JsonResult PasswordExp(PasswordException e){
		e.printStackTrace();
		return new JsonResult(3,e);
	}
	
	
	@RequestMapping("/login.do")
	@ResponseBody
	public JsonResult login(String name,String password){
		User user=userService.login(name, password);
		return new JsonResult(user);
	}
	
	@RequestMapping("/regist.do")
	@ResponseBody
	public JsonResult regist(String username,String password,String nick){
		System.out.println(password);
		User user=userService.regist(username, password,nick);
		return new JsonResult(user);
	}
	
}
