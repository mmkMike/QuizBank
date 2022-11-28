package com.example.quizappflashcards;

public class flashcardModel {


    private String front_text;
    private String back_text;

    public flashcardModel(String front_text, String back_text) {
        this.front_text = front_text;
        this.back_text = back_text;
    }
    
    public String getFront_text() {
        return front_text;
    }

    public String getBack_text() {
        return back_text;
    }
}
