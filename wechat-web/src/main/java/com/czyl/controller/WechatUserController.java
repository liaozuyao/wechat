package com.czyl.controller;

import com.czyl.common.StatusConstants;
import com.czyl.service.IWechatUserService;
import com.czyl.utils.CommonUtil;
import com.czyl.utils.ViewData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Controller
@Api(description = "用户相关接口")
public class WechatUserController extends BaseController {

    @Resource
    private IWechatUserService iWechatUserService;

    /**
     * 获取全部用户
     *
     * @return
     */
    @ResponseBody
    @GetMapping(value = "/getAllUser")
    @ApiOperation(value = "获取全部用户")
    public ViewData getAllUser() {
        return buildSuccessViewData(StatusConstants.SUCCESS_CODE, "成功", iWechatUserService.getAllUser());
    }

    /**
     * 关联用户到公司
     *
     * @param id
     * @param companyId
     * @return
     */
    @ResponseBody
    @GetMapping(value = "/relationUserCompnay")
    @ApiOperation(value = "关联用户到公司")
    public ViewData relationUserCompnay(@RequestParam("id") Long id, @RequestParam("companyId") Long companyId) {
        if (CommonUtil.isEmpty(id) || CommonUtil.isEmpty(companyId)) {
            return buildFailureJson(StatusConstants.PARAMS_IS_NULL, "参数为空");
        } else {
            if (iWechatUserService.relationUserCompnay(id, companyId) == 1) {
                return buildSuccessCodeJson(StatusConstants.SUCCESS_CODE, "成功");
            } else {
                return buildFailureJson(StatusConstants.ERROR_CODE, "失败");
            }
        }
    }

    /**
     * 取消用户关联
     *
     * @param id
     * @return
     */
    @ResponseBody
    @GetMapping(value = "/cancelRelation")
    @ApiOperation(value = "取消用户与公司的关联")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "id", value = "用户ID", required = true)
    )
    public ViewData cancelRelation(@RequestParam("id") Long id) {
        if (CommonUtil.isEmpty(id)) {
            return buildFailureJson(StatusConstants.PARAMS_IS_NULL, "参数为空");
        }
        if (iWechatUserService.cancelRelation(id) == 1) {
            return buildFailureJson(StatusConstants.SUCCESS_CODE, "成功");
        } else {
            return buildFailureJson(StatusConstants.ERROR_CODE, "失败");
        }

    }

    /**
     * 修改用户账号是否可用
     *
     * @param id
     * @param isdelete
     * @return
     */
    @ResponseBody
    @GetMapping(value = "/updateDelete")
    @ApiOperation(value = "修改账号是否可用")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "id", value = "用户id", required = true, dataType = "Long"),
            @ApiImplicitParam(paramType = "query", name = "isdelete", value = "是否可用,0不可用，1可用", required = true, dataType = "Integer")
    })
    public ViewData updateDelete(@RequestParam("id") Long id, @RequestParam("isdelete") Integer isdelete) {
        if (CommonUtil.isEmpty(id) || CommonUtil.isEmpty(isdelete)) {
            return buildFailureJson(StatusConstants.PARAMS_IS_NULL, "参数为空");
        }
        if (iWechatUserService.updateDelete(id, isdelete) == 1) {
            return buildFailureJson(StatusConstants.SUCCESS_CODE, "成功");
        } else {
            return buildFailureJson(StatusConstants.ERROR_CODE, "失败");
        }
    }
}
