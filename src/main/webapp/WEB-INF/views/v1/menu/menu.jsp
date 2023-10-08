
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.example.gigacf.v1.vo.Coffee_menu"%>
<%@page import="java.util.List"%>
<%
List<Coffee_menu> list = (List<Coffee_menu>) request.getAttribute("list");
%>


<!DOCTYPE html>

<head>
<title>Coffee Menu</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="/css/comm.css">
<link rel="stylesheet" type="text/css" href="/css/coffee.css">
</head>

<body>

	<!-- 헤더 위치 -->
	<%@include file="/WEB-INF/views/v1/comm/header.jsp"%>


	<div id="main" style="font-size: large; text-align: center;">

		<h3>
			[ Coffee menu Management <span style="font-size: 30px;">&#9749;</span>
			]
		</h3>
		<div id="search" style="">
			<form name="fm_menu" autocomplete="on" action="/v1/menu_search"
				method="post">
				<fieldset>

					<legend> [검색조건] </legend>
					<label>등록기간</label><input type="date" id="start_date"
						name="start_date" min="2020-01-01" max="2023-12-31"> - <input
						type="date" id="end_date" name="end_date" min="2020-01-01"
						max="2023-12-31"> &nbsp;&nbsp; <label>메뉴명</label> <input
						type="text" id="coffee" name="coffee"> &nbsp;&nbsp; <label>종류</label>
					<select id="kind" name="kind">
						<option value="ALL">전체</option>
						<!-- All이란 string을 이용하여 sql문이 조건을 무시해야 되는 경우를 설정 -->
						<option value="커피">커피</option>
						<option value="논커피">논커피</option>
						<option value="에이드">에이드</option>
					</select> &nbsp;&nbsp;<input type="submit" value="조회"
						style="width: 80px; height: 30px; font-weight: bold; font-size: medium">

					<!--Button of Registration-->
					&nbsp;&nbsp;
					<button
						style="width: 80px; height: 30px; font-weight: bold; font-size: medium">
						<a href="/v1/menu_ins">등록</a>
					</button>
					&nbsp;&nbsp;
					<button type="button" id="IdUpdateAll" onclick="onModify()"
						style="width: 80px; height: 30px; font-weight: bold; font-size: medium">
						<a>가격수정</a>
					</button>
				</fieldset>
			</form>
		</div>


		<form name="formTable" id="IdFormTable" method="post"
			action="/v1/menu_updatePrice">
			<table class="table">
				<thead>
					<tr class="tr_td">
						<th>Chk</th>
						<th>커피No</th>
						<th>메뉴명</th>
						<th>종류</th>
						<th>가격</th>
						<th>등록일</th>
						<th>수정일</th>
						<th>수정</th>
						<th>삭제</th>
					</tr>
				</thead>



				<tbody id="t_body">
					<!--Receiving Data-->
					<%for (Coffee_menu coffeeMenu : list) {%>
					<tr >
						<td><input type="checkbox" name="chkCoffeeNo"
							value="<%=coffeeMenu.getNo()%>" /></td>
						<td ><%=coffeeMenu.getNo()%></td>
						<td><%=coffeeMenu.getCoffee()%></td>
						<td><%=coffeeMenu.getKind()%></td>
						<td><%=coffeeMenu.getPrice()%></td>
						<td><%=coffeeMenu.getReg_day()%></td>
						<td><%=coffeeMenu.getMod_day()%></td>
						<td><a href="/v1/menu_up?no=<%=coffeeMenu.getNo()%>">수정</a></td>
						<td><a href="/v1/menu_del?no=<%=coffeeMenu.getNo()%>" >삭제</a></td>
					</tr>
					<% } %>
				</tbody>
			</table>

			<input type="hidden" name="hidden_price">
			<!--아래 script에서 onModify() 함수가 일시적으로 값을 저장하는 용도-->
		</form>
	</div>





	<!--푸터위치-->
	<%@include file="/WEB-INF/views/v1/comm/footer.jsp"%>


	<script>
		const now = new Date();
		const time7 = new Date(now.setDate(now.getDate() - 100));
		document.getElementById("start_date").value = time7.toISOString()
				.slice(0, 9);
		// ISO 8601 format string : YYYY-MM-DDTHH:mm:ss.sssZ
		document.getElementById("end_date").value = new Date().toISOString()
				.slice(0, 9);

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
				let _frm = document.formTable;
				_frm.hidden_price.value = _price;
				// value를 임시로 브라우저에 저장해놓고 활용하려는 용도
				_frm.submit();
				// "/v1/menu_updatePrice"의 url로 param을 통해서 위 임시저장된 값이 전달됨.
			}
		}
	</script>

</body>



</html>