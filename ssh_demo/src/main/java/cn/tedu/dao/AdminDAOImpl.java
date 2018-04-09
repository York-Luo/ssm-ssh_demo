package cn.tedu.dao;

import org.springframework.stereotype.Repository;

import cn.tedu.entity.Admin;
@Repository
public class AdminDAOImpl implements AdminDAO {

	public Admin findByCode(String code) {
		if(code==null){
			return null;
		}
		if(code.equals("caocao")){
			Admin a=new Admin();
			a.setAdminId(1);
			a.setAdminCode("caocao");
			a.setPassword("123");
			//其他值省略
			return a;
		}
		return null;
	}

}
