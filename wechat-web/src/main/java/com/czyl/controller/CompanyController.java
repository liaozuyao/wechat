package com.czyl.controller;

import com.czyl.common.Constants;
import com.czyl.common.StatusConstants;
import com.czyl.entity.CompanyContact;
import com.czyl.service.CompanyModelBeanService;
import com.czyl.service.CompanyModelService;
import com.czyl.service.CompanyService;
import com.czyl.utils.CommonUtil;
import com.czyl.utils.ViewData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by liaozuyao on 2018/1/3.
 */
@Controller
public class CompanyController extends BaseController {

    @Resource
    private CompanyService companyService;

    @Resource
    private CompanyModelBeanService companyModelBeanService;

    @Resource
    private CompanyModelService companyModelService;

    @RequestMapping(value = "/allCompany")
    @ResponseBody
    public ViewData getAllCompany(){
        return buildSuccessJson(StatusConstants.SUCCESS_CODE,"成功", companyService.selectCompany());
    }

    /**
     * 管理员添加公司
     * @param name
     * @param request
     * @return
     */
    @RequestMapping(value = "/insertCompany", method = RequestMethod.POST)
    @ResponseBody
    public ViewData insertCompany(@RequestParam("name") String name, HttpServletRequest request) {
        if (CommonUtil.isEmpty(name)) {
            return buildFailureJson(StatusConstants.PARAMS_IS_NULL, "字段不能为空");
        }
        Integer i = companyService.insertCompany(name);
        if (i == 1) {
            return buildSuccessCodeJson(StatusConstants.SUCCESS_CODE, "成功");
        } else {
            return buildFailureJson(StatusConstants.ERROR_CODE, "失败");
        }
    }

    @RequestMapping(value = "/insertCompany.html")
    public String insertCompanyModel() {
        return "admin/addCompany";
    }

    @RequestMapping(value = "/allCompany.html")
    public String allCompany(){
        return "admin/allCompany";
    }

    @RequestMapping(value = "/updateCompany.html")
    public String updateCompanyModel(HttpServletRequest request, Model model) {
        Long companyId = ((CompanyContact) request.getSession().getAttribute("companyContact")).getCompanyId();
        model.addAttribute("company", companyService.selectCompanyById(companyId));
        return "updateCompany";
    }

    /**
     * 修改完善公司信息
     * @param code
     * @param name
     * @param contactPhone
     * @param contactMail
     * @param request
     * @return
     */
    @RequestMapping(value = "/updateComanyInfo", method = RequestMethod.POST)
    @ResponseBody
    public ViewData updateCompany(@RequestParam("code") String code, @RequestParam("name") String name, @RequestParam("contactPhone") String contactPhone,
                                  @RequestParam("contactMail") String contactMail, HttpServletRequest request) {
        if(CommonUtil.isEmpty(code) || CommonUtil.isEmpty(name) || CommonUtil.isEmpty(contactMail) || CommonUtil.isEmpty(contactPhone)){
            return buildFailureJson(StatusConstants.PARAMS_IS_NULL, "必填字段不能为空");
        }
        if(!contactMail.matches(Constants.REGEX_EMAIL)){
            return buildFailureJson(StatusConstants.PARAMS_IS_NULL, "邮箱格式不正确");
        }
        CompanyContact companyContact = (CompanyContact) request.getSession().getAttribute("companyContact");
        if(companyContact == null){
            return buildFailureJson(StatusConstants.SESSION_OUT,"会话超时，请重新登录");
        }
        Long id = companyContact.getCompanyId();
        Integer i = companyService.updateCompany(code, name, contactPhone, contactMail, id);
        if (i == 1) {
            return buildSuccessCodeJson(StatusConstants.SUCCESS_CODE, "成功");
        } else {
            return buildFailureJson(StatusConstants.ERROR_CODE, "失败");
        }
    }

    @RequestMapping(value = "/selectCompanys")
    @ResponseBody
    public ViewData selectCompanys() {
        return buildSuccessJson(StatusConstants.SUCCESS_CODE, "成功", companyModelBeanService.selectAllCompany());
    }

    /**
     * 按照公司id查询公司信息
     * @param id
     * @return
     */
    @RequestMapping(value = "/selectCompanyById")
    @ResponseBody
    public ViewData selectCompanyById(@RequestParam("id") Long id) {
        if (CommonUtil.isEmpty(id)) {
            return buildFailureJson(StatusConstants.PARAMS_IS_NULL, "必填字段不能为空");
        }
        return buildSuccessJson(StatusConstants.SUCCESS_CODE, "成功", companyModelBeanService.selectByCompanyId(id));
    }

    /**
     * 添加公司对应服务模块
     * @param companyId
     * @param serviceId
     * @param enslosure
     * @return
     */
    @RequestMapping(value = "/insertCompanyModel", method = RequestMethod.POST)
    @ResponseBody
    public ViewData insertCompanyModel(@RequestParam("companyId") Long companyId, @RequestParam("serviceId") Long serviceId,
                                       @RequestParam("enclosure") String enslosure) {
        if (CommonUtil.isEmpty(companyId) || CommonUtil.isEmpty(serviceId) || CommonUtil.isEmpty(enslosure)) {
            return buildFailureJson(StatusConstants.PARAMS_IS_NULL, "字段不能为空");
        }
        Integer integer = companyModelService.insertCompanyModel(companyId, serviceId, enslosure);
        if (integer == 1) {
            return buildSuccessCodeJson(StatusConstants.SUCCESS_CODE, "成功");
        }
        return buildFailureJson(StatusConstants.ERROR_CODE, "失败");
    }
}
