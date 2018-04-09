package cn.tedu.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import cn.tedu.service.CostService;

@Repository
public class CheckCostNameAction {
	@Resource
	private CostService costService;
	//传入的参数
	private String costName;
	//传出的参数
	private boolean pass;
	public String getCostName() {
		return costName;
	}

	public void setCostName(String costName) {
		this.costName = costName;
	}

	
	public boolean isPass() {
		return pass;
	}

	public void setPass(boolean pass) {
		this.pass = pass;
	}

	public String execute(){
		System.out.println(costName);
		boolean flag=costService.checkCostName(costName);
		System.out.println(flag);
		if(flag){
			System.out.println(1111);
			return "success";
		}
		return "error";
	}
}
