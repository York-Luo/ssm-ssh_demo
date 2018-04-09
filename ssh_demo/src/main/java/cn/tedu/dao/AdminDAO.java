package cn.tedu.dao;

import cn.tedu.entity.Admin;

public interface AdminDAO {
	public Admin findByCode(String code);
}
