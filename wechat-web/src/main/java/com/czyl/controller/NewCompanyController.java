package com.czyl.controller;

import com.czyl.common.StatusConstants;
import com.czyl.service.ICompanyService;
import com.czyl.utils.CommonUtil;
import com.czyl.utils.ViewData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@Api(description = "公司相关接口")
public class NewCompanyController extends BaseController {

    @Resource
    private ICompanyService iCompanyService;

    @ResponseBody
    @PostMapping(value = "/addCompany")
    @ApiOperation(value = "添加公司")
    public ViewData addCompany(@RequestParam("name") String name) {
        if (CommonUtil.isEmpty(name)) {
            return buildFailureJson(StatusConstants.PARAMS_IS_NULL, "参数为空");
        }
        if (iCompanyService.addCompany(name) == 1) {
            return buildSuccessCodeJson(StatusConstants.SUCCESS_CODE, "成功");
        } else {
            return buildFailureJson(StatusConstants.ERROR_CODE, "失败");
        }
    }

    @ResponseBody
    @PostMapping(value = "/updateCompany")
    @ApiOperation(value = "更新公司信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "code", value = "税号", paramType = "query"),
            @ApiImplicitParam(name = "phone", value = "电话", paramType = "query"),
            @ApiImplicitParam(name = "mail", value = "邮件", paramType = "query"),
            @ApiImplicitParam(name = "id", value = "主键", paramType = "query")
    })
    public ViewData updateCompany(String code, String phone, String mail,Long id) {
        if (CommonUtil.isEmpty(code, phone, mail, id)) {
            return buildFailureJson(StatusConstants.PARAMS_IS_NULL, "参数为空");
        }
        if (iCompanyService.updateCompany(code, phone, mail, id) == 1) {
            return buildSuccessCodeJson(StatusConstants.SUCCESS_CODE, "成功");
        } else {
            return buildFailureJson(StatusConstants.ERROR_CODE, "失败");
        }
    }

    @ResponseBody
    @PostMapping(value = "/deleteCompany")
    @ApiOperation(value = "删除公司")
    public ViewData deleteCompany(@RequestParam("isdelete")Integer isdelete, @RequestParam("id") Long id) {
        if (CommonUtil.isEmpty(id)) {
            return buildFailureJson(StatusConstants.PARAMS_IS_NULL, "参数为空");
        }
        if (iCompanyService.deleteCompany(isdelete, id) == 1) {
            return buildSuccessCodeJson(StatusConstants.SUCCESS_CODE, "成功");
        } else {
            return buildFailureJson(StatusConstants.ERROR_CODE, "失败");
        }
    }

    @ResponseBody
    @GetMapping(value = "/getAllCompany")
    @ApiOperation(value = "全部公司")
    public ViewData getAllCompany(){
        return buildSuccessViewData(StatusConstants.SUCCESS_CODE,"成功", iCompanyService.getAllCompany());
    }
}
