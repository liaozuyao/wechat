package com.czyl.controller;

import com.czyl.common.StatusConstants;
import com.czyl.service.ServiceModelService;
import com.czyl.utils.ViewData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class ServiceModelController extends BaseController{

    @Resource
    private ServiceModelService serviceModelService;

    @RequestMapping(value = "/insertServiceName",method = RequestMethod.POST)
    @ResponseBody
    public ViewData insertServiceName(@RequestParam("name") String name){
        if(name != "" && !name.equals(null)){
            if(serviceModelService.insert(name) == 1){
                return buildSuccessCodeJson(StatusConstants.SUCCESS_CODE,"成功");
            }
            return buildFailureJson(StatusConstants.ERROR_CODE,"失败");
        }
        return buildFailureJson(StatusConstants.PARAMS_IS_NULL,"名字不能为空");
    }

    @RequestMapping(value = "/getAllServiceName")
    @ResponseBody
    public ViewData getAllServiceName(){
        return buildSuccessJson(StatusConstants.SUCCESS_CODE,"成功",serviceModelService.selectServiceName());
    }

    @RequestMapping(value = "/updateServiceName",method = RequestMethod.POST)
    @ResponseBody
    public ViewData updateServiceName(@RequestParam("name")String name, @RequestParam("id")Long id){
        if(name != "" && !name.equals(null) && !id.equals(null)){
            if(serviceModelService.updateServiceName(name, id) == 1){
                return buildSuccessCodeJson(StatusConstants.SUCCESS_CODE,"成功");
            }
            return buildFailureJson(StatusConstants.ERROR_CODE,"错误");
        }
        return buildFailureJson(StatusConstants.PARAMS_IS_NULL,"参数字段不能为空");
    }

    @RequestMapping(value = "/delServiceModel", method = RequestMethod.POST)
    @ResponseBody
    public ViewData deleteServiceModel(@RequestParam("isDelete")Integer isDel, @RequestParam("id")Long id){
        if(isDel.equals(null) || id.equals(null)){
            return buildFailureJson(StatusConstants.PARAMS_IS_NULL,"参数字段不能为空");
        }
        Integer integer = serviceModelService.deleteServiceName(isDel, id);
        if(integer == 1){
            return buildSuccessCodeJson(StatusConstants.SUCCESS_CODE,"成功");
        }
        return buildFailureJson(StatusConstants.ERROR_CODE,"错误");
    }
}
