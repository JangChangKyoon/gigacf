package com.example.gigacf.v2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gigacf.v2.vo.Order_info;

import com.example.gigacf.v2.dao.OrderDaoV2;

@Service("OrderSvcV2")
public class OrderSvc {

	@Autowired
	OrderDaoV2 orderDao;
	
	public List<Order_info> doList () {
		
		List<Order_info> list = orderDao.doList();
		
		return list;
	}

	public List<Order_info> doSearch(String strStart_date, String strEnd_date, String strCoffee,
			String strName) {
		
		List<Order_info> list = orderDao.doSearch(strStart_date, strEnd_date, strCoffee, strName);
		
		
		return list;
	}
}
