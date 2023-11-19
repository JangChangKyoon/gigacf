package com.example.gigacf.v2.order.adminOrder;

import java.util.List;
import com.example.gigacf.v2.common.commonLogics.AbstractDAO;
import com.example.gigacf.v2.order.OrderVo;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
public class AdminOrderDao extends AbstractDAO<OrderVo> {
	
	List<OrderVo> selectList(){
		return selectList("order.selectList"); // [no, coffee_name, coffee_price, cust_id, cust_name, reg_day]
	};

	List<OrderVo> searchList(OrderVo orderVo){
		return selectList("order.searchList", orderVo); // [no, coffee_no coffee_name, coffee_price, cust_id, cust_name, reg_day, start_date, end_date]
	}
	
	
	/*
	 * List<Order_info> doSearch(@Param("strStartDate") String
	 * strStartDate, @Param("strEndDate") String strEndDate,
	 * @Param("strCoffee") String strCoffee, @Param("strName") String strName);
	 */

}
