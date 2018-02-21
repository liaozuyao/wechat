package com.czyl.controller;

import com.czyl.common.Constants;
import com.czyl.common.StatusConstants;
import com.czyl.entity.AdviserInfo;
import com.czyl.service.AdviserInfoService;
import com.czyl.utils.CommonUtil;
import com.czyl.utils.ViewData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Controller
public class AdviserInfoController extends BaseController{

    @Resource
    AdviserInfoService adviserInfoService;

    @RequestMapping(value = "/insertAdviserOrDev.html")
    public String insertAdviser(){
        return "admin/addAdviser";
    }

    @RequestMapping(value = "/adviserAndDevlpMain.html")
    public String advAndDevMain(){
        return "/adviserAndDevlpment/advAndDevMain";
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
    public ViewData adviserOrDevlpLogin(@RequestParam("phone")String phone, @RequestParam("password")String password){
        if(CommonUtil.isEmpty(phone) || CommonUtil.isEmpty(password)){
            return buildFailureJson(StatusConstants.PARAMS_IS_NULL,"必填字段不能为空,请重新输入");
        }
        if(adviserInfoService.adviserOrDevlpLogin(phone, password) != null){
            return buildSuccessCodeJson(StatusConstants.SUCCESS_CODE,"成功");
        }
        return buildFailureJson(StatusConstants.ERROR_CODE,"失败");
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
                                      @RequestParam("email") String email, @RequestParam("type") Integer type){
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
    public ViewData getAllAdviser(){
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
