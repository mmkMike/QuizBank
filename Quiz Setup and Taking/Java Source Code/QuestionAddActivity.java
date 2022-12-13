package com.example.quizbank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class QuestionAddActivity extends AppCompatActivity {

    String question, answer;
    EditText questionET, answerET;
    Question toAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_add);
        // Initialize variables
        question = "";
        answer = "";
        questionET = (EditText) findViewById(R.id.editText_question);
        answerET = (EditText) findViewById(R.id.editText_answer);
        toAdd = new Question();
    }

    public void goToQuestionBankScreenFromQuestionAdd_Save(View v) {
        /* Purpose: Save question and add it to the question bank. Afterwards, go back to the question bank. */
        question = questionET.getText().toString();
        answer = answerET.getText().toString();
        if (question.isEmpty() && answer.isEmpty()) {
            // Case: User did not enter a question or an answer
            // Display toast message
            Context context = getApplicationContext();
            CharSequence text = "Please enter in a question and an answer.";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        } else if (question.isEmpty()) {
            // Case: User did not enter a question
            // Display toast message
            Context context = getApplicationContext();
            CharSequence text = "Please enter in a question.";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        } else if (answer.isEmpty()) {
            // Case: User did not enter an answer
            // Display toast message
            Context context = getApplicationContext();
            CharSequence text = "Please enter in an answer.";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        } else {
            // Set Question variable's question and answer
            toAdd.setQuestion(question);
            toAdd.setAnswer(answer);
            // Add said variable to the global ArrayList
            // DEFAULT - First Question Bank Used (Index 0)
            QuestionBankSingleton.getInstance().getQuestionBankArrayList().get(0).getQuestionBank().add(toAdd);
            // Go back to question bank screen
            finish();
        }
    }

    public void goToQuestionBankScreenFromQuestionAdd_NoSave(View v) {
        /* Purpose: Exit from question addition screen without saving question to question bank. */
        // Reset question and answer variables
        finish();
    }
}