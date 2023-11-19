package com.example.gigacf.v2.order.customerOrder;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gigacf.v2.common.commonLogics.AbstractService;
import com.example.gigacf.v2.menu.MenuVo;
import com.example.gigacf.v2.order.OrderVo;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class CustomerOrderService extends AbstractService<MenuVo, Object, List<Map<String, String>>> {

	private final CustomerOrderDao customerOrderDao;

	@Autowired
	public CustomerOrderService(CustomerOrderDao customerOrderDao) {
		this.customerOrderDao = customerOrderDao;
	};

	@Override
	public List<MenuVo> selectList() {
		return customerOrderDao.selectList();
	};

	/* orderList 데이터 형태 : List<Map<String, String>>
	 * [{"coffee":"2","number":"1","price":"111"},{"coffee":"5","number":"2","price":"1111"}]
	 */
	@Override
	public void createList(List<Map<String, String>> orderList) {
		List<String> coffeeNoList = new ArrayList<String>();
		for(Map<String, String> orderOne : orderList) {
			int orderNum = Integer.parseInt(orderOne.get("number"));
			for(int i=0; i<orderNum; i++) {
				coffeeNoList.add(orderOne.get("coffee"));
			}
		}
		OrderVo orderVo = new OrderVo();
		orderVo.setCoffeeNoList(coffeeNoList);
		customerOrderDao.insertList(orderVo);
	};

	/*
	// List<Map<String, String>>
	public int orderSelectedMenu(List<Map<String, String>> orderList) {
		log.info(orderList);

		// coffeeNo 리스트 만들기

		List<String> coffeeNoList = new ArrayList<>();
		for (Map<String, String> item : orderList) {
			int number = Integer.parseInt(item.get("number"));
			String coffee = item.get("coffee");

			for (int i = 0; i < number; i++) {
				coffeeNoList.add(coffee);
			}
		}

		System.out.println("CoffeeMo List: " + coffeeNoList);
		int list = selectMenuDao.orderSelectMenu(coffeeNoList);
		return list;
	}
	*/

}
