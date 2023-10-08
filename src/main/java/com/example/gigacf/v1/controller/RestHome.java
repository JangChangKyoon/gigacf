package com.example.gigacf.v1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // RestController 설정하는 방법
public class RestHome {

    @GetMapping("v1/rest") // url 설정 
    public String doRest(){

 
//response할 데이터의 종류와 내용 
        String strHtml="<html>\n" +
                "<head>\n" +
                " <meta charset=\"UTF-8\">\n" +
                " <title>회사 직원 리스트</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h1> ■ 회사 직원 리스트 </h1>\n" +
                "<h1>  HTML -> Servlet  </h1>\n" +
                "<a href='/'>● Home </a>\n" +
                "<p>\n" +
                "<table style='width: 400px;'>\n"+
                "<tr style='height: 40px'>\n"+
                "<th>No</th>\n"+
                "<th align='center'>이름</th>\n"+
                "<th align='center'>나이</th>\n"+
                "<th align='center'>등록일자</th>\n"+
                "</tr>\n";

        
        return strHtml; // 데이터 내보니기

    }

}
