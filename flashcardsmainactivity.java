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
            Intent startFlashcards = new Intent(v.getContext(), FlashcardsTime.class);
            v.getContext().startActivity(startFlashcards);
            finish();
        });

    }
} 
