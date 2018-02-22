package com.czyl.controller;

import com.czyl.common.StatusConstants;
import com.czyl.entity.CompanyContact;
import com.czyl.service.CompanyContactService;
import com.czyl.utils.CommonUtil;
import com.czyl.utils.MD5Utils;
import com.czyl.utils.ViewData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
public class SuperAdminController extends BaseController{

    @Resource
    private CompanyContactService companyContactService;

    /**
     * 超级管理员登录接口
     * @param account
     * @param password
     * @param request
     * @return
     */
    @RequestMapping(value = "superAdminLogin", method = RequestMethod.POST)
    @ResponseBody
    public ViewData superAdminLogin(@RequestParam("account")String account, @RequestParam("password")String password,
                                        HttpServletRequest request){
        if(CommonUtil.isEmpty(account) || CommonUtil.isEmpty(password)){
            return buildFailureJson(StatusConstants.PARAMS_IS_NULL,"必填字段不能为空");
        }
        password = MD5Utils.EncoderByMd5(password);
        CompanyContact companyContact = companyContactService.selectCompanyContact(account, password);
        if(companyContact == null){
            return buildFailureJson(StatusConstants.ERROR_CODE,"账号或密码错误");
        }
        if(companyContact.getIsSuper() == 1){
            request.getSession().setAttribute("companyContact", companyContact);
            return buildSuccessCodeJson(StatusConstants.SUCCESS_CODE,"成功");
        }
        return buildFailureJson(StatusConstants.ERROR_CODE,"账号或密码错误");
    }
}
