package com.czyl.controller;

import com.czyl.common.StatusConstants;
import com.czyl.dto.QuestionDto;
import com.czyl.entity.CompanyContact;
import com.czyl.entity.Question;
import com.czyl.service.QuestionService;
import com.czyl.utils.CommonUtil;
import com.czyl.utils.ViewData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by liaozuyao on 2017/12/19.
 */
@Controller
@Api(description = "问题相关接口")
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

    @RequestMapping(value = "questionDetail.html")
    public String questionDetail(){
        return "questionDetail";
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
    @RequestMapping(value = "insertQuestion", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "添加问题")
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
    @RequestMapping(value = "updateQuestionStatus", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "更新问题状态")
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
    @RequestMapping(value = "getQuestionByCompanyId")
    @ResponseBody
    @ApiOperation(value = "按照公司获取问题")
    public ViewData getQuestionByCompanyId(HttpServletRequest request) {
        CompanyContact companyContact = (CompanyContact) request.getSession().getAttribute("companyContact");
        if (companyContact == null) {
            return buildFailureJson(StatusConstants.SESSION_OUT, "会话超时，请重新登录");
        }
        Long companyId = companyContact.getCompanyId();
        List<Question> questions = questionService.getQuestionByCompanyId(companyId);
        if (!questions.isEmpty()) {
            return buildSuccessJson(StatusConstants.SUCCESS_CODE, "成功", questions);
        }
        return buildFailureJson(StatusConstants.NO_DATA,"无数据");
    }

    /**
     * 按照问题状态查询问题
     * @param status
     * @return
     */
    @RequestMapping(value = "getQuestionByStatus", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "按照问题状态查询问题")
    public ViewData getQuestionByStatus(@RequestParam("status") Integer status){
        if(CommonUtil.isEmpty(status) || status == 0){
            return buildFailureJson(StatusConstants.PARAMS_IS_NULL,"参数不能为空");
        }
        List<Question> questionByStatus = questionService.getQuestionByStatus(status);
        if(!questionByStatus.isEmpty()) {
            return buildSuccessJson(StatusConstants.SUCCESS_CODE, "成功", questionByStatus);
        }
        return buildFailureJson(StatusConstants.NO_DATA,"无数据");
    }

    /**
     * 问题详情
     * @param id
     * @param request
     * @return
     */
    @RequestMapping(value = "questionDetails")
    @ResponseBody
    @ApiOperation(value = "查看问题详情")
    public ViewData getQuestionByCompanyIdDetail(@RequestParam("id")Long id, HttpServletRequest request,
                                                 Model model){
        CompanyContact companyContact = (CompanyContact)request.getSession().getAttribute("companyContact");
        if(companyContact == null){
            return buildFailureJson(StatusConstants.SESSION_OUT,"会话超时，请重新登录");
        }
        Long companyId = companyContact.getCompanyId();
        QuestionDto questionsDetails = questionService.getQuestionByCompanyIdDetail(companyId, id);
        if(questionsDetails == null){
            return buildFailureJson(StatusConstants.NO_DATA,"无数据");
        }
        model.addAttribute("detail", questionsDetails);
        return buildSuccessJson(StatusConstants.SUCCESS_CODE,"成功", questionsDetails);
    }

    /**
     * 按照顾问id查询问题
     * @param adviserId
     * @return
     */
    @RequestMapping(value = "getQuestionByAdviserId")
    @ResponseBody
    @ApiOperation(value = "按照顾问id查询问题")
    public ViewData getQuestionByAdviserId(@RequestParam("adviserId")Long adviserId){
        if(CommonUtil.isEmpty(adviserId)){
            return buildFailureJson(StatusConstants.PARAMS_IS_NULL,"参数不能为空");
        }
        List<Question> questions = questionService.getQuestionByAdviser(adviserId);
        if(!questions.isEmpty()){
            return buildSuccessJson(StatusConstants.SUCCESS_CODE,"成功", questions);
        }
        return buildFailureJson(StatusConstants.NO_DATA,"无数据");
    }
}
