package com.example.quizbank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.lang.Math;

public class Quiz extends AppCompatActivity {
    // Public Class Variables
    public ArrayList<Question> questionBank;
    public ArrayList<Question> currentSetOfQuestionsForMC;
    // Private Class Variables
    private Integer numberOfQuestions;
    private String fontName;
    private Integer fontSize;
    private Double score;
    private Integer numQuestionsCorrect;
    private Integer numberOfQuizzesForQuestionBank;
    private Boolean quizHasBeenStarted;
    // Constructor(s)
    Quiz(ArrayList<Question> questionBankToUse, Integer numberOfQuizzesForQuestionBank) {
        this.questionBank = questionBankToUse;
        this.numberOfQuizzesForQuestionBank = numberOfQuizzesForQuestionBank;
        // Default Values for Score-Related Variables
        this.score = -1.0;
        this.numQuestionsCorrect = 1;
        this.quizHasBeenStarted = false;
    }
    // Methods
    public void setupQuiz() {
        /* Purpose: Randomly generate quiz questions based on how many the user wants. */
        Context context = getApplicationContext();
        CharSequence errorMessage;
        int duration = Toast.LENGTH_SHORT;
        Toast toast;
        // Error-Checking (2 quizzes from this quiz's question bank have already been created)
        if (this.numberOfQuizzesForQuestionBank == 2) {
            errorMessage = "Error: Maximum number of quizzes for this question bank (2) have already been created.";
            toast = Toast.makeText(context, errorMessage, duration);
            toast.show();
            return;
        }
        // Error-Checking (questionBank is empty)
        if (questionBank.isEmpty()) {
            errorMessage = "Error: No questions found.\nPlease add some to the question bank and try again.";
            toast = Toast.makeText(context, errorMessage, duration);
            toast.show();
            return;
        }
        // Error-Checking (questionBank does not have enough questions - aka it only has 1-3 of them)
        if ((questionBank.size() < 4) && (questionBank.size() > 0)) {
            errorMessage = "Error: Question bank does not have more than 4 questions.\nPlease add more and try again.";
            toast = Toast.makeText(context, errorMessage, duration);
            toast.show();
            return;
        }
        // Ask user for number of questions
        String numberOfQuestionsString = "How many questions do you want in this quiz?";
        TextView numberOfQuestionsTextView = (TextView) findViewById(R.id.numberQuestionsTextView);
        numberOfQuestionsTextView.setText(numberOfQuestionsString);
        Integer tempNumberOfQuestions;
        EditText numberOfQuestionsEditText = (EditText) findViewById(R.id.numberQuestionsEditText);
        tempNumberOfQuestions = Integer.valueOf(numberOfQuestionsEditText.getText().toString());
        // Error-Checking (tempNumberOfQuestions is <= 0)
        while (tempNumberOfQuestions <= 0) {
            errorMessage = "Error: Invalid number of questions. Please try again.";
            toast = Toast.makeText(context, errorMessage, duration);
            toast.show();
            tempNumberOfQuestions = Integer.valueOf(numberOfQuestionsEditText.getText().toString());
        }
        // Set this instance's numberOfQuestions
        this.numberOfQuestions = tempNumberOfQuestions;
        // Randomly generate question-answer pairs for this quiz's own "questionBank" (duplicates get skipped)
        Integer min = 0;
        Integer max = questionBank.size();
        for (int i = 0; i < this.numberOfQuestions; ++i) {
            Integer randomlyGeneratedIndex = (int) ((Math.random() * (max - min)) + min);
            Question randomlyGeneratedQuestion = this.questionBank.get(randomlyGeneratedIndex);
            // Check if currently generated question is already in currentSetOfQuestionsForMC
            while (this.currentSetOfQuestionsForMC.contains(randomlyGeneratedQuestion)) {
                // Keep randomly generating a new question until one that does not exist in currentSetOfQuestionsForMC is found
                randomlyGeneratedIndex = (int) ((Math.random() * (max - min)) + min);
                randomlyGeneratedQuestion = this.questionBank.get(randomlyGeneratedIndex);
            }
            // After a unique question-answer pair has been found, add it to currentSetOfQuestionsForMC
            this.currentSetOfQuestionsForMC.add(randomlyGeneratedQuestion);
        }
    }
    public void startQuiz() {
        /* Purpose: To start the actual multiple-choice quiz for the user. */
        Context context = getApplicationContext();
        CharSequence errorMessage;
        int duration = Toast.LENGTH_SHORT;
        Toast toast;
        // Error-Checking (currentSetOfQuestionsForMC is empty)
        if (this.currentSetOfQuestionsForMC.isEmpty()) {
            errorMessage = "Error: Questions for this quiz have not been selected yet.";
            toast = Toast.makeText(context, errorMessage, duration);
            toast.show();
            return;
        }
        // Error-Checking (Quiz has already been started)
        if (this.quizHasBeenStarted == true) {
            errorMessage = "Quiz has already been started.\nResuming from last question.";
            toast = Toast.makeText(context, errorMessage, duration);
            toast.show();
            // Insert code here to resume quiz progress
        }
        // Start Quiz
        this.quizHasBeenStarted = true;
        for (int i = 0; i < this.numberOfQuestions; ++i) {
            Question currentQuestion = this.currentSetOfQuestionsForMC.get(i);
            // Display question in app
            TextView currentQuestionTextView = (TextView) findViewById(R.id.currentQuestion);
            currentQuestionTextView.setText(currentQuestion.getQuestion());
            // Display four possible multiple-choice answer (including one correct one)
            ArrayList<String> possibleAnswers = this.randomlySelectAnswers(currentQuestion);
            /* Create a button for each answer and display them all to the user */
            // First Answer (A) Button
            Button aButton = findViewById(R.id.firstAnswer);
            aButton.setText(possibleAnswers.get(0));
            // Second Answer (B) Button
            Button bButton = findViewById(R.id.secondAnswer);
            bButton.setText(possibleAnswers.get(1));
            // Third Answer (C) Button
            Button cButton = findViewById(R.id.thirdAnswer);
            cButton.setText(possibleAnswers.get(2));
            // Fourth Answer (D) Button
            Button dButton = findViewById(R.id.fourthAnswer);
            dButton.setText(possibleAnswers.get(3));
            // Quit Button
            Button quitButton = findViewById(R.id.quitButton);
            quitButton.setText("Quit Quiz");
            if (aButton.isPressed()) {
                // Case: The first answer (A) has been selected.
                if (aButton.getText().toString() == currentQuestion.getAnswer()) {
                    // Correct Answer
                    this.numQuestionsCorrect++;
                } else {
                    // Incorrect Answer
                    // Display message in app that answer selected is incorrect and move on to next question
                }
            } else if (bButton.isPressed()) {
                // Case: The second answer (B) has been selected.
                if (bButton.getText().toString() == currentQuestion.getAnswer()) {
                    // Correct Answer
                    this.numQuestionsCorrect++;
                } else {
                    // Incorrect Answer
                    // Display message in app that answer selected is incorrect and move on to next question
                }
            } else if (cButton.isPressed()) {
                // Case: The third answer (C) has been selected.
                if (cButton.getText().toString() == currentQuestion.getAnswer()) {
                    // Correct Answer
                    this.numQuestionsCorrect++;
                } else {
                    // Incorrect Answer
                    // Display message in app that answer selected is incorrect and move on to next question
                }
            } else if (dButton.isPressed()) {
                // Case: The fourth answer (D) has been selected.
                if (dButton.getText().toString() == currentQuestion.getAnswer()) {
                    // Correct Answer
                    this.numQuestionsCorrect++;
                } else {
                    // Incorrect Answer
                    // Display message in app that answer selected is incorrect and move on to next question
                }
            } else if (quitButton.isPressed()) {
                // Case: The user wants to exit/quit the quiz.
                // Add prompts to save/not save current quiz
                // Afterwards, exit from the for loop containing the currently running quiz
            }
        }
        // When quiz is finished, show results/statistics
        this.showResultsStatistics();
        // Set quizHasBeenStarted to false after quiz is done
        this.quizHasBeenStarted = false;
    }
    private ArrayList<String> randomlySelectAnswers(Question currentQuestion) {
        /* Purpose: Act as a helper function to randomly select three incorrect answers for a particular question as well as the correct answer. */
        // Error-Checking (Quiz Hasn't Started Yet)
        if (this.quizHasBeenStarted == false) {
            // Essentially, startQuiz() will have to have been called already before this method can be used
            System.out.println("Error: Quiz has not been started yet.");
            return null;
        }
        ArrayList<String> ret = new ArrayList<String>();    // This ArrayList contains the four possible answers that will be shown to the user in the app for a particular question
        // Randomly pick three incorrect answers from overall question bank
        Integer min = 0;
        Integer max = questionBank.size();
        for (int j = 0; j < 3; ++j) {
            Integer randomlyGeneratedIndex = (int) ((Math.random() * (max - min)) + min);
            Question randomQuestion = this.questionBank.get(randomlyGeneratedIndex);
            String answerFromRandomQuestion = randomQuestion.getAnswer();
            // Keep randomly picking answers from question bank until a unique answer is found
            while (ret.contains(answerFromRandomQuestion)) {
                // Continue while loop if the current question's answer was generated
                if (answerFromRandomQuestion == currentQuestion.getAnswer()) {
                    continue;
                }
                // Randomly pick another answer
                randomlyGeneratedIndex = (int) ((Math.random() * (max - min)) + min);
                randomQuestion = this.questionBank.get(randomlyGeneratedIndex);
                answerFromRandomQuestion = randomQuestion.getAnswer();
            }
            // Add unique answer to "ret"
            ret.add(randomQuestion.getAnswer());
        }
        // Add correct answer to "ret"
        ret.add(currentQuestion.getAnswer());
        // Randomize "ret" ArrayList ten times to get a different order of answers each time
        for (int j = 0; j < 10; ++j) {
            Collections.shuffle(ret);
        }
        // Return possible answers for a particular question
        return ret;
    }
    public void changeDisplaySettings() {
        /* Purpose: Allow the user to change the font name, font size, and app theme during the taking of a quiz. */
    }
    public void showResultsStatistics() {
        /* Purpose: Display results of an quiz to the user. */
        // Error-Checking (Either "score" or "numQuestionsCorrect" still has a default value of -1.0 or -1 respectively)
        if (this.score == -1.0 || this.numQuestionsCorrect == -1) {
            System.out.println("Error: This quiz has not been taken yet.");
            return;
        }
        // Display Score
        setContentView(R.layout.quiz_results_statistics_view);
        TextView scorePercentageTextView = (TextView) findViewById(R.id.scorePercentage);
        scorePercentageTextView.setText(String.valueOf(this.score) + "%");
        // Display Fraction
        // Number of Questions Correct
        TextView numberQuestionsCorrectTextView = (TextView) findViewById(R.id.numberQuestionsCorrect);
        numberQuestionsCorrectTextView.setText(String.valueOf(this.numQuestionsCorrect));
        // Number of Questions Incorrect
        TextView numberQuestionsIncorrectTextView = (TextView) findViewById(R.id.numberQuestionsIncorrect);
        numberQuestionsIncorrectTextView.setText(String.valueOf((this.numberOfQuestions - this.numQuestionsCorrect)));
    }
    public void setFontName(String fontNameToAdd) {
        this.fontName = fontNameToAdd;
    }
    public String getFontName() {
        return fontName;
    }
}
