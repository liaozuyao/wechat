package com.czyl.controller;

import com.czyl.common.StatusConstants;
import com.czyl.entity.Selected;
import com.czyl.service.ConstantService;
import com.czyl.service.EventTypeService;
import com.czyl.service.SelectedService;
import com.czyl.utils.ViewData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by liaozuyao on 2017/12/19.
 */
@Controller
public class SelectedController extends BaseController {

    @Resource
    SelectedService selectedService;

    @Resource
    EventTypeService eventTypeService;

    @Resource
    ConstantService constantService;

    @RequestMapping(value = "/selected", method = RequestMethod.GET)
    @ResponseBody
    public ViewData getSelected(@RequestParam("parentId")Long parentId){
        return buildSuccessViewData(StatusConstants.SUCCESS_CODE, "成功" , selectedService.select(parentId));
    }

    @RequestMapping(value = "/getSelectName", method = RequestMethod.GET)
    @ResponseBody
    public ViewData getSelectName(@RequestParam("id")Long id){
        Selected select = selectedService.getSelectName(id);
        return buildSuccessViewData(StatusConstants.SUCCESS_CODE, "成功", select);
    }

    @RequestMapping(value = "/add")
    public String addQuestion(){
        return "addQuestion";
    }
}
