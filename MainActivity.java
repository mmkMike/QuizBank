package com.example.savemethod;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.savemethod.R;
import java.io.IOException;
import java.io.InputStream;


public class MainActivity extends AppCompatActivity {
    TextView textView;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        button = findViewById(R.id.btnReadFile);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String string = "";
                InputStream inputStream = null;
                try {
                    inputStream = getAssets().open("Quotes.txt");
                    int size = inputStream.available();
                    byte[] buffer = new byte[size];
                    inputStream.read(buffer);
                    string = new String(buffer);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                textView.setText(string);
            }
        });
    }
}