package com.czyl.controller;

import com.czyl.common.Constants;
import com.czyl.common.StatusConstants;
import com.czyl.entity.Admin;
import com.czyl.entity.Company;
import com.czyl.service.CompanyService;
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

/**
 * Created by liaozuyao on 2018/1/3.
 */
@Controller
public class CompanyController extends BaseController{

    @Resource
    private CompanyService companyService;

    @RequestMapping(value = "/CompanyChangeStatusByAdmin", method = RequestMethod.POST)
    @ResponseBody
    public ViewData deleteCompanyByAdmin(@RequestParam("id") Long id, @RequestParam("isDel") Integer isDel,
                                         HttpServletRequest request){
        Admin admin = (Admin) request.getSession().getAttribute("admin");
        if(admin != null){
            Integer status = companyService.deleteCompany(id,isDel);
            if(status == 1){
                return buildSuccessCodeJson(StatusConstants.SUCCESS_CODE,"成功");
            }
        }
        return buildFailureJson(StatusConstants.ERROR_CODE,"失败");
    }

    @RequestMapping("/getAllCompanyByAdmin")
    public String getAll(@RequestParam(value = "pn", defaultValue = "1")Integer pn, Model model,
                         HttpServletRequest request, HttpServletResponse response) throws Exception{
        Admin admin = (Admin) request.getSession().getAttribute("admin");
        if(admin != null){
            PageHelper.startPage(pn, Constants.PAGESIZE);
            List<Company> allCompany = companyService.getAllCompany();
            PageInfo page = new PageInfo(allCompany, Constants.PAGESIZE);
            model.addAttribute("allCompany", allCompany);
            model.addAttribute("pageInfo", page);
            Integer count = companyService.countCompany();
            Integer pageNum = 0;
            if(count % Constants.PAGESIZE == 0){
                pageNum = count / Constants.PAGESIZE;
            } else {
                pageNum = count / Constants.PAGESIZE + 1;
            }
            model.addAttribute("pageNum", pageNum);
            request.setAttribute("pageNum", pageNum);
            return "admin/allCompany";
        }
        request.getRequestDispatcher("admin.html").forward(request, response);
        return null;
    }

    @RequestMapping(value = "/getAllCompany",method = RequestMethod.GET)
    @ResponseBody
    public ViewData getAllCompany(){
        return buildSuccessJson(200,"成功", companyService.getAllCompany());
    }

    @RequestMapping(value = "/getAllNotDel", method = RequestMethod.GET)
    @ResponseBody
    public ViewData getAllNotDel(){
        return buildSuccessJson(StatusConstants.SUCCESS_CODE,"成功", companyService.getAllNotDel());
    }

    @RequestMapping(value = "/changeCompanyName")
    @ResponseBody
    public ViewData changeCompanyName(@RequestParam("companyName") String companyName, @RequestParam("id") Long id,
                                      HttpServletRequest request, HttpServletResponse response) throws Exception{
        Admin admin = (Admin) request.getSession().getAttribute("admin");
        if(admin != null){
            Integer integer = companyService.changeCompanyName(companyName, id);
            if(integer == 1){
                return buildSuccessCodeJson(StatusConstants.SUCCESS_CODE,"成功");
            }
            return buildFailureJson(StatusConstants.ERROR_CODE,"失败");
        }
        request.getRequestDispatcher("admin.html").forward(request, response);
        return null;
    }

    @RequestMapping(value = "/insertCompany", method = RequestMethod.GET)
    @ResponseBody
    public ViewData insertCompany(@RequestParam("name") String name, HttpServletRequest request,
                                  HttpServletResponse response) throws Exception{
        Admin admin = (Admin) request.getSession().getAttribute("admin");
        if(admin != null) {
            Integer state = companyService.insertCompany(name);
            if (state == 1) {
                return buildSuccessCodeJson(StatusConstants.SUCCESS_CODE, "成功");
            }
            return buildFailureJson(StatusConstants.ERROR_CODE, "失败");
        }
//        response.sendRedirect("admin.html");
        request.getRequestDispatcher("admin.html").forward(request, response);
        return null;
    }

    @RequestMapping("/addCompanyByAdmin")
    public String add(HttpServletRequest request, HttpServletResponse response) throws Exception{
        Admin admin = (Admin) request.getSession().getAttribute("admin");
        if(admin != null){
            return "admin/addCompany";
        }
        request.getRequestDispatcher("admin.html").forward(request, response);
//        response.sendRedirect("admin.html");
        return null;
    }
}
