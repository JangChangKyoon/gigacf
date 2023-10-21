<%@page import="com.example.gigacf.v2.vo.Order_info"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% List<Order_info> list = (List<Order_info>) request.getAttribute("list"); %>

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
			
			<form name="fm_order" autocomplete="on" action="/v2/order_search" method="post">
				<fieldset>
					
					<input class="button is-primary is-inverted" type="date" id="start_date" name="start_date" min="2020-01-01"
						max="2023-12-31" style=" color: hsl(0, 0%, 80%);">
					- <input class="button is-primary is-inverted" type="date" id="end_date" name="end_date" min="2020-01-01" max="2023-12-31" style=" color: hsl(0, 0%, 80%);">
					&nbsp;&nbsp;
					<input  class="input is-primary" type="text" id="coffee" name="coffee" placeholder="메뉴명" style="color: hsl(0, 0%, 80%);width:15%;">
					&nbsp;&nbsp;
					 <input class="input is-primary" type="text" id="name" name="name" placeholder="고객명" style="color: hsl(0, 0%, 80%);width:15%;">
			
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
				
				<%for(Order_info order_info : list){ %>
				<tr >
					<td style="text-align:center"><input type="checkbox" name="chkOrderNo" value="<%=order_info.getNo()%>"></td>
					<td style="text-align:center" name="주문번호" ><%=order_info.getNo()%></td>
					<td style="text-align:center" name="커피No" ><%=order_info.getNo()%></td>
					<td style="text-align:center" name="메뉴명" ><%=order_info.getCoffee_name()%></td>
					<td style="text-align:center" name="가격" ><%=order_info.getCoffee_price()%></td>
					<td style="text-align:center" name="고객ID" ><%=order_info.getCust_id()%></td>
					<td style="text-align:center" name="고객명" ><%=order_info.getCust_name()%></td>
					<td style="text-align:center" name="주문일자" ><%=order_info.getReg_day()%></td>
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

	<!--    https://www.w3schools.com/html/html_emojis.asp   -->
	<h4>[Footer] <span style="font-size:30px;">&#9973;</span> Spring boot 항해 ~ with Me</h4>
	</div>

</body>

</html>