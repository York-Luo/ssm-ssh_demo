package cn.tedu.dao;

import org.springframework.stereotype.Repository;

import cn.tedu.entity.Cost;
@Repository
public class CostDAOImpl implements CostDAO {

	public Cost findCostByCostName(String costName) {
		if(costName==null){
			return null;
		}else if("tarena".equals(costName)){
			Cost c=new Cost();
			c.setCostId(1);
			c.setName("tarena");
			c.setStatus("0");
			return c;
		}
		return null;
	}

}
