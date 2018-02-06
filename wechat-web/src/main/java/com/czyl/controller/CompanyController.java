package com.czyl.controller;

import com.czyl.common.StatusConstants;
import com.czyl.entity.Company;
import com.czyl.service.CompanyService;
import com.czyl.utils.ViewData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Created by liaozuyao on 2018/1/3.
 */
@Controller
public class CompanyController extends BaseController{

    @Resource
    private CompanyService companyService;

    @RequestMapping(value = "/insertCompany", method = RequestMethod.POST)
    @ResponseBody
    public ViewData insertCompany(@RequestBody Company company){
        Integer i = companyService.insertCompany(company);
        if(i == 1){
            return buildSuccessCodeJson(StatusConstants.SUCCESS_CODE,"成功");
        } else {
            return buildFailureJson(StatusConstants.ERROR_CODE,"失败");
        }
    }

    @RequestMapping(value = "/updateCompany", method = RequestMethod.POST)
    @ResponseBody
    public ViewData updateCompany(@RequestBody Company company){
        Integer i = companyService.updateCompany(company);
        if(i == 1){
            return buildSuccessCodeJson(StatusConstants.SUCCESS_CODE,"成功");
        } else {
            return buildFailureJson(StatusConstants.ERROR_CODE,"失败");
        }
    }

    @RequestMapping(value = "/selectCompanys")
    @ResponseBody
    public ViewData selectCompanys(){
        return buildSuccessJson(StatusConstants.SUCCESS_CODE,"成功", companyService.selectCompany());
    }

    @RequestMapping(value = "/selectCompanyById")
    @ResponseBody
    public ViewData selectCompanyById(@RequestParam("id") Long id){
        return buildSuccessJson(StatusConstants.SUCCESS_CODE,"成功", companyService.selectCompanyById(id));
    }
}
