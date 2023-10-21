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
		<%@include file="/WEB-INF/views/v2/comm/header.jsp"%>

	<div id="main" style="font-size:large; alignment: center; padding: 10px 50px ">
		<p>
			오류 메세지 : <label th:text="${em}"></label>
		</p>

	</div>


	<!--푸터위치-->
		<%@include file="/WEB-INF/views/v2/comm/footer.jsp"%>

</body>

</html>