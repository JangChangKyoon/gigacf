<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="/css/bootstrap.min.css" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
	<%@include file="/WEB-INF/views/v2/comm/header.jsp"%>
<div class="panel-body" style="display:flex; justify-content:center;align-items:center;width:100%;height:90%">
   <form:form role="form" modelAttribute="loginVo" action="/v2/user/login/loginForm" method="post" style="width:50%; height:50%">
      
            <div class="form-group">
                <form:input type="text" class="form-control" placeholder="Phone" path="phone"/>
                <form:errors path="phone"/>
            </div>
            <div class="form-group">
                 <form:password class="form-control" placeholder="Password" path="password"/>
                  <form:errors path="password"/>
            </div>
            <div class="checkbox">
                <label>
                    <form:checkbox path="rememberPhone"/>아이디 기억
                </label>
            </div>
                <button type="submit" class="btn btn-lg btn-success btn-block">로그인</button>
      
    </form:form>
</div>

</body>
</html>