package com.example.gigacf.v1.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.gigacf.v1.vo.Coffee_menu;

import java.util.List;
import java.util.Map;

// For the Purpose of accessing the Database using Sqlmapper.xml 
// resources/sqlmapper/v1CoffeeMenu.xml의 sql문으로 DB에서 데이터를 가져와서 여기로 보낸다.
@Mapper
public interface MenuDao {

	// 메뉴 조회하기
	// From MenuSvc_doList
	List<Coffee_menu> doList();

	// 메뉴 등록하기
	// From MenuSvc_doInsert To sqlmapper_CoffeeMenu
	int doInsert(Coffee_menu coffee_menu);

	// Deleting One of Menus
	// Sending strNo(from Dao) to Database using sqlMapper
	int doDelete(@Param("strNo") String strNo);

	
	// UPDATE -----------------------------------------------------------------------------------------
	
	// Finding OneRow for Updating One of Menu
	Map<String, Object> doListOne(@Param("strNo") String strNo);

	// Update OneRow
	int doUpdate(Coffee_menu coffee_menu);

	// Search --------------------------------------------------------------------------------------------------------
	List<Coffee_menu> doSearch(Coffee_menu coffee_menu);
	
	
	
	// Update the Multichecked -----------------------------------------------------------------------------------------
	
	// Update MultiChecked Price(loop by spring, Not Used)
	int doUpdatePrice(@Param("strNo") String strNo, @Param("strPrice") String strPrice);
	
	// Update MultiChecked Price Log(loop by spring, Not Used)
	int doInsertLog(@Param("strNo") String strNo, @Param("strPrice") String strPrice);
	
	// Update MultiChecked Price(Loop by DynamicSQL)
	int doUpdatePriceDynamicSQL(@Param("chkNoList") List<String> chkNoList, @Param("strPrice") String strPrice);
	
	// Update MultiChecked Price Log(Loop by DynamicSQL)
	int doInsertLogDynamicSQL(@Param("chkNoList") List<String> chkNoList, @Param("strPrice") String strPrice);
	
	// 트랜젝션 분리 실험용 (MenuSvc UpdateInsert 매소드의 finally에 적용됨. 
	int doTransactionSeparationLog(@Param("strClass") String strClass);
}
