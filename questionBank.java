package com.example.quizbank;

import android.appcompat.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class questionBank extends AppCompActivity {


  private ArrayList<Question> questionBank;
  private int count;
  @Override
  public questionBank(){
    ArrayList<Question> questionBank= new ArrayList<>();
    count = 0;
  }

  public void removeSelected(int selection){
    questionBank.remove(selection);
  }
  public void addQuestion(Question newQuestion){
    questionBank.add(newQuestion);
    count++;
  }
  public void removeSelection(int selection){
    questionBank.remove(selection);
    count--;
  }

public int getCount(){
    return count;
}
  public String toString(boolean option, int selection){
    //option selects whether we want to return an answer or a question
    //using a boolean to only allow two options
    //if true return question
    if(option = true){
      return ("Question: " +  questionBank.get(selection).getQuestion());
    }
    else{
      return("Answer: " + questionBank.get(selection).getAnswer());
    }
  }
}