package com.example.quizbank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class QuizSetupActivity extends AppCompatActivity {

    Integer numberOfQuestions;
    EditText numberOfQuestionsET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_setup);
    }

    public void returnToQuizList(View v) {
        /* Purpose: Cancel setting up a new quiz and return back to a question bank's quiz list. */
        finish();
    }

    public void startQuiz(View v) {
        /* Purpose: Start quiz using specifications given by user. */
        numberOfQuestionsET = (EditText) findViewById(R.id.editText_questionCount);
        // Error-Checking
        if (numberOfQuestionsET.getText().toString().equals("")) {
            // Case: Blank Input Field
            // Display toast message
            Context context = getApplicationContext();
            CharSequence text = "Please type in a value for the number of questions.";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        } else {
            // Case: A number exists in the input field
            numberOfQuestions = Integer.valueOf(numberOfQuestionsET.getText().toString());
            // Error-Checking
            if (numberOfQuestions <= 0) {
                // Case: Number of Questions <= 0
                // Display toast message
                Context context = getApplicationContext();
                CharSequence text = "Please type in a positive number of questions.";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            } else {
                // Start quiz
                Intent startQuizIntent = new Intent(this, QuizTakeActivity.class);
                startQuizIntent.putExtra("numberOfQuestionsForCurrentQuiz", numberOfQuestions);
                startActivity(startQuizIntent);
                // Go back to quiz list screen
                finish();
            }
        }
    }
}