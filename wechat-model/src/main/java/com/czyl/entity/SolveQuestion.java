package com.czyl.entity;

public class SolveQuestion {

    private Long adviserId;
    private Long questionId;
    private String useTime;
    private String describe;
    private String enclosure;
    private AdviserInfo adviserInfo;
    private Question question;

    public AdviserInfo getAdviserInfo() {
        return adviserInfo;
    }

    public void setAdviserInfo(AdviserInfo adviserInfo) {
        this.adviserInfo = adviserInfo;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Long getAdviserId() {
        return adviserId;
    }

    public void setAdviserId(Long adviserId) {
        this.adviserId = adviserId;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public String getUseTime() {
        return useTime;
    }

    public void setUseTime(String useTime) {
        this.useTime = useTime;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getEnclosure() {
        return enclosure;
    }

    public void setEnclosure(String enclosure) {
        this.enclosure = enclosure;
    }
}
