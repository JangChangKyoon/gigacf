<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html lang="ko" >

<head>
	<title>Coffee Menu</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">


</head>

<body>

	<!-- 헤더 위치 -->
	<%@include file="/WEB-INF/views/v1/comm/header.jsp" %>


	<div id="main" style="font-size:large; text-align: center; ">

		<div id="search"
			style="height: 300px;padding: 15px; font-size: small; width: 90%; margin-left: auto;  margin-right: auto;">
			
			</h3>
			<form name="fm_menu_ins" autocomplete="on" action="/v1/menu_ins" method="post">
				<fieldset style="display:flex; flex-direction:column; align-items:center;gap:10px;">
				
					<!--Location of Input-->
					<input class="input is-primary" style="color: hsl(0, 0%, 80%);width:15%;" type="text" id="coffee" name="coffee" placeholder="메뉴명"/>
					
				<div class="select is-primary;" style="margin-bottom:5px;width:15%;">	<select style="height:40px;color: hsl(0, 0%, 80%);font-size:15px; " name="kind">
						<option value="커피">커피</option>
						<option value="논커피">논커피</option>
						<option value="에이드">에이드</option>
					</select></div>
				
					
					<input style="color: hsl(0, 0%, 80%);width:15%;" class="input is-primary" type="number" name="price" placeholder="가격">

					<input class="button is-primary" type="submit" value="메뉴 등록"
						style="width: 80px;font-weight: bold; font-size: medium; color: white;">
				</fieldset>
			</form>
		</div>
	</div>

	<!-- 푸터 위치 -->
	<%@include file="/WEB-INF/views/v1/comm/footer.jsp" %>

</body>

</html>