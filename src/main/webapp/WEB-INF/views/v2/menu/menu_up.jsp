<%@page import="com.example.gigacf.v2.menu.MenuVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="ko">
<head>
<title>Coffee Menu</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" type="text/css" href="/css/comm.css">
<link rel="stylesheet" type="text/css" href="/css/coffee.css">

</head>
<body>

	<!-- 헤더 위치 -->
	<%@include file="/WEB-INF/views/v2/comm/header.jsp"%>


	<div id="main" style="font-size: large; text-align: center;">

		<div id="search"
			style="height: 300px; padding: 15px; font-size: small; width: 90%; margin-left: auto; margin-right: auto;"
		>
			<h3>
				[ Coffee menu 수정 <span style="font-size: 30px;">&#9749;</span> ]
			</h3>

			<%
			MenuVo menu = (MenuVo) request.getAttribute("menu");
			// 이제 'menu' 변수를 사용할 수 있습니다
			%>
			<form name="fm_menu_ins" autocomplete="on" action="/v2/menu/menu_up" method="post">
				<fieldset>

					<legend> [커피 메뉴 등록] </legend>
					<label>메뉴명</label> <input type="text" id="name" name="coffee" value="${menu.getCoffee()}">
					<label>종 류 </label><select name="kind">
						<!--일종의 조건문으로 selected된 value에 따라서 콤보박스가 선택될 수 있도록 함.-->
						<option value="커피" ${menu.getKind().equals("커피") ? "selected" : ""}>커피</option>
						<option value="논커피" ${menu.getKind().equals("논커피") ? "selected" : ""}>논커피</option>
						<option value="에이드" ${menu.getKind().equals("에이드") ? "selected" : ""}>에이드</option>
					</select>
					&nbsp;&nbsp; <label>가 격 </label><input type="number" name="price" value="${menu.getPrice()}">
					<input type="hidden" name="no" value="${menu.getNo()}">
					<!--name은 controller param으로 전달되는 키임-->

					<input type="submit" value="메뉴 수정"
						style="width: 100px; height: 30px; font-weight: bold; font-size: medium"
					>
				</fieldset>
			</form>


		</div>

	</div>

	<!-- 푸터 위치 -->
	<%@include file="/WEB-INF/views/v2/comm/footer.jsp"%>

</body>
</html>