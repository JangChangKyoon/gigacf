package com.example.gigacf.v2.member;

import lombok.Data;

@Data
public class MemberVo {
	private String no;
	private String cust_id;
	private String name = "ALL";
	private String phone;
	private String role;
	private String reg_day;
	
	private String start_date;
	private String end_date;
}
