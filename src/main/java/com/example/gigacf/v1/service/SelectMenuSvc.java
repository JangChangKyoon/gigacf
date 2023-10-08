package com.example.gigacf.v1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gigacf.v1.dao.SelectMenuDao;
import com.example.gigacf.v1.vo.Coffee_menu;


@Service
public class SelectMenuSvc {

	@Autowired
	SelectMenuDao selectMenuDao;
	
	public List<Coffee_menu> doMenuList (){
		List<Coffee_menu> list = selectMenuDao.doList();
		return list;
	}
}
