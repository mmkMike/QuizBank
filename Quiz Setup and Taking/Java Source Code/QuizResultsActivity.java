package com.example.quizbank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class QuizResultsActivity extends AppCompatActivity {

    TextView numTotalTV, numCorrectTV, percentScoreTV;
    Integer numTotalInt = -1, numCorrectInt = -1;
    Double percentScoreDbl = -1.0;
    String numTotalStr = "N/A", numCorrectStr = "N/A", percentScoreStr = "N/A";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_results);
        // Extract relevant statistics-related information to user from previous intent
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            numTotalInt = extras.getInt("numberOfQuestionsForThisQuiz");
            numCorrectInt = extras.getInt("numberOfQuestionsCorrectForThisQuiz");
            percentScoreDbl = extras.getDouble("percentCorrectForThisQuiz") * 100.0;
            // String Versions
            numTotalStr = String.valueOf(numTotalInt);
            numCorrectStr = String.valueOf(numCorrectInt);
            percentScoreStr = String.valueOf(percentScoreDbl);
        }
        // Initialize TextView variables
        numTotalTV = findViewById(R.id.textView_quizResults_totalNumQuestions);
        numCorrectTV = findViewById(R.id.textView_quizResults_numberQuestionsCorrect);
        percentScoreTV = findViewById(R.id.textView_quizResults_percentScore);
        // Display relevant statistics-related information to user
        numTotalTV.setText(numTotalStr);
        numCorrectTV.setText(numCorrectStr);
        percentScoreTV.setText(percentScoreStr + "%");
    }

    public void exitResults(View v) {
        /* Purpose: Go back to the quiz list screen. */
        Intent goBackToQuizScreenIntent = new Intent(this, QuizListActivity.class);
        goBackToQuizScreenIntent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(goBackToQuizScreenIntent);
    }
}