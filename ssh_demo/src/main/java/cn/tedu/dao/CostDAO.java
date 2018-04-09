package cn.tedu.dao;

import cn.tedu.entity.Cost;

public interface CostDAO {
	public Cost findCostByCostName(String costName);
}
