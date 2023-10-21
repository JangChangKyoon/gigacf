package com.example.gigacf.v2.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.gigacf.v2.vo.Cust_info;

@Mapper
public interface MemberDaoV2 {

	List<Cust_info> doMemberList();

	List<Cust_info> doSearchMember(Cust_info member_list);

}
