package com.czyl.controller;

import com.czyl.common.StatusConstants;
import com.czyl.entity.Question;
import com.czyl.service.QuestionService;
import com.czyl.utils.ViewData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
