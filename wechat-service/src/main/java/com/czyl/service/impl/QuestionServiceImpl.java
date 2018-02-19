package com.czyl.service.impl;

import com.czyl.dao.QuestionMapper;
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
}
