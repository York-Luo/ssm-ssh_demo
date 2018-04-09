package cn.tedu.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.dao.CostDAO;
import cn.tedu.entity.Cost;
@Service
public class CostServiceImpl implements CostService {
	@Resource
	private CostDAO costDAO;
	public boolean checkCostName(String costName) {
		Cost cost=costDAO.findCostByCostName(costName);
		return cost!=null;
	}

}
