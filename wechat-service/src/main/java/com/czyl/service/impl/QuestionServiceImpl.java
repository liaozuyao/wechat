package com.czyl.service.impl;

import com.czyl.dao.QuestionMapper;
import com.czyl.entity.Question;
import com.czyl.service.QuestionService;
import com.czyl.utils.Tools;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liaozuyao on 2017/12/19.
 */
@Service
public class QuestionServiceImpl implements QuestionService{

    @Resource
    private QuestionMapper questionMapper;

    public Integer insertQuestion(Question question) {
        question.setCreateTime(Tools.dateToString(Tools.getTimeMillis()));
        return questionMapper.insertQuestion(question);
    }

    public Question getQuestionDetails(Long id) {
        Question questionDetails = questionMapper.getQuestionDetails(id);
        questionDetails.setStrTime(Tools.dateObjectToString(questionDetails.getCreateTime()));
        return questionDetails;
    }

    public List<Question> getQuestionByUserId(Long userId) {
        List<Question> questionByUserId = questionMapper.getQuestionByUserId(userId);
        return changeType(questionByUserId);
    }

    private List<Question> changeType(List<Question> questionList){
        List<Question> questions  = new ArrayList<Question>();
        for (Question question : questionList) {
            if(question.getTitle().length() >= 9){
                StringBuilder sb = new StringBuilder();
                sb.append(question.getTitle().substring(0, 5)).append("...");
                question.setTitle(sb.toString());
            }
            question.setStrTime(Tools.dateObjectToString(question.getCreateTime()));
            questions.add(question);
        }
        return questions;
    }

    public List<Question> getQuestionByField(Long fieldId) {
        List<Question> questionByField = questionMapper.getQuestionByField(fieldId);
        return changeType(questionByField);
    }

    public List<Question> getQuestionByNodeId(Long nodeId) {
        return changeType(questionMapper.getQuestionByNodeId(nodeId));
    }

    public List<Question> getQuestionByStatus(Integer status) {
        return changeType(questionMapper.getQuestionByStatus(status));
    }

    public List<Question> getQuestionVague(String vange, Long userId) {
        return changeType(questionMapper.getQuestionVague(vange, userId));
    }

    public List<Question> getAllQuestions() {
        return changeType(questionMapper.getAllQuestions());
    }

    public Integer countQuestion() {
        return questionMapper.countQuestion();
    }
}
