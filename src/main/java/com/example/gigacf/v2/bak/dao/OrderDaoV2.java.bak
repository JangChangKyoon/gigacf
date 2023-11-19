package com.example.gigacf.v2.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.gigacf.v2.vo.Order_info;

@Mapper
public interface OrderDaoV2 {

	List<Order_info> doList();

	List<Order_info> doSearch(@Param("strStartDate") String strStartDate, @Param("strEndDate") String strEndDate,
			@Param("strCoffee") String strCoffee, @Param("strName") String strName);

}
