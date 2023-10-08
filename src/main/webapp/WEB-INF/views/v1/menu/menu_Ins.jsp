<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html lang="ko" >

<head>
	<title>Coffee Menu</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<link rel="stylesheet" type="text/css" href="/css/comm.css">
	<link rel="stylesheet" type="text/css" href="/css/coffee.css">

</head>

<body>

	<!-- 헤더 위치 -->
	<%@include file="/WEB-INF/views/v1/comm/header.jsp" %>


	<div id="main" style="font-size:large; text-align: center; ">

		<div id="search"
			style="height: 300px;padding: 15px; font-size: small; width: 90%; margin-left: auto;  margin-right: auto;">
			<h3>[ Coffee menu 등록 <span style="font-size:30px;">&#9749;</span> ]
			</h3>
			<form name="fm_menu_ins" autocomplete="on" action="/v1/menu_ins" method="post">
				<fieldset>
					<legend> [커피 메뉴 등록] </legend>
					<!--Location of Input-->
					<label>메뉴명</label> <input type="text" id="coffee" name="coffee"/></p>
					<label>종 류 </label><select name="kind">
						<option value="커피">커피</option>
						<option value="논커피">논커피</option>
						<option value="에이드">에이드</option>
					</select>
					</p>
					&nbsp;&nbsp;
					<label>가 격 </label><input type="number" name="price"></p>

					<input type="submit" value="메뉴 등록"
						style="width: 100px;height: 30px;font-weight: bold; font-size: medium">
				</fieldset>
			</form>
		</div>
	</div>

	<!-- 푸터 위치 -->
	<%@include file="/WEB-INF/views/v1/comm/footer.jsp" %>

</body>

</html>