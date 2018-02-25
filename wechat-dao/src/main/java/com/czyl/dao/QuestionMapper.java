package com.czyl.dao;

import com.czyl.entity.Question;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface QuestionMapper {

    Integer insertQuestion(Question question);

    Integer updateQuestionStatus(@Param("status") Integer status, @Param("changeUser") Integer changeUser, @Param("id") Long id, @Param("companyId") Long companyId);

    List<Question> getQuestionByCompanyId(Long companyId);

    List<Question> getQuestionByStatus(Integer status);

    Question getQuestionByCompanyIdDetail(@Param("companyId") Long companyId, @Param("id")Long id);
}