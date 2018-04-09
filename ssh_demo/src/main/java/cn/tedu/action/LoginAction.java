package cn.tedu.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import cn.tedu.service.LoginService;

@Component
@Scope("prototype")
public class LoginAction {
	@Resource
	private LoginService loginService;
	//传入的参数
	private String adminCode;
	private String password;
	//传出的参数
	private String error;
	private String code;
	
	public LoginService getLoginService() {
		return loginService;
	}


	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}


	public String getAdminCode() {
		return adminCode;
	}


	public void setAdminCode(String adminCode) {
		this.adminCode = adminCode;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getError() {
		return error;
	}


	public void setError(String error) {
		this.error = error;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String execute(){
		//检查验证码
		HttpSession session=ServletActionContext.getRequest().getSession();
		String imgCode=(String) session.getAttribute("imgCode");
		if(code==null||!code.equalsIgnoreCase(imgCode)){
			error="验证码错误";
			return "error";
		}
		System.out.println(loginService);
		System.out.println(adminCode);
		System.out.println(password);
		int i=loginService.checkUser(adminCode, password);
		System.out.println(i);
		if(i==1){
			error="账号错误";
		}else if(i==2){
			error="密码错误";
		}else if(i==0){
			return "success";
		}
		return "error";
	}
}
