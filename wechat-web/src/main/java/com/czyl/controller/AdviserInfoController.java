package com.czyl.controller;

import com.czyl.common.Constants;
import com.czyl.common.StatusConstants;
import com.czyl.entity.AdviserInfo;
import com.czyl.entity.CompanyContact;
import com.czyl.service.AdviserInfoService;
import com.czyl.utils.CommonUtil;
import com.czyl.utils.MD5Utils;
import com.czyl.utils.ViewData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
public class AdviserInfoController extends BaseController{

    @Resource
    private AdviserInfoService adviserInfoService;

    @RequestMapping(value = "/insertAdviserOrDev.html")
    public String insertAdviser(){
        return "/admin/addAdviser";
    }

    @RequestMapping(value = "/adviserAndDevlpMain.html")
    public String advAndDevMain(){
        return "/adviserAndDevlpment/advAndDevMain";
    }

    @RequestMapping(value = "adviserOrDevlpLogin.html")
    public String advDevLogin(){
        return "/adviserAndDevlpment/advDevLogin";
    }

    @RequestMapping(value = "updateAdvOrDevEmail.html")
    public String updateEmail(){
        return "/adviserAndDevlpment/updateEmail";
    }

    @RequestMapping(value = "updateAdviserPassword.html")
    public String updatePassword(){
        return "/adviserAndDevlpment/updateAdviserPassword";
    }

    @RequestMapping(value = "allAdviser.html")
    public String allAdviser(){
        return "/admin/allAdviser";
    }
    /**
     * 修改顾问账号密码
     * @param password
     * @param request
     * @return
     */
    @RequestMapping(value = "/updateAdviserPassword")
    @ResponseBody
    public ViewData updateAdviserPassword(@RequestParam("password")String password, @RequestParam("confirmpassword")String confirmpassword, HttpServletRequest request){
        AdviserInfo adviser = (AdviserInfo)request.getSession().getAttribute("adviser");
        if(adviser == null){
            return buildFailureJson(StatusConstants.SESSION_OUT, "会话超时，请重新登录");
        }
        if(!password.equals(confirmpassword)){
            return  buildFailureJson(StatusConstants.ARGUMENTS_EXCEPTION,"输入的密码不相同，请重新输入");
        }
        if(adviserInfoService.updatePassword(MD5Utils.EncoderByMd5(password), adviser.getId()) == 1){
            return buildFailureJson(StatusConstants.SUCCESS_CODE,"成功");
        }
        return buildFailureJson(StatusConstants.ERROR_CODE,"失败");
    }

    /**
     * 查询实施或开发
     * @param type
     * @return
     */
    @RequestMapping(value = "/getAllByType", method = RequestMethod.POST)
    @ResponseBody
    public ViewData getAllByType(@RequestParam("type")Integer type){
        if(CommonUtil.isEmpty(type)){
            return buildFailureJson(StatusConstants.PARAMS_IS_NULL,"参数错误");
        }
        return buildSuccessJson(StatusConstants.SUCCESS_CODE,"成功",adviserInfoService.getAllByType(type));
    }

    /**
     * 实施或开发登录
     * @param phone
     * @param password
     * @return
     */
    @RequestMapping(value = "/adviserOrDevlpLogin", method = RequestMethod.POST)
    @ResponseBody
    public ViewData adviserOrDevlpLogin(@RequestParam("phone")String phone, @RequestParam("password")String password,
                                        HttpServletRequest request){
        if(CommonUtil.isEmpty(phone) || CommonUtil.isEmpty(password)){
            return buildFailureJson(StatusConstants.PARAMS_IS_NULL,"必填字段不能为空,请重新输入");
        }
        String md5Password = MD5Utils.EncoderByMd5(password);
        AdviserInfo adviserInfo = adviserInfoService.adviserOrDevlpLogin(phone, md5Password);
        if(adviserInfo != null){
            request.getSession().setAttribute("adviser",adviserInfo);
            return buildSuccessCodeJson(StatusConstants.SUCCESS_CODE,"成功");
        }
        return buildFailureJson(StatusConstants.ERROR_CODE,"账号或密码错误");
    }

