<%@page import="com.example.gigacf.v1.vo.Order_info"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% List<Order_info> list = (List<Order_info>) request.getAttribute("list"); %>

<html lang="ko" >

<head>
	<title>Coffee Order List</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" type="text/css" href="/css/comm.css">
	<link rel="stylesheet" type="text/css" href="/css/coffee.css">

</head>

<body>

	<!-- 헤더 위치 -->
	<%@include file="/WEB-INF/views/v1/comm/header.jsp"%>


	<div id="main" style="font-size:large; text-align: center; ">

		<div id="search"
			style="height: 150px;padding: 15px; font-size: small; width: 90%; margin-left: auto;  margin-right: auto;">
			<h3>[ Coffee Order List <span style="font-size:30px;">&#128722;</span> ]</h3>
			<form name="fm_order" autocomplete="on" action="/v1/order_search" method="post">
				<fieldset>
					<legend> [검색조건] </legend>
					<label>등록기간</label><input type="date" id="start_date" name="start_date" min="2020-01-01"
						max="2023-12-31">
					- <input type="date" id="end_date" name="end_date" min="2020-01-01" max="2023-12-31">
					&nbsp;&nbsp;
					<label>메뉴명</label> <input type="text" id="coffee" name="coffee">
					&nbsp;&nbsp;
					<label>고객명</label> <input type="text" id="name" name="name">
					</select>
					&nbsp;&nbsp;<input type="submit" value="조회"
						style="width: 80px;height: 30px;font-weight: bold; font-size: medium">

					<!-- <a href="javascript:loadDocArray()">test</a> -->
					<!--        <label>CheckBox : </label><span id="idCheckBox"></span>-->
				</fieldset>
			</form>


		</div>


		<table class="table">
			<thead>
				<tr class="tr_td">
					<th>Chk</th>
					<th>주문번호</th>
					<th>커피No</th>
					<th>메뉴명</th>
					<th>가격</th>
					<th>고객ID</th>
					<th>고객명</th>
					<th>주문일자</th>
				</tr>
			</thead>


			<tbody id="t_body">
				<!--- 데이타 출력 부분 -->
				
				<%for(Order_info order_info : list){ %>
				<tr >
					<td><input type="checkbox" name="chkOrderNo" value="<%=order_info.getNo()%>"</td>
					<td name="주문번호" ><%=order_info.getNo()%></td>
					<td name="커피No" ><%=order_info.getNo()%></td>
					<td name="메뉴명" ><%=order_info.getCoffee()%></td>
					<td name="가격" ><%=order_info.getPrice()%></td>
					<td name="고객ID" ><%=order_info.getCust_id()%></td>
					<td name="고객명" ><%=order_info.getName()%></td>
					<td name="주문일자" ><%=order_info.getReg_day()%></td>
				</tr>
				<% } %>

			</tbody>
		</table>
	</div>

	<!-- 푸터 위치 -->
		<%@include file="/WEB-INF/views/v1/comm/footer.jsp"%>


	<script>
		const now =new Date();
		const time7 = new Date(now.setDate(now.getDate()-100)); // now.getDate() : 30
		document.getElementById("start_date").value = time7.toISOString().slice(0,10);
		document.getElementById("end_date").value = new Date().toISOString().slice(0,10);
	</script>

	<!--    https://www.w3schools.com/html/html_emojis.asp   -->
	<h4>[Footer] <span style="font-size:30px;">&#9973;</span> Spring boot 항해 ~ with Me</h4>
	</div>

</body>

</html>