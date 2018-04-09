package cn.tedu.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.dao.AdminDAO;
import cn.tedu.entity.Admin;

@Service
public class LoginServiceImpl implements LoginService {

	@Resource
	private AdminDAO adminDAO;
	
	public int checkUser(String adminCode, String password) {
		Admin a=adminDAO.findByCode(adminCode);
		if(a==null){
			return 1;
		}else if(!a.getPassword().equals(password)){
			return 2;
		}
		return 0;
	}

}
