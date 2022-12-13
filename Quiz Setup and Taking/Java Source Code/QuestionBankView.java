package com.example.quizbank;

public class QuestionBankView {
    private int ivQuestionBankImageId;
    private String questionBankName;
    public QuestionBankView(int questionBankId, String questionBankName) {
        this.ivQuestionBankImageId = questionBankId;
        this.questionBankName = questionBankName;
    }
    public int getQuestionBankImageId() {
        return this.ivQuestionBankImageId;
    }
    public String getQuestionBankName() {
        return this.questionBankName;
    }
}
