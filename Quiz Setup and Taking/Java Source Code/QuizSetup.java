package com.example.quizbank;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class QuizSetup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_setup);
        // Error-Checking (Number of Questions <= 0)

    }

    public void returnToQuizList(View v) {
        /* Purpose: Cancel setting up a new quiz and return back to a question bank's quiz list. */
        finish();
    }
}