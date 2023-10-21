package com.example.gigacf.v2.vo;

import lombok.Data;

@Data
public class Order_info {
	private String no;
	private String coffee_name;
	private String coffee_price;
	private String cust_name;
	private String reg_day;
	private String coffee_no;
	private String cust_id = "1";
	private String order_num;
	private String reception;
	private String served;
}
