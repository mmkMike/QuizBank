package com.example.quizbank;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class QuestionBankViewAdapter extends ArrayAdapter<QuestionBankView> {
    public QuestionBankViewAdapter(@NonNull Context context, ArrayList<QuestionBankView> arrayList) {
        super(context, 0, arrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View currentItemView = convertView;
        if (currentItemView == null) {
            currentItemView = LayoutInflater.from(getContext()).inflate(R.layout.custom_questionbank_list_view, parent, false);
        }
        QuestionBankView currentQuestionBankPosition = getItem(position);
        ImageView questionBankImage = currentItemView.findViewById(R.id.imageView);
        assert currentQuestionBankPosition != null;
        questionBankImage.setImageResource(currentQuestionBankPosition.getQuestionBankImageId());
        TextView questionBank_textView = currentItemView.findViewById(R.id.button_QuestionBankName);
        questionBank_textView.setText(currentQuestionBankPosition.getQuestionBankName());
        return currentItemView;
    }
}
