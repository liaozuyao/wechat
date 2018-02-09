package com.czyl.controller;

import com.czyl.common.StatusConstants;
import com.czyl.service.CompanyModelBeanService;
import com.czyl.service.CompanyModelService;
import com.czyl.service.CompanyService;
import com.czyl.utils.CommonUtil;
import com.czyl.utils.ViewData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by liaozuyao on 2018/1/3.
 */
@Controller
public class CompanyController extends BaseController {

    @Resource
    private CompanyService companyService;

    @Resource
    private CompanyModelBeanService companyModelBeanService;

    @Resource
    private CompanyModelService companyModelService;

    @RequestMapping(value = "/insertCompany", method = RequestMethod.POST)
    @ResponseBody
    public ViewData insertCompany(@RequestParam("name") String name, HttpServletRequest request) {
        if (CommonUtil.isEmpty(name)) {
            return buildFailureJson(StatusConstants.PARAMS_IS_NULL, "字段不能为空");
        }
        Integer i = companyService.insertCompany(name);
        if (i == 1) {
            return buildSuccessCodeJson(StatusConstants.SUCCESS_CODE, "成功");
        } else {
            return buildFailureJson(StatusConstants.ERROR_CODE, "失败");
        }
    }

    @RequestMapping(value = "/updateCompany.html")
    public String updateCompanyModel() {
        return "updateCompany";
    }

    @RequestMapping(value = "/insertCompany.html")
    public String insertCompanyModel() {
        return "admin/addCompany";
    }

    @RequestMapping(value = "/allCompany.html")
    public String allCompany(){
        return "admin/allCompany";
    }

    @RequestMapping(value = "/updateComanyInfo", method = RequestMethod.POST)
    @ResponseBody
    public ViewData updateCompany(@RequestParam("code") String code, @RequestParam("name") String name, String contactName, @RequestParam("contactPhone") String contactPhone,
                                  @RequestParam("contactMail") String contactMail, HttpServletRequest request) {
        Integer i = companyService.updateCompany(code, name, contactPhone, contactMail, 8L);
        if (i == 1) {
            return buildSuccessCodeJson(StatusConstants.SUCCESS_CODE, "成功");
        } else {
            return buildFailureJson(StatusConstants.ERROR_CODE, "失败");
        }
    }

    @RequestMapping(value = "/selectCompanys")
    @ResponseBody
    public ViewData selectCompanys() {
        return buildSuccessJson(StatusConstants.SUCCESS_CODE, "成功", companyModelBeanService.selectAllCompany());
    }

    @RequestMapping(value = "/selectCompanyById")
    @ResponseBody
    public ViewData selectCompanyById(@RequestParam("id") Long id) {
        if (CommonUtil.isEmpty(id)) {
            return buildFailureJson(StatusConstants.PARAMS_IS_NULL, "字段不能为空");
        }
        return buildSuccessJson(StatusConstants.SUCCESS_CODE, "成功", companyModelBeanService.selectByCompanyId(id));
    }

    @RequestMapping(value = "/insertCompanyModel", method = RequestMethod.POST)
    @ResponseBody
    public ViewData insertCompanyModel(@RequestParam("companyId") Long companyId, @RequestParam("serviceId") Long serviceId,
                                       @RequestParam("enclosure") String enslosure) {
        if (CommonUtil.isEmpty(companyId) || CommonUtil.isEmpty(serviceId) || CommonUtil.isEmpty(enslosure)) {
            return buildFailureJson(StatusConstants.PARAMS_IS_NULL, "字段不能为空");
        }
        Integer integer = companyModelService.insertCompanyModel(companyId, serviceId, enslosure);
        if (integer == 1) {
            return buildSuccessCodeJson(StatusConstants.SUCCESS_CODE, "成功");
        }
        return buildFailureJson(StatusConstants.ERROR_CODE, "失败");
    }
}
