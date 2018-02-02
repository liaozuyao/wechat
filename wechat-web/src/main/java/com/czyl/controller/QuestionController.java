package com.czyl.controller;

import com.czyl.common.Constants;
import com.czyl.common.StatusConstants;
import com.czyl.dto.QuestionDto;
import com.czyl.entity.Constant;
import com.czyl.entity.EventType;
import com.czyl.entity.Question;
import com.czyl.entity.Selected;
import com.czyl.service.ConstantService;
import com.czyl.service.EventTypeService;
import com.czyl.service.QuestionService;
import com.czyl.service.SelectedService;
import com.czyl.utils.ViewData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by liaozuyao on 2017/12/19.
 */
@Controller
public class QuestionController extends BaseController {

    @Resource
    QuestionService questionService;

    @Resource
    SelectedService selectedService;

    @Resource
    ConstantService constantService;

    @Resource
    EventTypeService eventTypeService;

    private Question questionDetails = null;

    private QuestionDto questionDto = null;

    @RequestMapping(value = "/getAllQuestions", method = RequestMethod.GET)
    @ResponseBody
    public ViewData getAllQuestions(){
        return buildSuccessJson(200,"成功", questionService.getAllQuestions());
    }

    /**
     * 获取问题详细信息
     * @param id
     * @return
     */
    @RequestMapping(value = "/getQuestionDetail", method = RequestMethod.GET)
    @ResponseBody
    public ViewData getQuestionDetail(@RequestParam("id") Long id) {
        questionDetails = questionService.getQuestionDetails(id);
        questionDto = new QuestionDto();
        String fieldName = selectedService.getSelectName(questionDetails.getFieldId()).getName();
        String nodeName = selectedService.getSelectName(questionDetails.getNodeId()).getName();
        String eventName = null;
        String influenceName = null;
        String urgentName = null;
        if(questionDetails.getEventId() != 0){
            eventName = eventTypeService.getName(Long.valueOf(questionDetails.getEventId())).getName();
        }
        System.out.println(questionDetails.getInfluence());
        if(questionDetails.getInfluence() != 0){
            influenceName = constantService.getName(Long.valueOf(questionDetails.getInfluence())).getName();
        }
        if(questionDetails.getUrgent() != 0){
            urgentName = constantService.getName(Long.valueOf(questionDetails.getUrgent())).getName();
        }
        String statusStr = constantService.getQuestionStatus(Long.valueOf(questionDetails.getStatus())).getName();
        questionDto.setId(questionDetails.getId());
        questionDto.setTitle(questionDetails.getTitle());
        questionDto.setField(fieldName);
        questionDto.setNode(nodeName);
        questionDto.setPhone(questionDetails.getPhone());
        questionDto.setEvent(eventName);
        questionDto.setInfluence(influenceName);
        questionDto.setUrgent(urgentName);
        questionDto.setOriginal(questionDetails.getOriginal());
        questionDto.setOriginalMobile(questionDetails.getOriginalMobile());
        questionDto.setOriginalPhone(questionDetails.getOriginalPhone());
        questionDto.setOriginalMail(questionDetails.getOriginalMail());
        questionDto.setFile(questionDetails.getFile());
        questionDto.setDescribe(questionDetails.getDescribe());
        questionDto.setStatus(statusStr);
        questionDto.setStrTime(questionDetails.getStrTime());
        questionDto.setUserId(questionDetails.getUserId()+"");
        return buildSuccessViewData(StatusConstants.SUCCESS_CODE, "成功", questionDetails);
    }

    /**
     * 问题详情页面跳转
     * @return
     */
    @RequestMapping(value = "/questionDetails")
    public ModelAndView getQuestionDetail(){
        ModelAndView mav = new ModelAndView("questionDetail");
        mav.addObject("questionDetails", questionDto);
        return mav;
    }

    @RequestMapping(value = "addQuestion", method = RequestMethod.GET)
    public ModelAndView getField(){
        List<Selected> fields = selectedService.select(0L);
        List<Selected> nodes = selectedService.getNodes(0L);
        List<EventType> eventTypes = eventTypeService.seletAll();
        List<Constant> influence = constantService.getAll(1);
        List<Constant> urgent = constantService.getAll(2);
        ModelAndView mav = new ModelAndView("addQuestion");
        mav.addObject("nodes", nodes);
        mav.addObject("fields", fields);
        mav.addObject("eventType", eventTypes);
        mav.addObject("influence", influence);
        mav.addObject("urgent", urgent);
        return mav;
    }

