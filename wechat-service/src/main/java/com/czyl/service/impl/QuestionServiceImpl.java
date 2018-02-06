package com.czyl.service.impl;

import com.czyl.dao.QuestionMapper;
import com.czyl.entity.Question;
import com.czyl.service.QuestionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class QuestionServiceImpl implements QuestionService{

    @Resource
    QuestionMapper questionMapper;

    public Integer insertQuestion(Question question) {
        return questionMapper.insertQuestion(question);
    }
}
