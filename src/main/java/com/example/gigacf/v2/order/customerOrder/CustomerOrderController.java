package com.example.gigacf.v2.order.customerOrder;

import java.text.Normalizer.Form;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.gigacf.v2.menu.MenuVo;
import com.example.gigacf.v2.order.OrderVo;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
@RequestMapping("/v2/customerOrder")
public class CustomerOrderController {

	private final CustomerOrderService customerOrderService;

	public CustomerOrderController(CustomerOrderService customerOrderService) {
		this.customerOrderService = customerOrderService;
	}

	/* 메뉴를 선택할 수 있는 화면 */
	@GetMapping("/menu_List")
	public ModelAndView showMenuList() {
		ModelAndView mv = new ModelAndView("/v2/order/customer/order_menu");
		List<MenuVo> orderList = customerOrderService.selectList();
		mv.addObject("orderList", orderList);
		return mv;
	}


	/** Form_List를 @RequestBody로 가져오기 
	 * 
	 * request payload 형식
	 * [{"coffee":"2","number":"1","price":"111"},{"coffee":"5","number":"2","price":"1111"},{"coffee":"21","number":"3","price":"123412"}]
	 * 
	 * */
	@PostMapping("order_menu")
	public ResponseEntity<Map<String, String>> sendOrder(@RequestBody List<Map<String, String>> orderList){
		try {
			customerOrderService.createList(orderList);
			Map<String, String> responseDataMap = createResponseMessage("SuccessFully received");
			return ResponseEntity.ok(responseDataMap); 
		} catch (Exception e) { // 예외 발생 시 처리
			  e.printStackTrace(); // 또는 원하는 예외 처리 방식을 적용하세요. 
			  return (ResponseEntity<Map<String, String>>) ResponseEntity.internalServerError();
		}
	}
	
	private Map<String, String> createResponseMessage(String message){
		Map<String, String> responseMessage = Map.of("message", message);
		return responseMessage;
	}

	/*
	@PostMapping("/orderSelectedMenu") 
	public ResponseEntity<Map<String, String>> receiveOrderList(@RequestBody List<Map<String, String>> orderList) {
	  //log.info(orderList);
	  try { // orderList를 받아 처리하는 로직을 여기에 작성합니다.
		  log.info(orderList); // 클라이언트에게 반환할 JSON 데이터 생성 
		  Map<String, String> responseData = createResponseData(); // 이 함수는 클라이언트에게 반환할 JSON 데이터를 생성하는 함수
		  int list = selectMenuSvc.orderSelectedMenu(orderList); // JSON 형식으로 데이터를 반환
	      return ResponseEntity.ok(responseData); } 
	  catch (Exception e) { // 예외 발생 시 처리
		  e.printStackTrace(); // 또는 원하는 예외 처리 방식을 적용하세요. return
		  (ResponseEntity<Map<String, String>>) ResponseEntity.internalServerError(); }
	  }

	private Map<String, String> createResponseData() { 
		// 클라이언트에게 반환할 JSON 데이터를 생성하는 로직을 작성하세요. 
		// 예시: 더미 데이터를 생성하는 코드 
		Map<String, String> responseData = Map.of("message", "Order received successfully"); 
		return responseData; }
	*/
}
