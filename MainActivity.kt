package com.example.saveprogress

import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var score: EditText
    private lateinit var quizName : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.edittext)
        score = findViewById(R.id.edit1)
        quizName = findViewById(R.id.edit2)
    }

    override fun onResume() {
        super.onResume()
        val sh = getSharedPreferences("MySharedPref", MODE_PRIVATE)
        val result = sh.getInt("score", 0)
        val qName = sh.getString("quizName", "")
        score.setText(result.toString())
        quizName.setText(qName)
    }

    override fun onPause() {
        super.onPause()
        val sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE)
        val myEdit = sharedPreferences.edit()
        myEdit.putInt("score", score.text.toString().toInt())
        myEdit.putString("quizName", quizName.text.toString())
        myEdit.apply()
    }

}
