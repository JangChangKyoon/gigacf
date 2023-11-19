package com.example.gigacf.v2.order.adminOrder;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.gigacf.v2.order.OrderVo;


@Controller
@RequestMapping("/v2/adminOrder")
public class AdminOrderController {

	private final AdminOrderService orderService;
	
	@Autowired
	public AdminOrderController(AdminOrderService  orderService) {
		this.orderService = orderService;
	}
	
	@GetMapping("/order_list")
	public ModelAndView showOrderList() {
		ModelAndView mv = new ModelAndView("/v2/order/admin/order_list");
		List<OrderVo> orderList = orderService.selectList();
		mv.addObject("orderList", orderList);
		return mv;
	}
	
	@PostMapping("/order_search")
	public ModelAndView searchOrder(OrderVo orderVo) {
		ModelAndView mv = new ModelAndView("/v2/order/admin/order_list");
		List<OrderVo> orderList = orderService.searchList(orderVo);
		mv.addObject("orderList", orderList);
		return mv;
	}


	/*
	 * @RequestMapping("/order_search") public String
	 * doSearch(@RequestParam("start_date") String
	 * strStart_date, @RequestParam("end_date") String strEnd_date,
	 * 
	 * @RequestParam(value="coffee", defaultValue = "ALL") String
	 * strCoffee, @RequestParam("name") String strName, Model model) {
	 * List<Order_info> list = orderSvc.doSearch(strStart_date, strEnd_date,
	 * strCoffee, strName); model.addAttribute("list", list); return
	 * "/v2/order/order"; }
	 */

}
