package com.example.quizbank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.lang.Math;

public class Quiz {
    // Public Class Variables
    public ArrayList<Question> questionBank;
    public ArrayList<Question> currentSetOfQuestionsForMC;
    // Private Class Variables
    private Integer numberOfQuestions;
    private String fontName;
    private Integer fontSize;
    private Double score;
    private Integer numQuestionsCorrect;
    private Boolean quizHasBeenStarted;
    private static Integer numberOfQuizzesForQuestionBank = 0;
    // Constructor(s)
    Quiz(ArrayList<Question> questionBankToUse) {
        this.questionBank = questionBankToUse;
        this.numberOfQuizzesForQuestionBank++;
        // Default Values for Score-Related Variables
        this.score = -1.0;
        this.numQuestionsCorrect = 1;
        this.quizHasBeenStarted = false;
    }
}