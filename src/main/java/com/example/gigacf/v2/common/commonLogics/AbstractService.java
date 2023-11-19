package com.example.gigacf.v2.common.commonLogics;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.example.gigacf.v2.menu.MenuVo;

public class AbstractService<T, K extends Object, J> { // T 반환타입, K 매개변수타입
	
	public List<T> selectList(){
		return null;
	};
	
	public List<T> searchList(K vo){
		return null;
	};
	
	public T findOneByNo(K vo){
		return null;
	};
	
	public void createOne(K vo) {};
	
	public void deleteOne(K vo){};
	
	public void updateOne(K vo){};
	
	public void updateItems(K vo){};
	
	public void createList(J j) {
	};

	
	
}
