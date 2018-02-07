package com.czyl.controller;

import com.czyl.common.StatusConstants;
import com.czyl.entity.Company;
import com.czyl.entity.CompanyModel;
import com.czyl.service.CompanyInfoService;
import com.czyl.service.CompanyModelBeanService;
import com.czyl.service.CompanyModelService;
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

    @Resource
    CompanyModelBeanService companyModelBeanService;

    @Resource
    CompanyModelService companyModelService;

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
        return buildSuccessJson(StatusConstants.SUCCESS_CODE,"成功", companyModelBeanService.selectAllCompany());
    }

    @RequestMapping(value = "/selectCompanyById")
    @ResponseBody
    public ViewData selectCompanyById(@RequestParam("id") Long id){
        return buildSuccessJson(StatusConstants.SUCCESS_CODE,"成功", companyModelBeanService.selectByCompanyId(id));
    }

    @RequestMapping(value = "/insertCompanyModel", method = RequestMethod.POST)
    @ResponseBody
    public ViewData insertCompanyModel(@RequestParam("companyId")Long companyId, @RequestParam("serviceId")Long serviceId,
                                       @RequestParam("enclosure")String enslosure){
        CompanyModel companyModel = new CompanyModel();
        companyModel.setCompanyId(companyId);
        companyModel.setServiceId(serviceId);
        companyModel.setEnclosure(enslosure);
        Integer integer = companyModelService.insertCompanyModel(companyId, serviceId, enslosure);
        if(integer == 1){
            return buildSuccessCodeJson(200,"成功");
        }
        return buildFailureJson(202,"失败");
    }
}
