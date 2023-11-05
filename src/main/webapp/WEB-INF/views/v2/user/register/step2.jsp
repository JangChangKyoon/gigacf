<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="/css/bootstrap.min.css" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
	<!-- 헤더 위치 -->
	<%@include file="/WEB-INF/views/v2/comm/header.jsp"%>

	<nav aria-label="breadcrumb">
		<ol class="breadcrumb">
			<li class="breadcrumb-item active" aria-current="page">회원가입</li>
			<li class="breadcrumb-item"><a href="/v2/user/register/step1">step1</a></li>
			<li class="breadcrumb-item active" aria-current="page">step2</li>
		</ol>
	</nav>

	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-6">
				<form:form role="form" modelAttribute="registerVo" action="/v2/user/register/step3"
					id="step3Form" method="post"
				>
					<div class="form-group input-group">
						<span class="input-group-addon"></span>
						<form:input type="text" path="phone" class="form-control" placeholder="Phone" />
						<form:errors path="phone" class="form-text text-muted" />
					</div>
					<div class="form-group input-group">
						<span class="input-group-addon"></span>
						<form:input type="text" class="form-control" placeholder="Email" path="email" />
						<form:errors path="email" class="form-text text-muted" />
					</div>
					<div class="form-group input-group">
						<span class="input-group-addon"></span>
						<form:input type="text" class="form-control" placeholder="Name" path="name" />
						<form:errors path="name" class="form-text text-muted" />
					</div>
					<div class="form-group input-group">
						<span class="input-group-addon"></span>
						<form:input class="form-control" placeholder="Password" path="password" />
						<form:errors path="password" class="form-text text-muted" />
					</div>
					<div class="form-group input-group">
						<span class="input-group-addon"></span>
						<form:input class="form-control" placeholder="Password Check" path="passwordConfirm" />
						<form:errors path="passwordConfirm" class="form-text text-muted" />
					</div>
					<button type="submit" class="btn btn-outline-success">가입하기</button>
					<button type="reset" class="btn btn-outline-success">취소하기</button>
				</form:form>
			</div>
		</div>
	</div>
	<!-- 푸터 위치 -->
	<%@include file="/WEB-INF/views/v2/comm/footer.jsp"%>
</body>
<script>
	
</script>
</html>