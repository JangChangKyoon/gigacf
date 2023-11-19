
<%@page import="com.example.gigacf.v2.menu.MenuVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.example.gigacf.v2.menu.MenuVo"%>
<%@page import="java.util.List"%>
<% List<MenuVo> menuList = (List<MenuVo>) request.getAttribute("menuList"); %>

<!DOCTYPE html>

<head>
<title>Coffee Menu</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>

<body>
	<div style="">
		<!-- 헤더 위치 -->
		<div id="header" style="flex: 1;"><%@include file="/WEB-INF/views/v2/comm/header.jsp"%></div>


		<div id="main" style="font-size: large; text-align: center; flex: 2">

			<div id="search" style="">
				<form name="fm_menu" autocomplete="on" action="/v2/menu/menu_search" method="post">
					<fieldset>
						<input style="width:50%" class="input is-primary" placeholder="메뉴명" type="text" id="coffee" name="coffee">
				
						<div class="select is-primary" > 
							<select style="height:40px;color: hsl(0, 0%, 80%);" id="kind" name="kind">
								<option  value="ALL">전체</option>
								<!-- All이란 string을 이용하여 sql문이 조건을 무시해야 되는 경우를 설정 -->
								<option value="커피">커피</option>
								<option value="논커피">논커피</option>
								<option value="에이드">에이드</option>
							</select>
						</div>

							<input style="width:10%;color: hsl(0, 0%, 80%);" class="input is-primary" type="date" id="start_date" name="start_date" min="2020-01-01"
							max="2023-12-31"
						> - <input style="width:10%;color: hsl(0, 0%, 80%);" class="input is-primary" type="date" id="end_date" name="end_date" min="2020-01-01" max="2023-12-31">
						 

						<!--Button of Registration-->
						<input  class="button is-primary is-inverted" type="submit" value="조 회"
							style="width: 80px;  font-weight: bold; font-size: medium; color: hsl(0, 0%, 80%);"
						>
					
						<button  class="button is-primary is-inverted" style="width:80px; font-weight: bold; font-size: medium;">
							<a style=" color: hsl(0, 0%, 80%);" href="/v2/menu/menu_ins">등 록</a>
						</button>
					
						<button  class="button is-primary is-inverted" type="button" id="IdUpdateAll" onclick="onModify()"
							style="width: 80px; font-weight: bold; font-size: medium"
						>
							<a style=" color: hsl(0, 0%, 80%);">가격수정</a>
						</button>
						<br>
						
					</fieldset>
				</form>
			</div>


			<form style="display:flex;" name="formTable" id="IdFormTable" method="post" action="/v2/menu/menu_updatePrices">
				<table style="width:100%" class="table">
					<thead>
						<tr  class="tr_td">
							<th style="text-align:center"><abbr  title="Position">Chk</abbr></th>
							<th style="text-align:center">커피No</th>
							<th style="text-align:center">메뉴명</th>
							<th style="text-align:center">종류</th>
							<th style="text-align:center">가격</th>
							<th style="text-align:center">등록일</th>
							<th style="text-align:center">수정일</th>
							<th style="text-align:center">수정</th>
							<th style="text-align:center">삭제</th>
						</tr>
					</thead>



					<tbody id="t_body">
						<!--Receiving Data-->
						<%
						for (MenuVo menu : menuList) {
						%>
						<tr>
							<td><input type="checkbox" name="chkNoList" value="<%=menu.getNo()%>" /></td>
							<td><%=menu.getNo()%></td>
							<td><%=menu.getCoffee()%></td>
							<td><%=menu.getKind()%></td>
							<td><%=menu.getPrice()%></td>
							<td><%=menu.getReg_day()%></td>
							<td><%=menu.getMod_day()%></td>
							<td><a href="/v2/menu/menu_up?no=<%=menu.getNo()%>">수정</a></td>
							<td><a href="/v2/menu/menu_del?no=<%=menu.getNo()%>">삭제</a></td>
						</tr>
						<%
						}
						%>
					</tbody>
				</table>
			<input type="hidden" name="price">
			<!--아래 script에서 onModify() 함수가 일시적으로 값을 저장하는 용도-->

			</form>

		</div>

	</div>



	<!--푸터위치-->
	<%@include file="/WEB-INF/views/v2/comm/footer.jsp"%>


</body>

<script>


	// 가격 수정하는 함수
	function onModify() {
		let _price = prompt("가격을 입력하시오");
		// input이 있는 알림창이 나오도록 함
		// 알림창에 적은 값이 _price 변수에 입력됨
		
		
		// 알림창의 input에 무엇을 입력하였는지에 따라서 아래 조건문이 처리됨. 
		if (_price == undefined) {
			return;
		} else if (_price == "") {
			alert("가격을 입력하세요");
			onModify();
			//} else if (!/^\d+$/.test(_price)) {
			// 정규 표현식을 사용하여 _price가 숫자로만 구성되었는지 확인
			//	alert("숫자만 입력하세요");
		} else if (_price != "") {
			console.log(_price);
			let _frm = document.formTable;
			console.log(_frm)
			if(!_frm){
				alert("폼이 선텍되지 않았습니다.");
			}
			_frm.price.value = _price;
			// value를 임시로 브라우저에 저장해놓고 활용하려는 용도
			_frm.submit();
			// "/v2/menu_updatePrice"의 url로 param을 통해서 위 임시저장된 값이 전달됨.
		}
	}
</script>





</html>