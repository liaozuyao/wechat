package com.czyl.controller;

import com.czyl.common.StatusConstants;
import com.czyl.service.ServiceModelService;
import com.czyl.utils.CommonUtil;
import com.czyl.utils.ViewData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Controller
@Api(description = "服务模块相关接口")
public class ServiceModelController extends BaseController{

    @Resource
    private ServiceModelService serviceModelService;

    @GetMapping(value = "/addServiceModel.html")
    public String addServiceModel(){
        return "admin/addServiceModel";
    }

    @GetMapping(value = "/allServiceModel.html")
    public String allServiceModel(){
        return "admin/allServiceModel";
    }

    /**
     * 添加服务模块名字
     * @param name
     * @return
     */
    @RequestMapping(value = "/insertServiceName",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "添加服务模块名字")
    @ApiImplicitParam(name="name",value = "模块名字")
    public ViewData insertServiceName(@RequestParam("name") String name){
        if(CommonUtil.isEmpty(name)){
            if(serviceModelService.insert(name) == 1){
                return buildSuccessCodeJson(StatusConstants.SUCCESS_CODE,"成功");
            }
            return buildFailureJson(StatusConstants.ERROR_CODE,"失败");
        }
        return buildFailureJson(StatusConstants.PARAMS_IS_NULL,"名字不能为空");
    }

    /**
     * 获取全部服务名字
     * @return
     */
    @GetMapping(value = "/getAllServiceName")
    @ResponseBody
    @ApiOperation(value = "查询全部服务模块")
    public ViewData getAllServiceName(){
        return buildSuccessJson(StatusConstants.SUCCESS_CODE,"成功",serviceModelService.selectServiceName());
    }

    /**
     * 更新服务模块名字
     * @param name
     * @param id
     * @return
     */
    @RequestMapping(value = "/updateServiceName",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "更新服务模块")
    public ViewData updateServiceName(@RequestParam("name")String name, @RequestParam("id")Long id){
        if(CommonUtil.isEmpty(name) || CommonUtil.isEmpty(id)){
            return buildFailureJson(StatusConstants.PARAMS_IS_NULL,"字段不能为空");
        }
        if(serviceModelService.updateServiceName(name, id) == 1){
            return buildSuccessCodeJson(StatusConstants.SUCCESS_CODE,"成功");
        }
        return buildFailureJson(StatusConstants.ERROR_CODE,"错误");
    }

    /**
     * 删除服务模块
     * @param isDel
     * @param id
     * @return
     */
    @RequestMapping(value = "/delServiceModel", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "删除服务模块")
    public ViewData deleteServiceModel(@RequestParam("isDelete")Integer isDel, @RequestParam("id")Long id){
        if(isDel == null || CommonUtil.isEmpty(id)){
            return buildFailureJson(StatusConstants.PARAMS_IS_NULL,"参数字段不能为空");
        }
        Integer integer = serviceModelService.deleteServiceName(isDel, id);
        if(integer == 1){
            return buildSuccessCodeJson(StatusConstants.SUCCESS_CODE,"成功");
        }
        return buildFailureJson(StatusConstants.ERROR_CODE,"错误");
    }
}
