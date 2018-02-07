package com.czyl.controller;

import com.czyl.common.StatusConstants;
import com.czyl.entity.Question;
import com.czyl.service.QuestionService;
import com.czyl.utils.ViewData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Created by liaozuyao on 2017/12/19.
 */
@Controller
public class QuestionController extends BaseController {

    @Resource
    QuestionService questionService;

    @RequestMapping(value = "/insertQuestion", method = RequestMethod.POST)
    @ResponseBody
    public ViewData insertQuestion(@RequestBody Question question){
        Integer status = questionService.insertQuestion(question);
        if(status == 1){
            return buildSuccessCodeJson(StatusConstants.SUCCESS_CODE,"成功");
        }
        return buildFailureJson(StatusConstants.ERROR_CODE,"失败");
    }

    @RequestMapping(value = "/updateQuestionStatus", method = RequestMethod.POST)
    @ResponseBody
    public ViewData updateQuestionStatus(@RequestParam("status") Integer status, @RequestParam("changeUser") Integer changeUser,
                                         @RequestParam("id") Long id, @RequestParam("companyId") Long companyId){
        Integer integer = questionService.updateQuestionStatus(status, changeUser, id, companyId);
        if(integer == 1){
            return buildSuccessCodeJson(StatusConstants.SUCCESS_CODE,"成功");
        }
        return buildFailureJson(StatusConstants.ERROR_CODE,"失败");
    }

    @RequestMapping(value = "/getQuestionByCompanyId" ,method = RequestMethod.POST)
    @ResponseBody
    public ViewData getQuestionByCompanyId(@RequestParam("companyId")Long companyId){
        if(companyId.equals(null) || companyId == 0){
            return buildFailureJson(StatusConstants.PARAMS_IS_NULL,"参数不能为空");
        }
        return buildSuccessJson(StatusConstants.SUCCESS_CODE,"成功",questionService.getQuestionByCompanyId(companyId));
    }

    @RequestMapping(value = "/getQuestionByStatus", method = RequestMethod.POST)
    @ResponseBody
    public ViewData getQuestionByStatus(@RequestParam("status") Integer status){
        if(status.equals(null) || status == 0){
            return buildFailureJson(StatusConstants.PARAMS_IS_NULL,"参数不能为空");
        }
        return buildSuccessJson(StatusConstants.SUCCESS_CODE,"成功",questionService.getQuestionByStatus(status));
    }
}
