package com.example.quizbank;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class QuestionViewAdapter extends ArrayAdapter<QuestionView> {
    public QuestionViewAdapter(@NonNull Context context, ArrayList<QuestionView> arrayList) {
        super(context, 0, arrayList);
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View currentItemView = convertView;
        if (currentItemView == null) {
            currentItemView = LayoutInflater.from(getContext()).inflate(R.layout.custom_questionanswerpair_list_view, parent, false);
        }
        QuestionView currentQuestionPosition = getItem(position);
        assert currentQuestionPosition != null;
        // Display Question
        TextView questionTextView = currentItemView.findViewById(R.id.textView_questionList_question);
        questionTextView.setText(currentQuestionPosition.getQuestion());
        // Display Answer
        TextView answerTextView = currentItemView.findViewById(R.id.textView_questionList_answer);
        answerTextView.setText(currentQuestionPosition.getAnswer());
        return currentItemView;
    }
}
