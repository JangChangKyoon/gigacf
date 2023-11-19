package com.example.gigacf.v2.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.gigacf.v2.vo.Coffee_menu;

@Mapper
public interface SelectMenuDaoV2 {

	List<Coffee_menu> doList();

	int orderSelectMenu(@Param("coffeeNoList") List<String> coffeeNoList);
	
}
 