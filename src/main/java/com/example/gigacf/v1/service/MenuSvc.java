package com.example.gigacf.v1.service;


import com.example.gigacf.v1.vo.Coffee_menu;
import com.example.gigacf.comm.exception.MyExceptionRuntime;
import com.example.gigacf.v1.dao.MenuDaoV1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputFilter.Status;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

@Service
@Log4j2
public class MenuSvc {
	// Di of Dao
	// Role of Dao : 데이터베이스를 조회하는 통로
	@Resource(name="menuDaoV1")
	MenuDaoV1 menuDaoV1;
	
	// 1. Prior Step : MenuCon_doInsert에서 유저로부터 받은 요청을 가져와서 여기서 로직처리
	public List<Coffee_menu> doList() {
		// 2. MenuCon_doInsert에서 데이터를 가져올 때는 MenuDao를 통해서 DB에서 데이터를 가져와서 로직처리
		List<Coffee_menu> list = menuDaoV1.doList();
		log.info(list); 
		// 3. Following Step : 로직처리가 되면 다시 controller로 보내서 유저에게 보여줌
		return list;
	}

	// DB만들기 전에 test용 더비 데이터
	public List<Map<String, Object>> doListOld() {

		// Data 만들기 , List , Map
		List<Map<String, Object>> list = new ArrayList<>();

		Map<String, Object> map = new HashMap<>();
		map.put("no", "1");
		map.put("name", "아이스아메");
		map.put("kind", "커피");
		map.put("price", "5,000");
		map.put("reg_day", "2020.10.29");
		map.put("mod_day", "2021.10.29");
		list.add(map);

		Map<String, Object> map2 = new HashMap<>();

		map2.put("no", "2");
		map2.put("name", "카푸치노");
		map2.put("kind", "커피");
		map2.put("price", "6,000");
		map2.put("reg_day", "2020.10.29");
		map2.put("mod_day", "2021.10.29");
		list.add(map2);

		Map<String, Object> map3 = new HashMap<>();

		map3.put("no", "3");
		map3.put("name", "카페라떼");
		map3.put("kind", "커피");
		map3.put("price", "6,500");
		map3.put("reg_day", "2020.10.29");
		map3.put("mod_day", "2021.10.29");
		list.add(map3);

		log.info(list);

		return list;
	}

	// INSERT
	// ----------------------------------------------------------------------------------------------

	// 1. Prior Step : Receive user's request from MenuCon_doInsertPost
	public int doInsert(Coffee_menu coffee_menu) {
		// 2. meuDao : Receive data from view&controller and the give to DB using
		// menuDao
		int i = menuDaoV1.doInsert(coffee_menu);
		log.info("------------------con deinsert---------------------");
		log.info(coffee_menu);

		// 3. Following Step : Send result to MenuCon_doInsertPost back
		return i;
	}

	// DELETE
	// --------------------------------------------------------------------------------------------

	// 1. Prior Step : Receive user's request from MenuCon
	public int doDelete(String strNo) {
		// 2. Send strNo to Database for the purpose of deleting the data ussing Dao &
		// sqlmapper
		int i = menuDaoV1.doDelete(strNo);
		// 3. Following Step : Send result to MenuCon_doDelete back
		return i;
	}

	// UPDATE
	// ------------------------------------------------------------------------------------------------

	// Inquerying oneRow using strNo for Updating One
	public Map<String, Object> doListOne(String strNo) {
		Map<String, Object> map = menuDaoV1.doListOne(strNo);
		return map;
	}

	public int doUpdate(Coffee_menu coffee_menu) {
		int i = menuDaoV1.doUpdate(coffee_menu);
		return i;
	}

	// SEARCH
	// --------------------------------------------------------------------------------------------------

	// Search
	public List<Coffee_menu> doSearch(Coffee_menu coffee_menu) {
		log.info("MenuSvc :" + coffee_menu);
		List<Coffee_menu> list = menuDaoV1.doSearch(coffee_menu);
		return list;
	}

	// UPDATE the Multichecked
	// ------------------------------------------------------------------------------

	// Update mutichecked price(loof in spring, Not Used)
	public int doUpdatePrice(String strNo, String strPrice) {
		int i = menuDaoV1.doUpdatePrice(strNo, strPrice);
		return i;
	}

	// Update multichecked price log(loof in spring, Not Used)
	public int doInsertLog(String strNo, String strPrice) {
		int i = menuDaoV1.doInsertLog(strNo, strPrice);
		return i;
	}

	// Update mutichecked price(loof in DB by dynamicSQL, Not Used)
	public int doUpdatePriceDynamicSQL(List<String> chkNoList, String strPrice) {
		int i = menuDaoV1.doUpdatePriceDynamicSQL(chkNoList, strPrice);
		return i;
	}

	// Update multichecked price log(loof in DB by dynamicSQL, Not Used)
	public int doInsertLogDynamicSQL(List<String> chkNoList, String strPrice) {
		int i = menuDaoV1.doInsertLogDynamicSQL(chkNoList, strPrice);
		return i;

	}
	
	
	@Autowired
	TransactionSeparationLog transactionSeparationLog;
	
	@Autowired
	PlatformTransactionManager transactionManager;
	
	@Autowired
	TransactionDefinition transactionDefinition;
	
	@Autowired
	TransactionTemplate transactionTemplate;
	
	
	// Update the Mutichecked Price and log
	// @Transactional(rollbackFor = Exception.class)
	// @Transactional
	public int doUpdateInsert(List<String> chkNoList, String strPrice) throws RuntimeException {

		int rI = 0;

		try {
			
			// transactionTemplate으로 트렌젝션 관리
			// return이 없는 경우 : 객체를 인자로 가져옴
			transactionTemplate.execute(new TransactionCallbackWithoutResult() {
				
				@Override
				protected void doInTransactionWithoutResult(TransactionStatus status) {
					int i1 = menuDaoV1.doUpdatePriceDynamicSQL(chkNoList, strPrice);
					//status.isRollbackOnly();
					
				}
			});
			
			// transactionTemplate으로 트랜젝션 관리
			// return이 있는 경우 : 람다를 사용
			rI = transactionTemplate.execute(status -> {
				int i2 = menuDaoV1.doInsertLogDynamicSQL(chkNoList, strPrice);
				status.setRollbackOnly(); //로그기록은 꺼둠
				return i2;
			});
			
		} catch (Exception e) {
			throw new MyExceptionRuntime(e.getMessage(), getClass().getName());
		} finally {
			
			// transactionManager로 트랜젝션 관리
			TransactionStatus status3 = transactionManager.getTransaction(transactionDefinition);
			transactionSeparationLog.doTransactionSeparationLog(strPrice+getClass().getName());
			transactionManager.rollback(status3); 
		}

		return rI;
	}

}
