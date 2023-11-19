package com.example.gigacf.v2.order;

import java.util.List;

import lombok.Data;

@Data
public class OrderVo {
	private String no;
	private String reg_day;
	
	// 주문한 커피 정보
	private String coffee_name;
	private String coffee_price;
	private String coffee_no;
	
	// 고객정보 
	private String cust_id = "1"; 
	private String cust_name;
	
	// 미구현 변수
	private String order_num; // 미구현 
	private String reception; // 미구현
	private String served; // 주문완료 여부 - 미구현
	
	
	//--------------테이블 데이터 외 변수
	// search용
	private String start_date;
	private String end_date;
	
	//--------------- 다중 선택 주문용
	private List<String> coffeeNoList;
	
}
