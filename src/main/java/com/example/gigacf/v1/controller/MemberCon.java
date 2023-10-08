package com.example.gigacf.v1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.gigacf.v1.vo.Cust_info;
import com.example.gigacf.v1.service.MemberSvc;

@Controller
public class MemberCon {

	@Autowired
	MemberSvc memberSvc;
	
    @RequestMapping("/v1/member")
    public String doMember(Model model){
    	List<Cust_info> list = memberSvc.doMemberList();
    	model.addAttribute("list", list);
        return "/v1/member/member";
    }
    
    @RequestMapping("/v1/member_search")
    public String doSearchMember(@ModelAttribute Cust_info cust_info, Model model) {
    	List<Cust_info> list = memberSvc.doSearchMember(cust_info);
    	model.addAttribute("list", list);
    	return "/v1/member/member";
    }
    
}
