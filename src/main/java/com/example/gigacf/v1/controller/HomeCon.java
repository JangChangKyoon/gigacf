package com.example.gigacf.v1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/v1")
public class HomeCon {

    @GetMapping("/home")
    public String doHome(){

        return "/v1/home/home";
    }

    @GetMapping("/rest2")
    @ResponseBody
    public String doRest2(){

        String strHtml="<html><body> Hi Rest , Controller + ResponseBody !!! <hr> Hi. </body></html>";

        return strHtml;

    }

}
