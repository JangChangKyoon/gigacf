<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <title>Coffee _ Home</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.4/css/bulma.min.css" />

</head>
<body>

<!-- 헤더 위치 -->
<%@include file="/WEB-INF/views/v1/comm/header.jsp"%>


	<div id="main" style="font-size: large; alignment: center; padding: 10px 50px; display: flex;">

		<div style="flex:1">
			<h2 class="subtitle is-2">커피 주문 및 관리웹</h2>

			<hr>
			<ul style="list-style-type: square;">
				<li>Java 버전 : 1.8</li>
				<li>DBMS : MaridDB</li>
				<li>Mapper : 마이바티스</li>
				<li>View : JSP, Vanilla</li>
				<li>CSS : BULMA</li>
			</ul>
			
			<h5 style="margin-top:20px" class="subtitle is-3"><a  href="selectmenu">주문판 바로가기</a></h5>
			<a style="width:100%" href="selectmenu" ><img src="https://afar.brightspotcdn.com/dims4/default/7604c95/2147483647/strip/true/crop/3352x2472+0+0/resize/1440x1062!/quality/90/?url=https%3A%2F%2Fafar-media-production-web.s3.us-west-2.amazonaws.com%2Fbrightspot%2F1c%2Fe5%2F61ebf7126f34371d599273331f41%2Foriginal-australian-20coffee.jpg"> </a>
		</div>

<div  style="flex:2"><img   src="https://farm4.static.flickr.com/3214/2325663412_3150abe8e1.jpg" style="width: 100%">
</div>
		
	</div>


	<!-- 푸터 위치 -->
<%@include file="/WEB-INF/views/v1/comm/footer.jsp"%>

</body>
</html>



