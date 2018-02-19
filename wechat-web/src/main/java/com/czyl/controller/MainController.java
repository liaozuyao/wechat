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

    @RequestMapping("/goSuccess")
    public String goSuccess(){
        return "success";
    }

    @RequestMapping("/goError")
    public String goError(){
        return "error";
    }


//    @RequestMapping("/allQuestionByAdmin")
//    public String allQuestionByAdmin(@RequestParam(value = "pn", defaultValue = "1") Integer pn,
//                                     Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
//        Admin admin = (Admin) request.getSession().getAttribute("admin");
//        if(admin != null){
//            PageHelper.startPage(pn, Constants.PAGESIZE);
//            List<Question> allQuestions = questionService.getAllQuestions();
//            PageInfo page = new PageInfo(allQuestions, Constants.PAGESIZE );
//            model.addAttribute("questionList", allQuestions);
//            model.addAttribute("pageInfo", page);
//            Integer count = questionService.countQuestion();
//            Integer pageNum = 0;
//            if(count % Constants.PAGESIZE == 0){
//                pageNum = count / Constants.PAGESIZE;
//            } else {
//                pageNum = count / Constants.PAGESIZE + 1;
//            }
//            model.addAttribute("pageNum", pageNum);
//            request.setAttribute("pageNum", pageNum);
//            return "admin/allQuestion";
//        } else {
////            response.sendRedirect("/WeChat/admin.html");
//            request.getRequestDispatcher("admin.html").forward(request, response);
//            return null;
//        }
//    }
}
