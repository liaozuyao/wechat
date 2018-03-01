package com.czyl.service.impl;

import com.czyl.dao.AdviserInfoMapper;
import com.czyl.dao.FieldMapper;
import com.czyl.dao.QuestionMapper;
import com.czyl.dao.UrgentMapper;
import com.czyl.dto.QuestionDto;
import com.czyl.entity.Question;
import com.czyl.service.QuestionService;
import com.czyl.utils.Tools;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService{

    @Resource
    private QuestionMapper questionMapper;

    @Resource
    private FieldMapper fieldMapper;

    @Resource
    private UrgentMapper urgentMapper;

    @Resource
    private AdviserInfoMapper adviserInfoMapper;


    public Integer insertQuestion(String title, Long fieldId, Long urgent, String files, String describe,
                                  String hopeTime, Long companyId, Long adviser) {
        Question question = new Question();
        question.setTitle(title);
        question.setFieldId(fieldId);
        question.setUrgent(urgent);
        question.setFile(files);
        question.setDescribe(describe);
        if(hopeTime.equals(null) || hopeTime == ""){

        } else {
            question.setHopeTime(Tools.StringToDate(hopeTime));
        }
        question.setCompanyId(companyId);
        question.setAdviserId(adviser);
        return questionMapper.insertQuestion(question);
    }

    public Integer updateQuestionStatus(Integer status, Integer changeUser, Long id, Long companyId) {
        return questionMapper.updateQuestionStatus(status, changeUser, id, companyId);
    }

    public List<Question> getQuestionByCompanyId(Long companyId) {
        return questionMapper.getQuestionByCompanyId(companyId);
    }

    public List<Question> getQuestionByStatus(Integer status) {
        return questionMapper.getQuestionByStatus(status);
    }

    public QuestionDto getQuestionByCompanyIdDetail(Long companyId, Long id) {
        Question questionDetial = questionMapper.getQuestionByCompanyIdDetail(companyId, id);
        String fieldName = fieldMapper.getNameById(questionDetial.getFieldId());
        String urgentName = urgentMapper.getNameById(questionDetial.getUrgent());
        String status = null;
        switch (questionDetial.getStatus()){
            case 0:
                status = "提交报修";
                break;
            case 1:
                status = "受理";
                break;
            case 2:
                status = "处理中";
                break;
            case 3:
                status = "问题解决";
                break;
                default:
                    break;
        }
        String adviserName = adviserInfoMapper.getNameById(questionDetial.getAdviserId());
        QuestionDto questionDto = new QuestionDto();
        questionDto.setId(questionDetial.getId());
        questionDto.setTitle(questionDetial.getTitle());
        questionDto.setField(fieldName);
        questionDto.setUrgent(urgentName);
        questionDto.setFile(questionDetial.getFile());
        questionDto.setDescribe(questionDetial.getDescribe());
        questionDto.setStatus(status);
        questionDto.setCreateTime(Tools.dateObjectToString(questionDetial.getCreateTime()));
        questionDto.setHopeTime(Tools.dateObjectToString(questionDetial.getHopeTime()));
        questionDto.setCompanyId(questionDetial.getCompanyId());
        questionDto.setAdviser(adviserName);
        questionDto.setChangeUser(null);
        return questionDto;
    }

    public List<Question> getQuestionByAdviser(Long adviserId) {
        return questionMapper.getQuestionByAdviser(adviserId);
    }
}
