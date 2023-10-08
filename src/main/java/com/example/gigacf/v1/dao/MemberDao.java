package com.example.gigacf.v1.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.gigacf.v1.vo.Cust_info;

@Mapper
public interface MemberDao {

	List<Cust_info> doMemberList();

	List<Cust_info> doSearchMember(Cust_info member_list);

}
