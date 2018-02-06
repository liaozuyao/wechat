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
    FieldService fieldService;

    @RequestMapping("/getAllField")
    @ResponseBody
    public ViewData getAll(){
        return buildSuccessJson(StatusConstants.SUCCESS_CODE,"成功", fieldService.selectAll());
    }

    @RequestMapping(value = "/updateField", method = RequestMethod.POST)
    @ResponseBody
    public ViewData updateField(@RequestBody Field field){
        return null;
    }

    @RequestMapping(value = "/insertField", method = RequestMethod.POST)
    @ResponseBody
    public ViewData insertField(@RequestBody Field field){
        return null;
    }
}
