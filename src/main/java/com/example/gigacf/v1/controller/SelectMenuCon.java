package com.example.gigacf.v1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/v1")
public class SelectMenuCon {

	@RequestMapping("/selectmenu")
	public String doSelectMenu() {
		return "/v1/selectMenu/selectMenu";
	}
	
	
}
