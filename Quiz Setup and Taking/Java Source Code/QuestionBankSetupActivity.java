package com.example.quizbank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class QuestionBankSetupActivity extends AppCompatActivity {

    // QuestionBank that will be added to "questionBankList"
    private QuestionBank questionBank;
    // Array of QuestionView
    private ArrayList<QuestionView> questionViewArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_bank_setup);
        // Initialize questionBank
        questionBank = new QuestionBank();
        // Save to global ArrayList of QuestionBank
        QuestionBankSingleton.getInstance().getQuestionBankArrayList().add(questionBank);
        // Initialize questionViewArrayList
        questionViewArrayList = new ArrayList<QuestionView>();
        // Add any questions or answers from questionBank
        // DEFAULT - First question bank is used (at index "0")
        for (int i = 0; i < QuestionBankSingleton.getInstance().getQuestionBankArrayList().get(0).getQuestionBank().size(); ++i) {
            questionViewArrayList.add(new QuestionView(QuestionBankSingleton.getInstance().getQuestionBankArrayList().get(0).getQuestionBank().get(i).getQuestion(), QuestionBankSingleton.getInstance().getQuestionBankArrayList().get(0).getQuestionBank().get(i).getAnswer()));
        }
        // Display any available questions
        QuestionViewAdapter questionArrayAdapter = new QuestionViewAdapter(this, questionViewArrayList);
        ListView questionListView = findViewById(R.id.listView_questionList);
        questionListView.setAdapter(questionArrayAdapter);
    }

    @Override
    protected void onRestart() {
        // Refresh view
        finish();
        startActivity(getIntent());
        super.onRestart();
    }

    public void goHomeFromQuestionBankMenu(View v) {
        /* Purpose: Go back to the main menu of the app. */
        // Ask if user wants to save question bank
        // DEFAULT - Save questionBank by default
        finish();
    }

    public void addQuestion(View v) {
        /* Purpose: Add a new question to this question bank. */
        // Navigate to question add screen
        Intent questionAdd = new Intent(this, QuestionAddActivity.class);
        startActivity(questionAdd);
    }

    public void quizList(View v) {
        /* Purpose: Access the quiz list for this particular question bank. */
        // Navigate to quiz menu
        // Error-Checking (Not Enough Questions Added [Either 0 or < 4 Were Added])
        // DEFAULT - Uses first question bank
        if (QuestionBankSingleton.getInstance().getQuestionBankArrayList().get(0).getQuestionBank().isEmpty() || (QuestionBankSingleton.getInstance().getQuestionBankArrayList().get(0).getQuestionBank().size() < 4)) {
            Context context = getApplicationContext();
            CharSequence text = "Please add in at least four (4) questions.";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        } else {
            Intent quizList = new Intent(this, QuizListActivity.class);
            startActivity(quizList);
        }
    }
}