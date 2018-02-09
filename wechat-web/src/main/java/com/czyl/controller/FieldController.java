package com.czyl.controller;

import com.czyl.common.StatusConstants;
import com.czyl.entity.Field;
import com.czyl.service.FieldService;
import com.czyl.utils.ViewData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class FieldController extends BaseController{

    @Resource
    private FieldService fieldService;

    @RequestMapping("/getAllField")
    @ResponseBody
    public ViewData getAll(){
        return buildSuccessJson(StatusConstants.SUCCESS_CODE,"成功", fieldService.selectAll());
    }

    @RequestMapping(value = "/addField.html")
    public String addField(){
        return "admin/addField";
    }

    @RequestMapping(value = "allField.html")
    public String allField(){
        return "admin/allField";
    }

    @RequestMapping(value = "/updateField", method = RequestMethod.POST)
    @ResponseBody
    public ViewData updateField(@RequestBody Field field){
        if(field.getName() != ""){
            if(fieldService.updateField(field) == 1){
                return buildSuccessCodeJson(StatusConstants.SUCCESS_CODE,"成功");
            }
            return buildFailureJson(StatusConstants.ERROR_CODE,"失败");
        }
        return buildFailureJson(StatusConstants.PARAMS_IS_NULL,"名字不能为空");
    }

    @RequestMapping(value = "/insertField", method = RequestMethod.POST)
    @ResponseBody
    public ViewData insertField(@RequestBody Field field){
        if(field.getName() != ""){
            if(fieldService.insertField(field) == 1){
                return buildSuccessCodeJson(StatusConstants.SUCCESS_CODE,"成功");
            }
            return buildFailureJson(StatusConstants.ERROR_CODE,"失败");
        }
        return buildFailureJson(StatusConstants.PARAMS_IS_NULL,"名字不能为空");
    }
}
