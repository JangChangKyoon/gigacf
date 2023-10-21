<%@page import="com.example.gigacf.v2.vo.Cust_info"%>
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
	<%@include file="/WEB-INF/views/v2/comm/header.jsp"%>


<div id="main" style="font-size:large; text-align: center; ">

    <div id="search" style="padding: 15px; font-size: small; width: 90%; margin-left: auto;  margin-right: auto;">
        

        <form name="fm_member" autocomplete="on" method="post" action="/v2/member_search">
            <fieldset>
                
              <input style="color: hsl(0, 0%, 80%);" class="button is-primary is-inverted" type="date" id="start_date" name="start_date" min="2020-01-01" max="2023-12-31">
                - <input style="color: hsl(0, 0%, 80%);" class="button is-primary is-inverted" type="date" id="end_date" name="end_date" min="2020-01-01" max="2023-12-31">
                &nbsp;&nbsp;
                <input type="text" id="name" name="name" placeholder="고객명" class="input is-primary" style="color: hsl(0, 0%, 80%);width: 15%;">


                &nbsp;&nbsp;<input class="button is-primary" type="submit" value="조회"  style="width: 80px;font-weight: bold; font-size: medium; color: white;">

            </fieldset>

        </form>


    </div>


    <table style="width:100%" class="table">
        <thead>
        <tr class="tr_td" >
            <th style="text-align:center"><abbr  title="Position">Chk</abbr></th>
            <th style="text-align:center">고객ID</th>
            <th style="text-align:center">고객명</th>
            <th style="text-align:center">연락처</th>
            <th style="text-align:center">권한</th>
            <th style="text-align:center">등록일</th>
        </tr>
        </thead>


        <tbody id="t_body">
        <!--- 데이타 출력 부분 -->
        <% for(Cust_info cust_info : list){ %>
        <tr >
            <td style="text-align:center"><input type="checkbox" name="chkMemberNo" value="<%=cust_info.getNo()%>"></td>
            <th style="text-align:center" name="고객ID"><%=cust_info.getNo()%></th>
            <td style="text-align:center" name="고객명"><%=cust_info.getName()%></td>
            <td style="text-align:center" name="연락처"><%=cust_info.getPhone()%></td>
            <td style="text-align:center" name="권한"><%=cust_info.getRole()%></td>
            <td style="text-align:center" name="등록일"><%=cust_info.getReg_day()%></td>
        </tr>
        <% } %>

        </tbody>
    </table>
</div>

<!-- 푸터 위치 -->
	<%@include file="/WEB-INF/views/v2/comm/footer.jsp"%>

<script>
	const now = new Date();
	const time7 = new Date(now.setDate(now.getDate()-100));
	document.getElementById("start_date").value = time7.toISOString().slice(0, 10);
	document.getElementById("end_date").value = new Date().toISOString().slice(0,10);
</script>

</body>



</html>
