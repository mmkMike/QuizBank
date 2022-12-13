package com.example.quizbank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class QuizTakeActivity extends AppCompatActivity implements View.OnClickListener {

    // Quiz-Related Variables
    Integer currentQuestionIndex = 0;
    Integer numberOfQuestionsCorrect = 0;
    Integer numberOfQuestions;
    Double quizScore;
    ArrayList<Question> questionsForThisQuiz = new ArrayList<Question>();
    Question currentQuestion = null;
    TextView questionTextView;
    Button firstAns, secondAns, thirdAns, fourthAns;
    // Overall Question Bank (DEFAULT - 0 Index)
    ArrayList<Question> overallQuestionBank = QuestionBankSingleton.getInstance().getQuestionBankArrayList().get(0).getQuestionBank();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_take);
        // Generate questions for this quiz
        generateQuestionsForThisQuiz();
        // TextViews and Buttons
        questionTextView = findViewById(R.id.textView_currentQuestion);
        firstAns = findViewById(R.id.button_firstAnswer);
        secondAns = findViewById(R.id.button_secondAnswer);
        thirdAns = findViewById(R.id.button_thirdAnswer);
        fourthAns = findViewById(R.id.button_fourthAnswer);
        // setOnClickListener
        firstAns.setOnClickListener(this);
        secondAns.setOnClickListener(this);
        thirdAns.setOnClickListener(this);
        fourthAns.setOnClickListener(this);
        // Load new question
        loadNewQuestion();
    }

    @Override
    public void onClick(View v) {
        // Error-Checking (Question Not Selected)
        if (currentQuestion == null) {
            Log.d("ERROR: ", "currentQuestion not initialized with randomly-selected question.");
            finish();
        }
        Button clickedButton = (Button) v;
        if (clickedButton.getId() == R.id.button_firstAnswer) {
            if (clickedButton.getText().equals(currentQuestion.getAnswer())) {
                // Case: A is correct
                numberOfQuestionsCorrect++;
                // Reset "currentQuestion" to null to prevent "onClick" from being ran for any of the answer-related buttons
                currentQuestion = null;
                // Refresh screen with new question
                loadNewQuestion();
            } else {
                // Case: A is incorrect
                // Display toast message
                Context context = getApplicationContext();
                CharSequence text = "Incorrect Answer";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
                // Reset "currentQuestion" to null to prevent "onClick" from being ran for any of the answer-related buttons
                currentQuestion = null;
                // Refresh screen with new question
                loadNewQuestion();
            }
        } else if (clickedButton.getId() == R.id.button_secondAnswer) {
            if (clickedButton.getText().equals(currentQuestion.getAnswer())) {
                // Case: B is correct
                numberOfQuestionsCorrect++;
                // Reset "currentQuestion" to null to prevent "onClick" from being ran for any of the answer-related buttons
                currentQuestion = null;
                // Refresh Screen
                loadNewQuestion();
            } else {
                // Case: B is incorrect
                // Display toast message
                Context context = getApplicationContext();
                CharSequence text = "Incorrect Answer";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
                // Reset "currentQuestion" to null to prevent "onClick" from being ran for any of the answer-related buttons
                currentQuestion = null;
                // Refresh screen with new question
                loadNewQuestion();
            }
        } else if (clickedButton.getId() == R.id.button_thirdAnswer) {
            if (clickedButton.getText().equals(currentQuestion.getAnswer())) {
                // Case: C is correct
                numberOfQuestionsCorrect++;
                // Reset "currentQuestion" to null to prevent "onClick" from being ran for any of the answer-related buttons
                currentQuestion = null;
                // Refresh Screen
                loadNewQuestion();
            } else {
                // Case: C is incorrect
                // Display toast message
                Context context = getApplicationContext();
                CharSequence text = "Incorrect Answer";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
                // Reset "currentQuestion" to null to prevent "onClick" from being ran for any of the answer-related buttons
                currentQuestion = null;
                // Refresh screen with new question
                loadNewQuestion();
            }
        } else if (clickedButton.getId() == R.id.button_fourthAnswer) {
            if (clickedButton.getText().equals(currentQuestion.getAnswer())) {
                // Case: D is correct
                numberOfQuestionsCorrect++;
                // Reset "currentQuestion" to null to prevent "onClick" from being ran for any of the answer-related buttons
                currentQuestion = null;
                // Refresh Screen
                loadNewQuestion();
            } else {
                // Case: D is incorrect
                // Display toast message
                Context context = getApplicationContext();
                CharSequence text = "Incorrect Answer";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
                // Reset "currentQuestion" to null to prevent "onClick" from being ran for any of the answer-related buttons
                currentQuestion = null;
                // Refresh screen with new question
                loadNewQuestion();
            }
        }
    }

    public void exitQuiz(View v) {
        /* Purpose: Exit quiz and go to results screen. */
        // DEFAULT - Does not save quiz progress
        Intent quizResultsActivityIntent = new Intent(this, QuizResultsActivity.class);
        startActivity(quizResultsActivityIntent);
    }



    public void generateQuestionsForThisQuiz() {
        /* Purpose: Generate random number of questions for quiz. */
        Integer min = 0;
        Integer max = overallQuestionBank.size();
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            numberOfQuestions = extras.getInt("numberOfQuestionsForCurrentQuiz");
            // Generate questions
            for (int i = 0; i < numberOfQuestions; ++i) {
                Integer randomlyGeneratedIndex = (int) ((Math.random() * (max - min)) + min);
                Question randomlyGeneratedQuestion = overallQuestionBank.get(randomlyGeneratedIndex);
                // Check if currently generated question is already in questionsForThisQuiz
                while (questionsForThisQuiz.contains(randomlyGeneratedQuestion)) {
                    // Keep randomly generating a new question until one that does not exist in questionsForThisQuiz is found
                    randomlyGeneratedIndex = (int) ((Math.random() * (max - min)) + min);
                    randomlyGeneratedQuestion = overallQuestionBank.get(randomlyGeneratedIndex);
                }
                // After a unique question-answer pair has been found, add it to questionsForThisQuiz
                questionsForThisQuiz.add(randomlyGeneratedQuestion);
            }
        } else {
            // Case: Could not retrieve number of questions from QuizSetupActivity.java
            Log.d("ERROR: ", "Could not retrieve number of questions from QuizSetupActivity.java");
            // Return to previous activity
            finish();
        }
    }

    public void loadNewQuestion() {
        /* Update quiz taking display with new question and potential answers. */
        if (currentQuestionIndex == numberOfQuestions) {
            // Case: User answered all of the questions in the quiz
            // Set score
            quizScore = Double.valueOf(numberOfQuestionsCorrect) / Double.valueOf(numberOfQuestions);
            // Move onto results screen and pass relevant data
            Intent goToQuizResults = new Intent(this, QuizResultsActivity.class);
            goToQuizResults.putExtra("numberOfQuestionsForThisQuiz", numberOfQuestions);
            goToQuizResults.putExtra("numberOfQuestionsCorrectForThisQuiz", numberOfQuestionsCorrect);
            goToQuizResults.putExtra("percentCorrectForThisQuiz", quizScore);
            startActivity(goToQuizResults);
            // Go back to previous intent
            return;
        }
        // Generate 3 random answers + 1 correct answer for "currentQuestion"
        currentQuestion = questionsForThisQuiz.get(currentQuestionIndex++);
        Integer min = 0;
        Integer max = overallQuestionBank.size();
        for (int j = 0; j < 3; ++j) {
            Integer randomlyGeneratedIndex = (int) ((Math.random() * (max - min)) + min);
            Question randomQuestion = overallQuestionBank.get(randomlyGeneratedIndex);
            String answerFromRandomQuestion = randomQuestion.getAnswer();
            // Keep randomly picking answers from question bank until a unique answer is found
            while (currentQuestion.getPossibleAnswers().contains(answerFromRandomQuestion) || (answerFromRandomQuestion == currentQuestion.getAnswer())) {
                // Randomly pick another answer
                randomlyGeneratedIndex = (int) ((Math.random() * (max - min)) + min);
                randomQuestion = overallQuestionBank.get(randomlyGeneratedIndex);
                answerFromRandomQuestion = randomQuestion.getAnswer();
            }
            // Add unique answer to "currentQuestion.getPossibleAnswers()"
            currentQuestion.addPossibleAnswer(randomQuestion.getAnswer());
        }
        // Add correct answer to "currentQuestion"
        currentQuestion.addPossibleAnswer(currentQuestion.getAnswer());
        // Randomize "currentQuestion.getPossibleAnswers()" ArrayList ten times to get a different order of answers each time
        for (int j = 0; j < 10; ++j) {
            Collections.shuffle(currentQuestion.getPossibleAnswers());
        }
        // TextView
        questionTextView.setText(currentQuestion.getQuestion());
        firstAns.setText(currentQuestion.getPossibleAnswers().get(0));
        secondAns.setText(currentQuestion.getPossibleAnswers().get(1));
        thirdAns.setText(currentQuestion.getPossibleAnswers().get(2));
        fourthAns.setText(currentQuestion.getPossibleAnswers().get(3));
    }
}