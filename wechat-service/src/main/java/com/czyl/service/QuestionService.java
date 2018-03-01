package com.czyl.service;

import com.czyl.dto.QuestionDto;
import com.czyl.entity.Question;

import java.util.List;

/**
 * Created by liaozuyao on 2017/12/19.
 */
public interface QuestionService {

    Integer insertQuestion(String title, Long fieldId, Long urgent, String files, String describe, String hopeTime,
                          Long companyId, Long adviser);

    Integer updateQuestionStatus(Integer status, Integer changeUser, Long id, Long companyId);

    List<Question> getQuestionByCompanyId(Long companyId);

    List<Question> getQuestionByStatus(Integer status);

    QuestionDto getQuestionByCompanyIdDetail(Long companyId, Long id);

    List<Question> getQuestionByAdviser(Long adviserId);
}
