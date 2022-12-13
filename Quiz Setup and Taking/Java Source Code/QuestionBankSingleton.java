package com.example.quizbank;

import java.util.ArrayList;

public class QuestionBankSingleton {
    // Singleton Class to Pass QuestionBank Array to All Activities
    private static QuestionBankSingleton instance;
    private ArrayList<QuestionBank> questionBankArrayList = null;
    public static synchronized QuestionBankSingleton getInstance() {
        if (instance == null) {
            instance = new QuestionBankSingleton();
        }
        return instance;
    }
    private QuestionBankSingleton() {
        questionBankArrayList = new ArrayList<QuestionBank>();
    }
    // Retrieve ArrayList from anywhere
    public ArrayList<QuestionBank> getQuestionBankArrayList() {
        return this.questionBankArrayList;
    }
}
