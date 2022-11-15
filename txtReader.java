package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    private EditText edittext1, edittext2;
    private Button buttonSum;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addListenerOnButton();



    }

    public void addListenerOnButton() {
        edittext1 = (EditText) findViewById(R.id.editText1);
        edittext2 = (EditText) findViewById(R.id.editText2);
        buttonSum = (Button) findViewById(R.id.button);

        buttonSum.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View view) {
                String value1=edittext1.getText().toString();
                String value2=edittext2.getText().toString();
                TextView myAwesomeTextView = (TextView)findViewById(R.id.textThing);

                StringBuilder text = new StringBuilder();
                BufferedReader reader = null;
                try {

//                    BufferedReader reader = new BufferedReader(new InputStreamReader(getAssets().open("tenQuestions.txt")));

                    reader = new BufferedReader(
                            new InputStreamReader(getAssets().open("tenQuestions.txt")));

                    String mLine;
//                    while ((mLine = reader.readLine()) != null) {
//
//                    }
                    while ((mLine = reader.readLine()) != null) {
                        text.append(mLine);
                        text.append('\n');
                    }
                } catch (IOException e) {
                } finally {
                    if (reader != null) {
                        try {
                            reader.close();
                        } catch (IOException e) {
                        }
                    }
                }

                myAwesomeTextView.setText(text.toString());

//                Toast.makeText(getApplicationContext(),String.valueOf(sum), Toast.LENGTH_LONG).show();
            }
        });
    }
}


//                int a=Integer.parseInt(value1);
//                int b=Integer.parseInt(value2);
//                int sum=a+b;

//                myAwesomeTextView.setText(String.valueOf(sum));

//                BufferedReader reader = null;


//
//                File sdcard = Environment.getExternalStorageDirectory();
//
////Get the text file
//                File file = new File(sdcard,"file.txt");
//
////Read text from file
//                StringBuilder text = new StringBuilder();
//
//                try {
//                    BufferedReader br = new BufferedReader(new FileReader(file));
//                    String line;
//
//                    while ((line = br.readLine()) != null) {
//                        text.append(line);
//                        text.append('\n');
//                    }
//                    br.close();
//                }

//                catch catch (IOException e) {
//                } finally {
//                    if (reader != null) {
//                        try {
//                            reader.close();
//                        } catch (IOException e) {
//                        }
//                    }
//                }
//
//


//public class MainActivity extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//    }
//}

//break
//
//package example.javatpoint.com.sumoftwonumber;
//
//        import android.support.v7.app.AppCompatActivity;
//        import android.os.Bundle;
//        import android.view.View;
//        import android.widget.Button;
//        import android.widget.EditText;
//        import android.widget.Toast;

//public class MainActivity extends AppCompatActivity {
//    private EditText edittext1, edittext2;
//    private Button buttonSum;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        addListenerOnButton();
//    }
//
//    public void addListenerOnButton() {
//        edittext1 = (EditText) findViewById(R.id.editText1);
//        edittext2 = (EditText) findViewById(R.id.editText2);
//        buttonSum = (Button) findViewById(R.id.button);
//
//        buttonSum.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String value1=edittext1.getText().toString();
//                String value2=edittext2.getText().toString();
//                int a=Integer.parseInt(value1);
//                int b=Integer.parseInt(value2);
//                int sum=a+b;
//                Toast.makeText(getApplicationContext(),String.valueOf(sum), Toast.LENGTH_LONG).show();
//            }
//        });
//    }
//}