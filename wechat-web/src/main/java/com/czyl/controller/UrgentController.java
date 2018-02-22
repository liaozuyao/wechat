package com.czyl.controller;

import com.czyl.common.StatusConstants;
import com.czyl.service.UrgentService;
import com.czyl.utils.CommonUtil;
import com.czyl.utils.ViewData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class UrgentController extends BaseController{

    @Resource
    private UrgentService urgentService;

    /**
     * 查询紧急度
     * @return
     */
    @RequestMapping(value = "/getAllUrgent")
    @ResponseBody
    public ViewData getAllUrgent(){
        return buildSuccessJson(StatusConstants.SUCCESS_CODE,"成功", urgentService.getAllUrgent());
    }

    /**
     * 删除紧急度
     * @param id
     * @return
     */
    @RequestMapping(value = "/deleteUrgent",method = RequestMethod.POST)
    @ResponseBody
    public ViewData deleteUrgent(@RequestParam("id")Long id){
        if(CommonUtil.isEmpty(id)){
            return buildFailureJson(StatusConstants.PARAMS_IS_NULL, "参数不能为空");
        }
        if(urgentService.deleteUrgent(id) == 1){
            return buildSuccessCodeJson(StatusConstants.SUCCESS_CODE, "成功");
        }
        return buildFailureJson(StatusConstants.ERROR_CODE, "失败");
    }

    /**
     * 添加紧急度
     * @param name
     * @return
     */
    @RequestMapping(value = "/insertUrgent", method = RequestMethod.POST)
    @ResponseBody
    public ViewData insertUrgent(@RequestParam("name")String name){
        if(CommonUtil.isEmpty(name)){
            return buildFailureJson(StatusConstants.PARAMS_IS_NULL, "参数不能为空");
        }
        if(urgentService.insertUrgent(name) == 1){
            return buildSuccessCodeJson(StatusConstants.SUCCESS_CODE, "成功");
        }
        return buildFailureJson(StatusConstants.ERROR_CODE, "失败");
    }
}
