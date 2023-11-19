package com.example.gigacf.v2.order.customerOrder;

import java.util.List;

import org.springframework.stereotype.Repository;
import com.example.gigacf.v2.common.commonLogics.AbstractDAO;
import com.example.gigacf.v2.menu.MenuVo;
import com.example.gigacf.v2.order.OrderVo;

@Repository
public class CustomerOrderDao extends AbstractDAO<MenuVo> {

	/* List<> doList(); */
	
	public List<MenuVo> selectList (){
		return selectList("order.selectList_cust"); // []
	}
	
	public void insertList(OrderVo orderVo) {
		insert("order.insertList", orderVo);
	}

	//int orderSelectMenu(@Param("coffeeNoList") List<String> coffeeNoList);
	
}
 