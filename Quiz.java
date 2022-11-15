package com.example.quizbank;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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
    // Constructor(s)
    Quiz(ArrayList<Question> questionBankToUse, Integer numberOfQuizzesForQuestionBank) {
        this.questionBank = questionBankToUse;
        this.numberOfQuizzesForQuestionBank = numberOfQuizzesForQuestionBank;
        // Default Values for Score-Related Variables
        this.score = -1.0;
        this.numQuestionsCorrect = 1;
    }
    // Methods
    public void setupQuiz() {
        /* Purpose: Randomly generate quiz questions based on how many the user wants. */
        // Error-Checking (2 quizzes from this quiz's question bank have already been created)
        if (this.numberOfQuizzesForQuestionBank == 2) {
            System.out.println("Error: Maximum number of quizzes for this question bank (2) have already been created.");
            return;
        }
        // Error-Checking (questionBank is empty)
        if (questionBank.isEmpty()) {
            System.out.println("Error: No questions found.\nPlease add some to the question bank and try again.");
            return;
        }
        // Error-Checking (questionBank does not have enough questions - aka it only has 1-3 of them)
        if ((questionBank.size() < 4) && (questionBank.size() > 0)) {
            System.out.println("Error: Question bank does not have more than 4 questions.\nPlease add more and try again.");
            return;
        }
        // Ask user for number of questions
        System.out.print("How many questions do you want in this quiz? ");
        Integer tempNumberOfQuestions;
        Scanner scan = new Scanner(System.in);
        tempNumberOfQuestions = Integer.valueOf(scan.nextLine());
        // Error-Checking (tempNumberOfQuestions is <= 0)
        while (tempNumberOfQuestions <= 0) {
            System.out.println("\nError: Invalid number of questions. Please try again.\n");
            System.out.print("How many questions do you want in this quiz? ");
            tempNumberOfQuestions = Integer.valueOf(scan.nextLine());
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
        // Error-Checking (currentSetOfQuestionsForMC is empty)
        if (this.currentSetOfQuestionsForMC.isEmpty()) {
            System.out.println("Error: Questions for this quiz have not been selected yet.");
            return;
        }
        // Start Quiz
        for (int i = 0; i < this.numberOfQuestions; ++i) {
            Question currentQuestion = this.currentSetOfQuestionsForMC.get(i);
            // Display question in app
            TextView currentQuestionTextView = (TextView) findViewById(R.id.currentQuestion);
            currentQuestionTextView.setText(currentQuestion.getQuestion());
            // Display four possible multiple-choice answer (including one correct one)
            ArrayList<String> possibleAnswers = new ArrayList<String>();    // This ArrayList contains the four possible answers that will be shown to the user in the app for a particular question
            // Randomly pick three incorrect answers from overall question bank
            Integer min = 0;
            Integer max = questionBank.size();
            for (int j = 0; j < 3; ++j) {
                Integer randomlyGeneratedIndex = (int) ((Math.random() * (max - min)) + min);
                Question randomQuestion = this.questionBank.get(randomlyGeneratedIndex);
                String answerFromRandomQuestion = randomQuestion.getAnswer();
                // Keep randomly picking answers from question bank until a unique answer is found
                while (possibleAnswers.contains(answerFromRandomQuestion)) {
                    // Continue while loop if the current question's answer was generated
                    if (answerFromRandomQuestion == currentQuestion.getAnswer()) {
                        continue;
                    }
                    // Randomly pick another answer
                    randomlyGeneratedIndex = (int) ((Math.random() * (max - min)) + min);
                    randomQuestion = this.questionBank.get(randomlyGeneratedIndex);
                    answerFromRandomQuestion = randomQuestion.getAnswer();
                }
                // Add unique answer to "possibleAnswers"
                possibleAnswers.add(randomQuestion.getAnswer());
            }
            // Add correct answer to "possibleAnswers"
            possibleAnswers.add(currentQuestion.getAnswer());
            // Randomize "possibleAnswers" ArrayList ten times to get a different order of answers each time
            for (int j = 0; j < 10; ++j) {
                Collections.shuffle(possibleAnswers);
            }
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
                if (aButton.getText().toString() == currentQuestion.getAnswer()) {
                    // Correct Answer
                    this.numQuestionsCorrect++;
                } else {
                    // Incorrect Answer
                    // Display message in app that answer selected is incorrect and move on to next question
                }
            } else if (bButton.isPressed()) {
                if (bButton.getText().toString() == currentQuestion.getAnswer()) {
                    // Correct Answer
                    this.numQuestionsCorrect++;
                } else {
                    // Incorrect Answer
                    // Display message in app that answer selected is incorrect and move on to next question
                }
            } else if (cButton.isPressed()) {
                if (cButton.getText().toString() == currentQuestion.getAnswer()) {
                    // Correct Answer
                    this.numQuestionsCorrect++;
                } else {
                    // Incorrect Answer
                    // Display message in app that answer selected is incorrect and move on to next question
                }
            } else if (dButton.isPressed()) {
                if (dButton.getText().toString() == currentQuestion.getAnswer()) {
                    // Correct Answer
                    this.numQuestionsCorrect++;
                } else {
                    // Incorrect Answer
                    // Display message in app that answer selected is incorrect and move on to next question
                }
            } else if (quitButton.isPressed()) {
                // Add prompts to save/not save current quiz
                // Afterwards, exit from the for loop containing the currently running quiz
            }
        }
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
