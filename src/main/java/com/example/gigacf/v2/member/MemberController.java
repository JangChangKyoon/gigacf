package com.example.gigacf.v2.member;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/v2/member")
public class MemberController {

	private final MemberService memberService;
	
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@GetMapping("/member_list")
	public ModelAndView showMemberList(MemberVo memberVo) {
		ModelAndView mv = new ModelAndView("/v2/member/member");
		List<MemberVo> memberList = memberService.selectList();
		mv.addObject("memberList", memberList);
		return mv;
	}
	
	@PostMapping("/member_search")
	public ModelAndView showMemberSearchList(MemberVo memberVo) {
		ModelAndView mv = new ModelAndView("/v2/member/member");
		List<MemberVo> memberList = memberService.searchList(memberVo);
		mv.addObject("memberList", memberList);
		return mv;
	}
}
