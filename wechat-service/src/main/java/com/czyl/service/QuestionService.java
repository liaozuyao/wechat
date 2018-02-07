package com.czyl.service;

import com.czyl.entity.Question;

import java.util.List;

/**
 * Created by liaozuyao on 2017/12/19.
 */
public interface QuestionService {

    Integer insertQuestion(Question question);

    Integer updateQuestionStatus(Integer status, Integer changeUser, Long id, Long companyId);

    List<Question> getQuestionByCompanyId(Long companyId);

    List<Question> getQuestionByStatus(Integer status);
}
