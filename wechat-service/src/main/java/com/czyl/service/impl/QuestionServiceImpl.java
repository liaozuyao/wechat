package com.czyl.service.impl;

import com.czyl.dao.QuestionMapper;
import com.czyl.entity.Question;
import com.czyl.service.QuestionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService{

    @Resource
    private QuestionMapper questionMapper;

    public Integer insertQuestion(Question question) {
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
