package com.czyl.controller;

import com.czyl.common.StatusConstants;
import com.czyl.entity.CompanyContact;
import com.czyl.service.QuestionService;
import com.czyl.utils.CommonUtil;
import com.czyl.utils.ViewData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by liaozuyao on 2017/12/19.
 */
@Controller
public class QuestionController extends BaseController {

    @Resource
    private QuestionService questionService;

    @RequestMapping(value = "addQuestion.html")
    public String addQuestion(){
        return "addQuestion";
    }

    @RequestMapping(value = "allQuestion.html")
    public String allQuestion() {
        return "allQuestion";
    }

    /**
     * 添加问题
     * @param title
     * @param fieldId
     * @param urgent
     * @param files
     * @param describe
     * @param hopeTime
     * @param adviser
     * @param request
     * @return
     */
    @RequestMapping(value = "/insertQuestion", method = RequestMethod.POST)
    @ResponseBody
    public ViewData insertQuestion(@RequestParam("title")String title, @RequestParam("fieldId")Long fieldId,
                                   @RequestParam("urgent")Long urgent, @RequestParam("files")String files,
                                   @RequestParam("describe")String describe, @RequestParam("hopeTime") String hopeTime,
                                   @RequestParam("adviser")Long adviser, HttpServletRequest request){
        if(CommonUtil.isEmpty(title) || fieldId == 0 || urgent == 0 || CommonUtil.isEmpty(describe)){
            return buildFailureJson(StatusConstants.PARAMS_IS_NULL,"必填字段不能为空");
        }
        if(CommonUtil.isEmpty(hopeTime)){
            return buildFailureJson(StatusConstants.PARAMS_IS_NULL,"请填入希望解决时间");
        }
        CompanyContact companyContact = (CompanyContact)request.getSession().getAttribute("companyContact");
        if(companyContact == null){
            return buildFailureJson(StatusConstants.SESSION_OUT,"会话超时，请重新登录");
        }
        long companyId = companyContact.getCompanyId();
        Integer status = questionService.insertQuestion(title, fieldId, urgent, files, describe, hopeTime, companyId, adviser);
        if(status == 1){
            return buildSuccessCodeJson(StatusConstants.SUCCESS_CODE,"成功");
        }
        return buildFailureJson(StatusConstants.ERROR_CODE,"失败");
    }

    /**
     * 更新问题状态
     * @param status
     * @param changeUser
     * @param id
     * @param companyId
     * @return
     */
    @RequestMapping(value = "/updateQuestionStatus", method = RequestMethod.POST)
    @ResponseBody
    public ViewData updateQuestionStatus(@RequestParam("status") Integer status, @RequestParam("changeUser") Integer changeUser,
                                         @RequestParam("id") Long id, @RequestParam("companyId") Long companyId){
        if(CommonUtil.isEmpty(status)||CommonUtil.isEmpty(changeUser)||CommonUtil.isEmpty(id)||CommonUtil.isEmpty(companyId)){
            return buildFailureJson(StatusConstants.PARAMS_IS_NULL,"字段不能为空");
        }
        Integer integer = questionService.updateQuestionStatus(status, changeUser, id, companyId);
        if(integer == 1){
            return buildSuccessCodeJson(StatusConstants.SUCCESS_CODE,"成功");
        }
        return buildFailureJson(StatusConstants.ERROR_CODE,"失败");
    }

    /**
     * 按照公司id查询该公司提交的问题
     * @param request
     * @return
     */
    @RequestMapping(value = "/getQuestionByCompanyId")
    @ResponseBody
    public ViewData getQuestionByCompanyId(HttpServletRequest request){
        CompanyContact companyContact = (CompanyContact)request.getSession().getAttribute("companyContact");
        if(companyContact == null){
            return buildFailureJson(StatusConstants.SESSION_OUT,"会话超时，请重新登录");
        }
        Long companyId = companyContact.getCompanyId();
        return buildSuccessJson(StatusConstants.SUCCESS_CODE,"成功",questionService.getQuestionByCompanyId(companyId));
    }

    /**
     * 按照问题状态查询问题
     * @param status
     * @return
     */
    @RequestMapping(value = "/getQuestionByStatus", method = RequestMethod.POST)
    @ResponseBody
    public ViewData getQuestionByStatus(@RequestParam("status") Integer status){
        if(CommonUtil.isEmpty(status) || status == 0){
            return buildFailureJson(StatusConstants.PARAMS_IS_NULL,"参数不能为空");
        }
        return buildSuccessJson(StatusConstants.SUCCESS_CODE,"成功",questionService.getQuestionByStatus(status));
    }
}
