package com.czyl.controller;

import com.czyl.service.SolveQuestionService;
import com.czyl.utils.ViewData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class SolveQuestionController extends BaseController{

    @Resource
    SolveQuestionService solveQuestionService;

    @RequestMapping(value = "/getAll")
    @ResponseBody
    public ViewData getAllSolveQuestion(){
        return buildSuccessJson(200,"成功", solveQuestionService.getAllQuestions());
    }
}
