package com.czyl.controller;

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

    @RequestMapping(value = "/insertAdviser", method = RequestMethod.POST)
    @ResponseBody
    public ViewData insertAdviserInfo(@RequestParam("name") String name, @RequestParam("phone") String phone,
                                      @RequestParam("mail") String mail, @RequestParam("type") Integer type){
        if(CommonUtil.isEmpty(name) || CommonUtil.isEmpty(phone) || CommonUtil.isEmpty(mail) || CommonUtil.isEmpty(type)){
            return buildFailureJson(StatusConstants.PARAMS_IS_NULL,"字段不能为空");
        }
        if(adviserInfoService.insertAdviserInfo(name, phone, mail, type) == 1){
            return buildSuccessCodeJson(StatusConstants.SUCCESS_CODE,"成功");
        }
        return buildFailureJson(StatusConstants.ERROR_CODE,"失败");
    }

    @RequestMapping(value = "/getAllAdviser")
    @ResponseBody
    public ViewData getAllAdviser(){
        return buildSuccessJson(StatusConstants.SUCCESS_CODE,"成功", adviserInfoService.getAllAdviser());
    }

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
