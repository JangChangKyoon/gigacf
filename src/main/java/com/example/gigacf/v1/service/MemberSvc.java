package com.example.gigacf.v1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gigacf.v1.vo.Cust_info;
import com.example.gigacf.v1.dao.MemberDao;





@Service
public class MemberSvc {

	@Autowired
	MemberDao memberDao;
	
	public List<Cust_info> doMemberList() {
		List<Cust_info> list = memberDao.doMemberList();
		return list;
	}

	public List<Cust_info> doSearchMember(Cust_info member_list) {
		List<Cust_info> list = memberDao.doSearchMember(member_list);
		return list;
	}

}
