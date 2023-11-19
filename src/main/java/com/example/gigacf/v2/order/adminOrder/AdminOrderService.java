package com.example.gigacf.v2.order.adminOrder;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gigacf.v2.common.commonLogics.AbstractService;
import com.example.gigacf.v2.order.OrderVo;

@Service
public class AdminOrderService extends AbstractService<OrderVo, OrderVo, List<?>> {

	private final AdminOrderDao adminOrderDao;
	
	/** 생성자 의존성 주입의 장점
	 * 순환참조 오류를 서버를 구동할 때 바로 확인 할 수 있다.
	 */
	@Autowired
	public AdminOrderService(AdminOrderDao adminOrderDao){
		this.adminOrderDao = adminOrderDao;
	}

	@Override
	public List<OrderVo> selectList() {
		List<OrderVo> orderList = adminOrderDao.selectList();
		return orderList;
	}
	
	@Override
	public List<OrderVo> searchList(OrderVo orderVo){
		List<OrderVo> orderList = adminOrderDao.searchList(orderVo);
		return orderList;
	};

}
