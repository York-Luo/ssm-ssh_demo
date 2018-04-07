package cn.tedu.cloudnote.service;

import cn.tedu.cloudnote.entity.User;

public interface UserService {
	public User login(String name,String password)throws NameException,PasswordException;
	public User regist(String name,String password,String nick);
}
