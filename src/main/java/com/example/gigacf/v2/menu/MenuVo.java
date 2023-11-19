package com.example.gigacf.v2.menu;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MenuVo {
	private String no;
	private String coffee; // 기본 value를 All로 설정
	private String kind = "All";
	private String price;
	private String reg_day;
	private String mod_day;
	
	// 다중 선택
	private List<String> chkNoList;
	
	// View를 통해 들어와서 DB 날짜 조회하는 용도
	private String start_date;
	private String end_date;
}
