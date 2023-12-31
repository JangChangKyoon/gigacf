package com.example.gigacf.v1.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.gigacf.v1.dao.MenuDaoV1;

// 트렌젝션 분리용 class 
@Service
//@Transactional(propagation = Propagation.REQUIRES_NEW) 
// Propagation.REQUIRES_NEW : 다른 클래스의 메소드(transaction 설정된) 안에서 이렇게 무조건 실행되도록 할 수 있다.  
public class TransactionSeparationLog {

	@Resource(name="menuDaoV1")
	MenuDaoV1 menuDao;
	
	public int doTransactionSeparationLog(String strClass) {
		int i = menuDao.doTransactionSeparationLog(strClass);
		return i;
	}
	
}
