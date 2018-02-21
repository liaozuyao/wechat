package com.czyl.controller;

import com.czyl.service.CompanyService;
import com.czyl.utils.ViewData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

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

    @RequestMapping(value = "updateAccInfo.html")
    public String updateAccInfo(){
        return "updateCompanyContact";
    }

    @RequestMapping(value = "updateAccPasswd.html")
    public String updateAccPasswd(){
        return "updateAccPassword";
    }

    @RequestMapping(value = "adviserOrDevlpLogin.html")
    public String advDevLogin(){
        return "/admin/advDevLogin";
    }

}
