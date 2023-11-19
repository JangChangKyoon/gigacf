package com.example.gigacf.v2.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.gigacf.v2.service.SelectMenuSvc;
import com.example.gigacf.v2.vo.Coffee_menu;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller("SelectMenuConV2")
@RequestMapping("/v2")
public class SelectMenuCon {

	@Autowired
	SelectMenuSvc selectMenuSvc;

	@RequestMapping("/selectmenu")
	public String doSelectMenu(Model model) {

		List<Coffee_menu> list = selectMenuSvc.doMenuList();
		log.info(list);
		model.addAttribute("list", list);

		return "/v2/selectMenu/selectMenu";
	}

	@PostMapping("/orderSelectedMenu")
	public ResponseEntity<Map<String, String>> receiveOrderList(@RequestBody List<Map<String, String>> orderList) {
		//log.info(orderList);
		
		try {
			// orderList를 받아 처리하는 로직을 여기에 작성합니다.

			log.info(orderList);
			// 클라이언트에게 반환할 JSON 데이터 생성
			Map<String, String> responseData = createResponseData(); // 이 함수는 클라이언트에게 반환할 JSON 데이터를 생성하는 함수입니다.

			
			int list = selectMenuSvc.orderSelectedMenu(orderList);
			// JSON 형식으로 데이터를 반환
			return ResponseEntity.ok(responseData);
		} catch (Exception e) {
			// 예외 발생 시 처리
			e.printStackTrace(); // 또는 원하는 예외 처리 방식을 적용하세요.
			return (ResponseEntity<Map<String, String>>) ResponseEntity.internalServerError();
		}
		
		
		
	}

	private Map<String, String> createResponseData() {
		// 클라이언트에게 반환할 JSON 데이터를 생성하는 로직을 작성하세요.
		// 예시: 더미 데이터를 생성하는 코드
		Map<String, String> responseData = Map.of("message", "Order received successfully");
		return responseData;
	}
}
