package com.example.quizbank;

import java.util.ArrayList;

public class Question {
    // Class Variables
    private String question;
    private String answer;
    private ArrayList<String> possibleAnswers;
    // Constructor
    Question() {
        possibleAnswers = new ArrayList<String>();
    }
    /* Non-Constructor Methods */
    // Setters
    public void setQuestion(String q) {
        this.question = q;
    }
    public void setAnswer(String a) {
        this.answer = a;
    }
    // Getters
    public String getQuestion() {
        return this.question;
    }
    public String getAnswer() {
        return this.answer;
    }
    public ArrayList<String> getPossibleAnswers() {
        return this.possibleAnswers;
    }
    // Other
    public void addPossibleAnswer(String possibleAnswer) {
        this.possibleAnswers.add(possibleAnswer);
    }
}
