package com.czyl.service;

import com.czyl.entity.Question;

import java.util.List;

/**
 * Created by liaozuyao on 2017/12/19.
 */
public interface QuestionService {

    Integer insertQuestion(Question question);

    Question getQuestionDetails(Long id);

    List<Question> getQuestionByUserId(Long userId);

    List<Question> getQuestionByField(Long fieldId);

    List<Question> getQuestionByNodeId(Long nodeId);

    List<Question> getQuestionByStatus(Integer status);

    List<Question> getQuestionVague(String id, Long userId);

    List<Question> getAllQuestions();

    Integer countQuestion();
}
