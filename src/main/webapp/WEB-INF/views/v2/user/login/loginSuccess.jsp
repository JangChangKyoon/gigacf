<%@page import="com.example.gigacf.v2.user.login.LoginSessionVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
String email = (String) request.getAttribute("email");
%>
<!DOCTYPE html>
<html>
<head>
<link href="/css/bootstrap.min.css" rel="stylesheet">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 헤더 위치 -->
	<%@include file="/WEB-INF/views/v2/comm/header.jsp"%>
    <div class="alert alert-success">
        로그인에 성공하였습니다.
      	<p>email: <%= email %></p>
    </div>
    
</body>
</html>