package com.czyl.controller;

import com.czyl.common.Constants;
import com.czyl.common.StatusConstants;
import com.czyl.entity.Company;
import com.czyl.entity.CompanyContact;
import com.czyl.service.CompanyContactService;
import com.czyl.service.CompanyService;
import com.czyl.utils.CommonUtil;
import com.czyl.utils.MD5Utils;
import com.czyl.utils.Tools;
import com.czyl.utils.ViewData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class CompanyContactController extends BaseController{

    @Resource
    private CompanyContactService companyContactService;

    @Resource
    private CompanyService companyService;

    @RequestMapping(value = "/insertAccount.html")
    public ModelAndView insertAccountView(){
        List<Company> companies = companyService.selectCompany();
        ModelAndView mav = new ModelAndView("admin/addAccount");
        mav.addObject("companies", companies);
        return mav;
    }

    @RequestMapping(value = "/insertAccount",method = RequestMethod.POST)
    @ResponseBody
    public ViewData insertAccount(@RequestParam("companyId")Long companyId){
        if(CommonUtil.isEmpty(companyId)){
            return buildFailureJson(StatusConstants.PARAMS_IS_NULL,"请选择公司");
        }
        StringBuilder sbAccount = new StringBuilder("CZ").append(Tools.getRandomCode(Constants.ACCOUNT_BIT));
        Integer integer = companyContactService.insertCompanyContact(sbAccount.toString(), companyId);
        if(integer == 1){
            return buildSuccessCodeJson(StatusConstants.SUCCESS_CODE, sbAccount.toString());
        }
        return buildFailureJson(StatusConstants.ERROR_CODE,"失败");
    }

    @RequestMapping(value = "/updateCompanyContact", method = RequestMethod.POST)
    @ResponseBody
    public ViewData updateCompanyContact(@RequestParam("name") String name, @RequestParam("phone") String phone,
                                         @RequestParam("mail") String mail){
        if(CommonUtil.isEmpty(name) || CommonUtil.isEmpty(mail)){
            return buildFailureJson(StatusConstants.PARAMS_IS_NULL,"参数为空");
        }
        if(!phone.matches(Constants.REGEX_MOBILE)){
            return buildFailureJson(StatusConstants.ARGUMENTS_EXCEPTION,"输入正确的电话号码");
        }
        // TODO
        Long id = 1L;
        Integer integer = companyContactService.updateCompanyContact(name, phone, mail, id);
        if(integer == 1){
            return buildSuccessCodeJson(StatusConstants.SUCCESS_CODE,"成功");
        }
        return buildFailureJson(StatusConstants.ERROR_CODE,"失败");
    }

    @RequestMapping(value = "/updateContactPassword",method = RequestMethod.POST)
    @ResponseBody
    public ViewData updateContactPassword(@RequestParam("password")String password){
        //TODO
        Long id = 1L;
        if(CommonUtil.isEmpty(password)){
            return buildFailureJson(StatusConstants.PARAMS_IS_NULL,"参数为空");
        }
        Integer integer = companyContactService.updateCompanyContactPassword(password, id);
        if(integer == 1){
            return buildSuccessCodeJson(StatusConstants.SUCCESS_CODE,"成功");
        }
        return buildFailureJson(StatusConstants.ERROR_CODE,"失败");
    }

    @RequestMapping(value = "/updateAccountIsActive",method = RequestMethod.POST)
    @ResponseBody
    public ViewData updateAccountIsActive(@RequestParam("isActive")Integer isActive){
        //TODO
        Long id = 1L;
        if(CommonUtil.isEmpty(isActive)){
            return buildFailureJson(StatusConstants.PARAMS_IS_NULL,"参数为空");
        }
        Integer integer = companyContactService.updateAccountIsActive(isActive, id);
        if(integer == 1){
            return buildSuccessCodeJson(StatusConstants.SUCCESS_CODE,"成功");
        }
        return buildFailureJson(StatusConstants.ERROR_CODE,"失败");
    }

    @RequestMapping(value = "/updateAccountIsSuper",method = RequestMethod.POST)
    @ResponseBody
    public ViewData updateAccountIsSuper(@RequestParam("isSuper")Integer isSuper){
        //TODO
        Long id = 1L;
        if(CommonUtil.isEmpty(isSuper)){
            return buildFailureJson(StatusConstants.PARAMS_IS_NULL,"参数为空");
        }
        Integer integer = companyContactService.updateAccountIsSuper(isSuper, id);
        if(integer == 1){
            return buildSuccessCodeJson(StatusConstants.SUCCESS_CODE,"成功");
        }
        return buildFailureJson(StatusConstants.ERROR_CODE,"失败");
    }

    @RequestMapping(value = "/accountLogin", method = RequestMethod.POST)
    @ResponseBody
    public ViewData accountLogin(@RequestParam("account")String account, @RequestParam("password")String password,
                                 HttpServletRequest request){
        if(CommonUtil.isEmpty(account) || CommonUtil.isEmpty(password)){
            return buildFailureJson(StatusConstants.PARAMS_IS_NULL,"参数为空");
        }
        password = MD5Utils.EncoderByMd5(password);
        CompanyContact companyContact = companyContactService.selectCompanyContact(account, password);
        if(companyContact != null){
            //TODO
            return buildSuccessCodeJson(StatusConstants.SUCCESS_CODE,"成功");
        }
        return buildFailureJson(StatusConstants.ERROR_CODE,"账号或密码错误");
    }

    @RequestMapping(value = "/adminMain.html")
    public String adminLogin(){
        return "/admin/adminMain";
    }
}
