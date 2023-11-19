package com.example.gigacf.v2.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gigacf.v2.dao.SelectMenuDaoV2;
import com.example.gigacf.v2.vo.Coffee_menu;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service("SelectMenuSvcV2")
public class SelectMenuSvc {

	@Autowired
	SelectMenuDaoV2 selectMenuDao;

	public List<Coffee_menu> doMenuList() {
		List<Coffee_menu> list = selectMenuDao.doList();

		return list;
	}

	// List<Map<String, String>>
	public int orderSelectedMenu(List<Map<String, String>> orderList) {
		log.info(orderList);
		
		// coffeeNo 리스트 만들기
        List<String> coffeeNoList = new ArrayList<>();

        for (Map<String, String> item : orderList) {
            int number = Integer.parseInt(item.get("number"));
            String coffee = item.get("coffee");

            for (int i = 0; i < number; i++) {
                coffeeNoList.add(coffee);
            }
        }

        System.out.println("CoffeeMo List: " + coffeeNoList);
        
        int list = selectMenuDao.orderSelectMenu(coffeeNoList);
		return list;
	}
}