    /**
     * 修改开发/实施联系邮箱
     * @param mail
     * @return
     */
    @RequestMapping(value = "/updateAdvOrDevMail")
    @ResponseBody
    public ViewData updateAdvOrDevMail(@RequestParam("mail")String mail, HttpServletRequest request){
        AdviserInfo adviser = (AdviserInfo)request.getSession().getAttribute("adviser");
        if(adviser == null){
            return buildFailureJson(StatusConstants.SESSION_OUT, "会话超时，请重新登录");
        }
        if(CommonUtil.isEmpty(mail)){
            return buildFailureJson(StatusConstants.PARAMS_IS_NULL,"必填字段不能为空,请重新输入");
        }
        if(!mail.matches(Constants.REGEX_EMAIL)){
            return buildFailureJson(StatusConstants.PARAMS_IS_NULL,"邮箱格式错误,请重新输入");
        }
        if(adviserInfoService.updateEmail(mail, adviser.getId()) == 1){
            return buildSuccessCodeJson(StatusConstants.SUCCESS_CODE,"成功");
        }
        return buildFailureJson(StatusConstants.ERROR_CODE,"失败");
    }

    /**
     * 查询顾问信息
     * @param request
     * @return
     */
    @RequestMapping(value = "getAdviserInfo")
    @ResponseBody
    public ViewData getAdviserInfo(HttpServletRequest request){
        AdviserInfo adviser = (AdviserInfo)request.getSession().getAttribute("adviser");
        if(adviser == null){
            return buildFailureJson(StatusConstants.SESSION_OUT, "会话超时，请重新登录");
        }
        AdviserInfo adviserInfo = adviserInfoService.selectAdviserById(adviser.getId());
        return buildSuccessJson(StatusConstants.SUCCESS_CODE,"成功", adviserInfo);
    }

    /**
     * 添加实施或开发人员账号
     * @param name
     * @param phone
     * @param email
     * @param type
     * @return
     */
    @RequestMapping(value = "/insertAdviser", method = RequestMethod.POST)
    @ResponseBody
    public ViewData insertAdviserInfo(@RequestParam("name") String name, @RequestParam("phone") String phone,
                                      @RequestParam("email") String email, @RequestParam("type") Integer type,
                                      HttpServletRequest request){
        if(CommonUtil.isEmpty(name) || CommonUtil.isEmpty(phone) || CommonUtil.isEmpty(email) || CommonUtil.isEmpty(type)){
            return buildFailureJson(StatusConstants.PARAMS_IS_NULL,"必填字段不能为空,请重新输入");
        }
        if(!phone.matches(Constants.REGEX_MOBILE)){
           return buildFailureJson(StatusConstants.ARGUMENTS_EXCEPTION,"手机格式错误,请重新输入");
        }
        if(!email.matches(Constants.REGEX_EMAIL)){
            return buildFailureJson(StatusConstants.ARGUMENTS_EXCEPTION,"邮箱格式错误,请重新输入");
        }
        if(type == 9){
            return buildFailureJson(StatusConstants.ARGUMENTS_EXCEPTION,"请选择开发/实施");
        }
        if(adviserInfoService.insertAdviserInfo(name, phone, email, type) == 1){
            return buildSuccessCodeJson(StatusConstants.SUCCESS_CODE,"成功");
        }
        return buildFailureJson(StatusConstants.ERROR_CODE,"失败");
    }

    /**
     * 查询全部实施和开发
     * @return
     */
    @RequestMapping(value = "/getAllAdviser")
    @ResponseBody
    public ViewData getAllAdviser(HttpServletRequest request){
        CompanyContact companyContact = (CompanyContact)request.getSession().getAttribute("companyContact");
        if(companyContact == null){
            return buildFailureJson(StatusConstants.SESSION_OUT, "会话超时，请重新登录");
        }
        if(companyContact.getIsSuper() != 1){
            return buildFailureJson(StatusConstants.NOT_JURISDICTION, "无此权限");
        }
        return buildSuccessJson(StatusConstants.SUCCESS_CODE,"成功", adviserInfoService.getAllAdviser());
    }

    /**
     * 更新实施或开发信息
     * @param name
     * @param phone
     * @param mail
     * @param id
     * @param type
     * @return
     */
    @RequestMapping(value = "/updateAdviser", method = RequestMethod.POST)
    @ResponseBody
    public ViewData updateAdviser(@RequestParam("name") String name, @RequestParam("phone") String phone,
                                  @RequestParam("mail") String mail, @RequestParam("id") Long id,
                                  @RequestParam("type") Integer type){
        if(CommonUtil.isEmpty(name) || CommonUtil.isEmpty(phone) || CommonUtil.isEmpty(mail) || CommonUtil.isEmpty(id)){
            return buildFailureJson(StatusConstants.PARAMS_IS_NULL,"字段不能为空");
        }
        Integer integer = adviserInfoService.updateAdviserInfo(name, phone, mail, id, type);
        if(integer == 1){
            return buildSuccessCodeJson(StatusConstants.SUCCESS_CODE,"成功");
        }
        return buildFailureJson(StatusConstants.ERROR_CODE,"失败");
    }
}
