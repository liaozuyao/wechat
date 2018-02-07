package com.czyl.controller;

import com.czyl.common.StatusConstants;
import com.czyl.entity.AdviserInfo;
import com.czyl.service.AdviserInfoService;
import com.czyl.utils.ViewData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class AdviserInfoController extends BaseController{

    @Resource
    AdviserInfoService adviserInfoService;

    @RequestMapping(value = "/insertAdviser", method = RequestMethod.POST)
    @ResponseBody
    public ViewData insertAdviserInfo(@RequestBody AdviserInfo adviserInfo){
        if(adviserInfoService.insertAdviserInfo(adviserInfo) == 1){
            return buildSuccessCodeJson(StatusConstants.SUCCESS_CODE,"成功");
        }
        return buildFailureJson(StatusConstants.ERROR_CODE,"失败");
    }

    @RequestMapping(value = "/getAllAdviser")
    @ResponseBody
    public ViewData getAllAdviser(){
        return buildSuccessJson(StatusConstants.SUCCESS_CODE,"成功", adviserInfoService.getAllAdviser());
    }
}
