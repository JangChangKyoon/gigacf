package com.example.gigacf.v2.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gigacf.v2.common.commonLogics.AbstractService;
import com.example.gigacf.v2.member.MemberDao;

@Service
public class MemberService extends AbstractService<MemberVo, MemberVo, List<?>> {
	
	private final MemberDao memberDao;
	
	@Autowired
	public MemberService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	@Override
	public List<MemberVo> selectList(){
		List<MemberVo> memberList = memberDao.selectList();
		return memberList;
	};
	
	@Override
	public List<MemberVo> searchList(MemberVo vo){
		List<MemberVo> memberList = memberDao.searchList(vo);
		return memberList;
	};
}
