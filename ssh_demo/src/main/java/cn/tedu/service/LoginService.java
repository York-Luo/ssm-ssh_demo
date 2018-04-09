package cn.tedu.service;

public interface LoginService {
	/**
	 * 0-通过
	 * 1-账号错误
	 * 2-密码错误
	 * @param adminCode
	 * @return
	 */
	public int checkUser(String adminCode,String password);
	
}
