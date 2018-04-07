package cn.tedu.cloudnote.service;

import java.io.Serializable;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import cn.tedu.cloudnote.dao.UserDAO;
import cn.tedu.cloudnote.entity.User;
import cn.tedu.cloudnote.util.NodeUtil;
@Repository("userService1")
public class UserServiceImpl implements Serializable,UserService {

	private static final long serialVersionUID = -2632097981991792597L;
	@Resource(name="userDAO")
	private UserDAO userDAO;
	public User login(String name, String password) throws NameException,PasswordException{
		System.out.println(555);
		if(name==null||name.trim().isEmpty()){
			throw new NameException("用户名不能为空");
		}
		if(password==null||password.trim().isEmpty()){
			throw new PasswordException("密码不能为空");
		}
		User user=userDAO.findUserByName(name);
		if(user==null){
			throw new NameException("没有该用户名");
		}else if(user.getPassword().equals(password)){
			System.out.println(444);
			return user;
		}else{
			throw new PasswordException("密码错误");
		}
	}
	public User regist(String name, String password, String nick) {
		if(name==null){
			throw new NameException("请输入用户名");
		}
		if(password==null){
			throw new PasswordException("请输入密码");
		}
		if(nick==null){
			nick=name;
		}
		
		User user=userDAO.findUserByName(name);
		if(user!=null){
			throw new NameException("用户名已存在");
		}
		User u=new User();
		u.setId(NodeUtil.createId());
		u.setName(name);
		u.setNick(nick);
		u.setPassword(password);
		u.setToken(null);
		userDAO.addUser(u);
		return u;
	}
	
	
}
