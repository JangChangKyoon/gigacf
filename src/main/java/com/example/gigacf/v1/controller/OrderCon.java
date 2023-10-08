package com.example.gigacf.v1.controller;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.gigacf.v1.vo.Order_info;
import com.example.gigacf.v1.service.OrderSvc;

@Controller
@RequestMapping("/v1")
public class OrderCon {

	@Autowired
	OrderSvc orderSvc;

	@RequestMapping("/order")
    public String doOrder(Model model){
    	
    	// Data 만들기
    	List<Order_info> list = orderSvc.doList();
    	
    	model.addAttribute("list", list);

        return "/v1/order/order";
    }

	@RequestMapping("/order_search")
    public String doSearch(@RequestParam("start_date") String strStart_date, @RequestParam("end_date") String strEnd_date, 
    		@RequestParam(value="coffee", defaultValue = "ALL") String strCoffee, @RequestParam("name") String strName, Model model) {
    	List<Order_info> list = orderSvc.doSearch(strStart_date, strEnd_date, strCoffee, strName);
		
    	model.addAttribute("list", list);
		
		return "/v1/order/order";
    }

}
