<%@page import="com.example.gigacf.v1.vo.Cust_info"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% List<Cust_info> list = (List<Cust_info>) request.getAttribute("list"); %>    
    
    
<html lang="ko">
<head>
    <title>Member List</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" type="text/css" href="/css/comm.css">
    <link rel="stylesheet" type="text/css" href="/css/coffee.css">

</head>
<body>

<!-- 헤더 위치 -->
	<%@include file="/WEB-INF/views/v1/comm/header.jsp"%>


<div id="main" style="font-size:large; text-align: center; ">

    <div id="search" style="height: 150px;padding: 15px; font-size: small; width: 90%; margin-left: auto;  margin-right: auto;">
        <h3>[ Member Info <span style="font-size:30px;">&#128699;</span> ]</h3>

        <form name="fm_member" autocomplete="on" method="post" action="/v1/member_search">
            <fieldset>
                <legend> [검색조건] </legend>
                <label>등록기간</label><input type="date" id="start_date" name="start_date" min="2020-01-01" max="2023-12-31">
                - <input type="date" id="end_date" name="end_date" min="2020-01-01" max="2023-12-31">
                &nbsp;&nbsp;
                <label>고객명</label> <input type="text" id="name" name="name">


                &nbsp;&nbsp;<input type="submit" value="조회"  style="width: 80px;height: 30px;font-weight: bold; font-size: medium">

            </fieldset>

        </form>


    </div>


    <table class="table">
        <thead>
        <tr class="tr_td">
            <th>Chk</th>
            <th>고객ID</th>
            <th>고객명</th>
            <th>이메일</th>
            <th>권한</th>
            <th>등록일</th>
        </tr>
        </thead>


        <tbody id="t_body">
        <!--- 데이타 출력 부분 -->
        <% for(Cust_info cust_info : list){ %>
        <tr >
            <td ><input type="checkbox" name="chkMemberNo" value="<%=cust_info.getNo()%>">Chk</td>
            <th name="고객ID"><%=cust_info.getNo()%></th>
            <td name="고객명"><%=cust_info.getName()%></td>
            <td name="이메일"><%=cust_info.getEmail()%></td>
            <td name="권한"><%=cust_info.getRole()%></td>
            <td name="등록일"><%=cust_info.getReg_day()%></td>
        </tr>
        <% } %>

        </tbody>
    </table>
</div>

<!-- 푸터 위치 -->
	<%@include file="/WEB-INF/views/v1/comm/footer.jsp"%>

<script>
	const now = new Date();
	const time7 = new Date(now.setDate(now.getDate()-100));
	document.getElementById("start_date").value = time7.toISOString().slice(0, 10);
	document.getElementById("end_date").value = new Date().toISOString().slice(0,10);
</script>

</body>



</html>
