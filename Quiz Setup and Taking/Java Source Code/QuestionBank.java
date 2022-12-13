package com.example.quizbank;

import java.util.ArrayList;

public class QuestionBank {
    // Class Variables
    private String questionBankName;
    public ArrayList<Question> questionBank;
    public ArrayList<Quiz> quizzesForThisQuestionBank;
    private Integer totalAmount;
    private static Integer numberOfQuizzesForQuestionBank = 0;
    // Constructor
    QuestionBank() {
        totalAmount = 0;
        this.questionBank = new ArrayList<Question>();
    }
    // Methods
    public void importQuestions() {

    }
    public void addQuestion(Question q) {
        questionBank.add(q);
    }
    public void removeQuestion() {

    }
    public void editQuestion() {

    }
    // Getters
    public ArrayList<Question> getQuestionBank() {
        return questionBank;
    }
    public String getQuestionBankName() {
        return this.questionBankName;
    }
}