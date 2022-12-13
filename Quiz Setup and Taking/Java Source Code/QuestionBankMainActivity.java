package com.example.quizbank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class QuestionBankMainActivity extends AppCompatActivity {

    private ArrayList<QuestionBankView> questionBankViewArrayList = new ArrayList<QuestionBankView>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Create singleton variable
        QuestionBankSingleton qbs = QuestionBankSingleton.getInstance();
        // Add any available question banks to questionBankViewArrayList
        for (int i = 0; i < qbs.getQuestionBankArrayList().size(); ++i) {
            questionBankViewArrayList.add(new QuestionBankView(R.drawable.ic_launcher_background, "Question Bank #" + String.valueOf(i+1)));
        }
        // Display available question banks
        QuestionBankViewAdapter questionBankArrayAdapter = new QuestionBankViewAdapter(this, questionBankViewArrayList);
        ListView questionBankListView = findViewById(R.id.questionBankList_ListView);
        questionBankListView.setAdapter(questionBankArrayAdapter);
    }

    @Override
    protected void onRestart() {
        // Refresh view
        finish();
        startActivity(getIntent());
        super.onRestart();
    }

    public void configureQuestionBank(View v) {
        /* Purpose: Configure a new question bank by user. */
        // Navigate to question bank setup screen
        Intent configQuestionBank = new Intent(this, QuestionBankSetupActivity.class);
        startActivity(configQuestionBank);
    }
}