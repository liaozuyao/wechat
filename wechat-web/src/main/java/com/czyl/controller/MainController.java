package com.czyl.controller;

import com.czyl.common.Constants;
import com.czyl.common.StatusConstants;
import com.czyl.entity.Admin;
import com.czyl.entity.Question;
import com.czyl.service.AdminService;
import com.czyl.service.QuestionService;
import com.czyl.utils.ViewData;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class MainController extends BaseController{

    @Resource
    AdminService adminService;

    @RequestMapping("/index.html")
    public String mainPage(){
        return "index";
    }

    @RequestMapping("/about.html")
    public String aboutPage(){
        return "about";
    }

    @RequestMapping("/admin.html")
    public String adminLogin(){
        return "adminLogin";
    }

    @RequestMapping(value = "/loginAdmin", method = RequestMethod.POST)
    @ResponseBody
    public ViewData login(@RequestParam String userName, @RequestParam String password,
                          HttpServletRequest request){
        Admin admin = adminService.select(userName, password);
        if(admin != null){
            request.getSession().setAttribute("admin", admin);
            return buildSuccessCodeViewData(StatusConstants.SUCCESS_CODE, "成功");
        } else {
            return buildFailureJson(StatusConstants.ERROR_CODE, "错误");
        }
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