    /**
     * 按照用户id获取问题
     * @param userId
     * @return
     */
    @RequestMapping(value = "/getQuestionById", method = RequestMethod.GET)
    public ModelAndView getQuestionById(@RequestParam("userId") Long userId) {
        List<Question> questionByUserId = questionService.getQuestionByUserId(userId);
        List<Selected> fielsName = selectedService.select(0L);
        List<Selected> nodeName = selectedService.getNodes(0L);
        List<Constant> status = constantService.getAll(0);
        ModelAndView mav = new ModelAndView("selfQuestion");
        mav.addObject("fielsName",fielsName);
        mav.addObject("nodeName", nodeName);
        mav.addObject("status", status);
        mav.addObject("questionByUserId", questionByUserId);
        System.out.println(questionByUserId.get(1).getStatus());
        return mav;
    }

    @RequestMapping(value = "/insertQuestion", method = RequestMethod.POST)
    @ResponseBody
    public ViewData insertQuestion(@RequestParam("title") String title, @RequestParam("fieldId") Long fieldId,
                                   @RequestParam("nodeId") Long nodeId, @RequestParam("phone") String phone,
                                   @RequestParam("eventId") Integer eventId, @RequestParam("influence") Integer influence,
                                   @RequestParam("urgent") Integer urgent, @RequestParam("original") String original, @RequestParam("originalMobile") String originalMobile,
                                   @RequestParam("originalPhone") String originalPhone, @RequestParam("originalMail") String originalMail,
                                   @RequestParam("file") String file, @RequestParam("describe") String describe,
                                   HttpServletRequest request) {
        if (title == "" || describe == "" || fieldId == 0 || nodeId == 0) {
            return buildFailureJson(StatusConstants.PARAMS_IS_NULL, "必填项不能为空，请重试");
        }
        if(phone != "" || !phone.equals(null)){
            if(!phone.matches(Constants.REGEX_MOBILE)){
                return buildFailureJson(StatusConstants.PARAMS_IS_NULL, "请输入正确的手机格式");
            }
        }
        Question question = new Question();
        question.setTitle(title);
        question.setFieldId(fieldId);
        question.setNodeId(nodeId);
        question.setPhone(phone);
        question.setEventId(eventId);
        question.setInfluence(influence);
        question.setUrgent(urgent);
        question.setOriginal(original);
        question.setOriginalMobile(originalMobile);
        question.setOriginalPhone(originalPhone);
        question.setOriginalMail(originalMail);
        question.setFile(file);
        question.setDescribe(describe);
//        question.setUserId(((User)request.getSession().getAttribute("user")).getId());
        question.setUserId(1L);
        try {
            questionService.insertQuestion(question);
        } catch (Exception e) {
            e.printStackTrace();
            return buildFailureJson(StatusConstants.ERROR_CODE, "失败");
        }
        return buildSuccessCodeJson(StatusConstants.SUCCESS_CODE, "成功");
    }

    /**
     * 模糊查询
     * @return
     */
    @RequestMapping(value = "/getVange", method = RequestMethod.GET)
    @ResponseBody
    public ViewData getVangeQuestion(@RequestParam("vange")String vange){
        return buildSuccessJson(StatusConstants.SUCCESS_CODE,"成功", questionService.getQuestionVague(vange,1L));
    }

    /**
     * 按照领域id查询问题
     * @param fieldId
     * @return
     */
    @RequestMapping(value = "/getQuestionByFieldId", method = RequestMethod.GET)
    @ResponseBody
    public ViewData getByField(@RequestParam("fieldId")Long fieldId){
        List<Question> questionByField = questionService.getQuestionByField(fieldId);
        return buildSuccessViewData(StatusConstants.SUCCESS_CODE,"成功", questionByField);
    }

    /**
     * 按照问题节点查询问题
     * @param nodeId
     * @return
     */
    @RequestMapping(value = "/getQuestionByNodeId", method = RequestMethod.GET)
    @ResponseBody
    public ViewData getByNodeId(@RequestParam("nodeId")Long nodeId){
        return buildSuccessViewData(StatusConstants.SUCCESS_CODE, "成功", questionService.getQuestionByNodeId(nodeId));
    }

    /**
     * 按照状态查询问题
     * @param status
     * @return
     */
    @RequestMapping(value = "/getQuestionByStatus", method = RequestMethod.GET)
    @ResponseBody
    public ViewData getByStatus(@RequestParam("status")Integer status){
        return buildSuccessViewData(StatusConstants.SUCCESS_CODE, "成功", questionService.getQuestionByStatus(status));
    }
}
