
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<link href="/css/bootstrap.min.css" rel="stylesheet">
<meta charset="UTF-8">
<title>Registration</title>
</head>
<body>
	<!-- 헤더 위치 -->
	<%@include file="/WEB-INF/views/v2/comm/header.jsp"%>

	<nav aria-label="breadcrumb">
		<ol class="breadcrumb">
			<li class="breadcrumb-item active" aria-current="page">회원가입</li>
			<li class="breadcrumb-item active" aria-current="page">step1</li>
		</ol>
	</nav>

	<div class="accordion" id="accordionExample">
		<div class="card">
			<div class="card-header" id="headingOne">
				<h2 class="mb-0 form-text text-muted">약관</h2>
			</div>
			<div aria-labelledby="headingOne" data-parent="#accordionExample">
				<div class="card-body">Some placeholder content for the first accordion panel. This panel
					is shown by default, thanks to the ㅁㄴㅇㄻ나어ㅘㅓ노아러ㅗㅁ나어뢈너오라ㅓㅁ도아ㅓㅗㄹ마넝롸먼돌아ㅓㅘclass.</div>
			</div>
		</div>
	</div>

	<div style="margin: 30px">
		<form role="form" action="step2">
			<div class="form-group">
				<label class="checkbox-inline"> <input type="checkbox" name="agree" value="true">동의합니다.
				</label>
			</div>
			<button type="submit" class="btn btn-outline-success">다음 단계</button>
		</form>
	</div>
	
</body>
</html>