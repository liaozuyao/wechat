package com.czyl.controller;

import com.czyl.common.StatusConstants;
import com.czyl.entity.Field;
import com.czyl.service.FieldService;
import com.czyl.utils.CommonUtil;
import com.czyl.utils.ViewData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Controller
public class FieldController extends BaseController {

    @Resource
    private FieldService fieldService;

    @RequestMapping("/getAllField")
    @ResponseBody
    public ViewData getAll() {
        return buildSuccessJson(StatusConstants.SUCCESS_CODE, "成功", fieldService.selectAll());
    }

    @RequestMapping(value = "/addField.html")
    public String addField() {
        return "admin/addField";
    }

    @RequestMapping(value = "/allField.html")
    public String allField() {
        return "admin/allField";
    }

    @RequestMapping(value = "/updateField", method = RequestMethod.POST)
    @ResponseBody
    public ViewData updateField(@RequestParam("name") String name) {
        if (CommonUtil.isEmpty(name)) {
            return buildFailureJson(StatusConstants.PARAMS_IS_NULL, "名字不能为空");
        }
        if (fieldService.updateField(name) == 1) {
            return buildSuccessCodeJson(StatusConstants.SUCCESS_CODE, "成功");
        }
        return buildFailureJson(StatusConstants.ERROR_CODE, "失败");
    }

    @RequestMapping(value = "/insertField", method = RequestMethod.POST)
    @ResponseBody
    public ViewData insertField(@RequestParam("name") String name) {
        if (CommonUtil.isEmpty(name)) {
            return buildFailureJson(StatusConstants.PARAMS_IS_NULL, "名字不能为空");
        }
        if (fieldService.insertField(name) == 1) {
            return buildSuccessCodeJson(StatusConstants.SUCCESS_CODE, "成功");
        }
        return buildFailureJson(StatusConstants.ERROR_CODE, "失败");
    }

    @RequestMapping(value = "/deleteField", method = RequestMethod.POST)
    @ResponseBody
    public ViewData deleteField(@RequestParam("id") Long id) {
        if (id == null) {
            return buildFailureJson(StatusConstants.PARAMS_IS_NULL, "参数不能为空");
        }
        if (fieldService.deleteField(id) == 1) {
            return buildSuccessCodeJson(StatusConstants.SUCCESS_CODE, "成功");
        }
        return buildFailureJson(StatusConstants.ERROR_CODE, "失败");
    }
}
