package com.example.quizapp_setupquiz;

public class Question {
    // Variables
    private String question;
    private String answer;
    // Constructor(s)
    Question (String q, String a) {
        this.question = q;
        this.answer = a;
    }
    // Setters and Getters
    public void setQuestion(String question) {
        this.question = question;
    }
    public void setAnswer(String answer) {
        this.answer = answer;
    }
    public String getQuestion() {
        return question;
    }
    public String getAnswer() {
        return answer;
    }
}
