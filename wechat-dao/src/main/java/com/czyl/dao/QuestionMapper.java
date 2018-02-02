package com.czyl.dao;

import com.czyl.entity.Question;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface QuestionMapper {

    Integer insertQuestion(Question question);

    Question getQuestionDetails(Long id);

    List<Question> getQuestionByUserId(Long userId);

    List<Question> getQuestionByField(Long fieldId);

    List<Question> getQuestionByNodeId(Long nodeId);

    List<Question> getQuestionByStatus(Integer status);

    List<Question> getQuestionVague(@Param("vague") String vague, @Param("userId") Long userId);

    List<Question> getAllQuestions();

    Integer countQuestion();
}