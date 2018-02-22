package com.czyl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController extends BaseController{

    @RequestMapping("/index.html")
    public String ordinaryLoginPage(){
        return "login";
    }

    @RequestMapping(value = "/adminMain.html")
    public String adminLogin(){
        return "/admin/adminMain";
    }

    @RequestMapping(value = "/customerLogin.html")
    public String clientLogin(){
        return "clientLogin";
    }

    @RequestMapping(value = "customerMain.html")
    public String clientMain(){
        return "clientMain";
    }

    @RequestMapping(value = "updateAccPasswd.html")
    public String updateAccPasswd(){
        return "updateAccPassword";
    }

}
