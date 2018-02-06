package com.czyl.dao;

import com.czyl.entity.Question;

import java.util.List;

public interface QuestionMapper {

    Integer insertQuestion(Question question);

    List<Question> getAllQuestion();

    Integer updateQuestionStatus(Long id, Long companyId);
}