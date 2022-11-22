package com.example.quizappflashcards;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {

// sets screen to flashcard start screen
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // button listener to flashcards button
        Button buttonStartFlashcards = findViewById(R.id.buttonStartFlashcards);
        buttonStartFlashcards.setOnClickListener(v -> {
            Intent chooseIntent = new Intent(v.getContext(), ChooseActivity.class);
            v.getContext().startActivity(chooseIntent);
            finish();
        });

    }
} 
