<%@page import="com.example.gigacf.v2.order.OrderVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% List<OrderVo> orderList = (List<OrderVo>) request.getAttribute("orderList"); %>

<html lang="ko" >

<head>
	<title>Coffee Order List</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">

</head>

<body>

	<!-- 헤더 위치 -->
	<%@include file="/WEB-INF/views/v2/comm/header.jsp"%>


	<div id="main" style="font-size:large; text-align: center; ">

		<div id="search"
			style=" font-size: small; width: 90%; margin-left: auto;  margin-right: auto;">
			
			<form name="fm_order" autocomplete="on" action="/v2/adminOrder/order_search" method="post">
				<fieldset>
					
					<input class="button is-primary is-inverted" type="date" id="start_date" name="start_date" min="2020-01-01"
						max="2023-12-31" style=" color: hsl(0, 0%, 80%);">
					- <input class="button is-primary is-inverted" type="date" id="end_date" name="end_date" min="2020-01-01" max="2023-12-31" style=" color: hsl(0, 0%, 80%);">
					&nbsp;&nbsp;
					<input  class="input is-primary" type="text" id="coffee_nam" name="coffee_name" placeholder="메뉴명" style="color: hsl(0, 0%, 80%);width:15%;">
					&nbsp;&nbsp;
					 <input class="input is-primary" type="text" id="cust_name" name="cust_name" placeholder="고객명" style="color: hsl(0, 0%, 80%);width:15%;">
			
					&nbsp;&nbsp;<input class="button is-primary" type="submit" value="조회"
						style="width: 80px;font-weight: bold; font-size: medium; color: white;">

					<!-- <a href="javascript:loadDocArray()">test</a> -->
					<!--        <label>CheckBox : </label><span id="idCheckBox"></span>-->
				</fieldset>
			</form>


		</div>


		<table style="width:100%" class="table">
			<thead>
				<tr class="tr_td">
					<th style="text-align:center">Chk</th>
					<th style="text-align:center">주문번호</th>
					<th style="text-align:center">커피No</th>
					<th style="text-align:center">메뉴명</th>
					<th style="text-align:center">가격</th>
					<th style="text-align:center">고객ID</th>
					<th style="text-align:center">고객명</th>
					<th style="text-align:center">주문일자</th>
				</tr>
			</thead>


			<tbody id="t_body">
				<!--- 데이타 출력 부분 -->
				
				<%for(OrderVo order : orderList){ %>
				<tr >
					<td style="text-align:center"><input type="checkbox" name="chkOrderNo" value="<%=order.getNo()%>"></td>
					<td style="text-align:center" name="주문번호" ><%=order.getNo()%></td>
					<td style="text-align:center" name="커피No" ><%=order.getCoffee_no()%></td>
					<td style="text-align:center" name="메뉴명" ><%=order.getCoffee_name()%></td>
					<td style="text-align:center" name="가격" ><%=order.getCoffee_price()%></td>
					<td style="text-align:center" name="고객ID" ><%=order.getCust_id()%></td>
					<td style="text-align:center" name="고객명" ><%=order.getCust_name()%></td>
					<td style="text-align:center" name="주문일자" ><%=order.getReg_day()%></td>
				</tr>
				<% } %>

			</tbody>
		</table>
	</div>

	<!-- 푸터 위치 -->
	<%@include file="/WEB-INF/views/v2/comm/footer.jsp"%>


	<script>
		const now =new Date();
		const time7 = new Date(now.setDate(now.getDate()-100)); // now.getDate() : 30
		document.getElementById("start_date").value = time7.toISOString().slice(0,10);
		document.getElementById("end_date").value = new Date().toISOString().slice(0,10);
	</script>

	
	

</body>

</html>