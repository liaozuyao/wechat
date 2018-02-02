package com.czyl.controller;

import com.czyl.common.StatusConstants;
import com.czyl.entity.ChangeList;
import com.czyl.entity.Constant;
import com.czyl.service.ChangeListService;
import com.czyl.service.ConstantService;
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
 * Created by liaozuyao on 2017/12/21.
 */
@Controller
public class ChangeListController extends BaseController{

    @Resource
    ConstantService constantService;

    @Resource
    ChangeListService changeListService;

    private ChangeList changeList;

    @RequestMapping(value = "/getAllChangeList",method = RequestMethod.GET)
    @ResponseBody
    public ViewData getAllChangeList(){
        return buildSuccessJson(200,"成功",changeListService.getAllChangeList());
    }

    @RequestMapping(value = "/getChangeListByUserId", method = RequestMethod.GET)
    public ModelAndView getChangeListByUserId(@RequestParam("userId")Long userId){
        ModelAndView mav = new ModelAndView("selfChangeList");
        List<ChangeList> changeListByUserId = changeListService.getChangeListByUserId(userId);
        mav.addObject("changeListByUserId", changeListByUserId);
        return mav;
    }

    @RequestMapping(value = "/insertChangeList", method = RequestMethod.POST)
    @ResponseBody
    public ViewData insertChangeList(@RequestParam("title")String title, @RequestParam("changeItem") Integer changeItem,
                                     @RequestParam("changeClass")Integer changeClass, @RequestParam("companyId")Long companyId,
                                     @RequestParam("changeApplicant") String changeApplicant, @RequestParam("files")String files,
                                     @RequestParam("changeReason")String changeReason, @RequestParam("changeContent")String changeContent,
                                     @RequestParam("userId")Long userId){
        if(title == "" || changeContent == "" || changeClass == 0){
            return buildFailureJson(StatusConstants.PARAMS_IS_NULL, "必填项不能为空，请重试");
        }
        ChangeList changeList = new ChangeList();
        changeList.setTitle(title);
        changeList.setChangeItem(changeItem);
        changeList.setChangeClass(changeClass);
        changeList.setChangeCompany(companyId);
        changeList.setChangeApplicant(changeApplicant);
        changeList.setFile(files);
        changeList.setChangeReason(changeReason);
        changeList.setChangeContent(changeContent);
        changeList.setUserId(userId);
        try {
            changeListService.insertChangeList(changeList);
        } catch (Exception e){
            e.printStackTrace();
            return buildFailureJson(StatusConstants.ERROR_CODE, "失败");
        }
        return buildSuccessCodeJson(StatusConstants.SUCCESS_CODE,"成功");
    }

    @RequestMapping(value = "/addChangeList", method = RequestMethod.GET)
    public ModelAndView addChangeList(HttpServletRequest request){
        List<Constant> changeItem = constantService.getAll(3);
        List<Constant> changeClass = constantService.getAll(4);
        ModelAndView mav = new ModelAndView("addChangeList");
        mav.addObject("changeItem", changeItem);
        mav.addObject("changeClass", changeClass);
        return mav;
    }

    @RequestMapping(value = "/getChangeListDetail", method = RequestMethod.GET)
    @ResponseBody
    public ViewData getChangeListDetail(@RequestParam("id") Long id){
        changeList = changeListService.getChangeListDetail(id);
        return buildSuccessJson(StatusConstants.SUCCESS_CODE, "成功", changeList);
    }

    @RequestMapping(value = "/getChangeListDetails", method = RequestMethod.GET)
    public ModelAndView getChangeListDetail(){
        ModelAndView mav = new ModelAndView("changeListDetail");
        mav.addObject("changeList", changeList);
        return mav;
    }
}
