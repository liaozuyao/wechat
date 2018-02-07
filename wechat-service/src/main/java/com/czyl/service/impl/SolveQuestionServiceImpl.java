package com.czyl.service.impl;

import com.czyl.dao.SolveQuestionMapper;
import com.czyl.entity.SolveQuestion;
import com.czyl.service.SolveQuestionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SolveQuestionServiceImpl implements SolveQuestionService{

    @Resource
    SolveQuestionMapper solveQuestionMapper;

    public List<SolveQuestion> getAllQuestions() {
        return solveQuestionMapper.getAllQuestions();
    }
}
