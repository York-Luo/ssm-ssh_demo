package cn.tedu.cloudnote.dao;

import org.springframework.stereotype.Repository;

import cn.tedu.cloudnote.entity.User;
@Repository("userDAO")
public interface UserDAO {
	public User findUserByName(String name);
	public void addUser(User user);
}
