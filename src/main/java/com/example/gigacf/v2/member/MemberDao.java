package com.example.gigacf.v2.member;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.gigacf.v2.common.commonLogics.AbstractDAO;
import com.example.gigacf.v2.member.MemberVo;

@Repository
public class MemberDao extends AbstractDAO<MemberVo> {

		List<MemberVo> selectList(){
			return selectList("member.selectList");
		};

		List<MemberVo> searchList(MemberVo vo){
			return selectList("member.searchList", vo);
		};

}
