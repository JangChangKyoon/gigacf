package com.example.gigacf.comm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.gigacf.v1.dao.MenuDao;

// 트렌젝션 분리용 class 
@Service
//@Transactional(propagation = Propagation.REQUIRES_NEW) 
// Propagation.REQUIRES_NEW : 다른 클래스의 메소드(transaction 설정된) 안에서 이렇게 무조건 실행되도록 할 수 있다.  
public class TransactionSeparationLog {

	@Autowired
	MenuDao menuDao;
	
	public int doTransactionSeparationLog(String strClass) {
		int i = menuDao.doTransactionSeparationLog(strClass);
		return i;
	}
	
}
