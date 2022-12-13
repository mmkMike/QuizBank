package com.example.quizbank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class QuizListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_list);
    }

    public void setupQuiz(View v) {
        /* Purpose: Set up quiz. */
        // Error-Checking (Empty Question Bank)

        // Error-Checking (More Than 3 Quizzes)

        // Navigate to quiz setup menu
        Intent setupQuiz = new Intent(this, QuizSetupActivity.class);
        startActivity(setupQuiz);
    }

    public void goBackToQuestionBank(View v) {
        /* Purpose: Go back to question bank. */
        finish();
    }
}