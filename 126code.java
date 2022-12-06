package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import android.os.Bundle;
import android.os.FileUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MainActivity extends AppCompatActivity {
//    private EditText edittext1, edittext2;
//    private Button buttonSum;
    Button b_read;
    TextView tv_text;
    List<Integer> resultList = new ArrayList<Integer>();

    //    List<String> resultList = new ArrayList<String>();
    //    String result = "";
//    String height = "";
//    String weight = "";
    int sum = 0;
    int resultCount = 0;
    double averageCalc = 0;
    int i = 1;

//    int height = 0;
//    int weight = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b_read = (Button) findViewById(R.id.button);
        tv_text = (TextView) findViewById(R.id.textThing);

        b_read.setOnClickListener(new View.OnClickListener() {





            @Override
            public void onClick(View view) {
                String text = "";

//                try {
//                    String[] allFiles = assetManager.list(".txt");
//
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }


                int coutingthing = 0;
//                String[] readFolder = new String[0];
                String[] fileCount = new String[0];
                try {
//                    String[] images = assetManager.list("quiz1");
//                    Drawable[] drawables = new Drawable[images.length];
//                    for (int i = 0; i < images.length; i++) {
//                    readFolder = getAssets().list("quiz1");
                    fileCount = getAssets().list("");
                    coutingthing = fileCount.length-3;

                    for ( int j = 0;j<=coutingthing;j++){
                        BufferedReader bufferedReader = new BufferedReader(
                                new InputStreamReader(getAssets().open("attemptQuiz" + i + ".txt")));
//                                new InputStreamReader(getAssets().open("quiz1/" + images[i])));
                        String line;
                        i += 1;

                        while ((line = bufferedReader.readLine()) != null) {
                            text = text.concat(line + "\n");
                            String[] lineVals = line.split(":");

                            if (lineVals[0].equalsIgnoreCase("result")) {
                                resultList.add(Integer.parseInt(lineVals[1].trim()));
                                resultCount += 1;

                            }
                        }
                    }





//                        if(lineVals[0].equalsIgnoreCase("result")){
//                            result = lineVals[2].trim();
//                        }
//                        else if(lineVals[0].equalsIgnoreCase("correctAnswer") && lineVals[1].equalsIgnoreCase("1")){
//                            result = lineVals[2].trim();
//                        }
//                        else if(lineVals[0].equalsIgnoreCase("wrongAnswer")){
//                            weight = lineVals[1].trim();
//                        }

//                        else if(lineVals[0].equalsIgnoreCase("height")){
//                            height = Integer.parseInt(lineVals[1].trim());
//                        }
//                        else if(lineVals[0].equalsIgnoreCase("weight")){
//                            weight = Integer.parseInt(lineVals[1].trim());
//                        }
//
//                    }


                } catch (IOException ex) {
                    ex.printStackTrace();
                }

                for (int i = 0; i < resultList.size(); i++)
                    sum += resultList.get(i);
                averageCalc = (double) sum / resultCount;


                tv_text.setText(resultList.toString());

//                tv_text.setText(Arrays.toString(fileCount));
//                tv_text.setText(String.valueOf(averageCalc));
//                tv_text.setText(String.valueOf(resultList));

//                tv_text.setText(String.valueOf(coutingthing));
//                tv_text.setText(Arrays.toString(fileCount));


            }



        });

//        callingFunction1();

    }

//    public void callingFunction1() {
////        edittext1 = (EditText) findViewById(R.id.editText1);
////        edittext2 = (EditText) findViewById(R.id.editText2);
//
//
//        buttonSum = (Button) findViewById(R.id.button);
//        buttonSum.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View view) {
////                String value1=edittext1.getText().toString();
////                String value2=edittext2.getText().toString();
//                TextView myAwesomeTextView = (TextView)findViewById(R.id.textThing);
//
//                StringBuilder text = new StringBuilder();
////                final ArrayList<String> list = new ArrayList<String>();
//                BufferedReader reader = null;
//                try {
//
////                    BufferedReader reader = new BufferedReader(new InputStreamReader(getAssets().open("tenQuestions.txt")));
//
//                    reader = new BufferedReader(
//                            new InputStreamReader(getAssets().open("tenQuestions.txt")));
//
//                    String mLine;
////                    while ((mLine = reader.readLine()) != null) {
////
////                    }
//                    while ((mLine = reader.readLine()) != null) {
//                        text.append(mLine);
//                        text.append('\n');
//                        //add a count to appending multiple files to keep track
//                        //start adding lowest question detector
//                        //detect min value only to see which is the least successful problem
//
//
//                    }
//                } catch (IOException e) {
//                } finally {
//                    if (reader != null) {
//                        try {
//                            reader.close();
//                        } catch (IOException e) {
//                        }
//                    }
//                }
//
//                myAwesomeTextView.setText(text.toString());
//
//            }
//        });
//    }
}


//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        b_read = (Button) findViewById(R.id.b_read);
//        tv_text = (TextView) findViewById(R.id.tv_text);
//
//        b_read.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String text = "";
//                try {
//                    BufferedReader bufferedReader = new BufferedReader(
//                            new InputStreamReader(getAssets().open("test.txt")));
//                    String line;
//                    while((line = bufferedReader.readLine()) != null){
//                        text = text.concat(line + "\n");
//                        String[] lineVals = line.split(":");
//                        if(lineVals[0].equalsIgnoreCase("name")){
//                            name = lineVals[1].trim();
//                        } else if(lineVals[0].equalsIgnoreCase("height")){
//                            height = Integer.parseInt(lineVals[1].trim());
//                        } else if(lineVals[0].equalsIgnoreCase("weight")){
//                            weight = Integer.parseInt(lineVals[1].trim());
//                        }
//                    }
//                } catch (IOException ex) {
//                    ex.printStackTrace();
//                }
//                tv_text.setText(text);
//            }
//        });
//
//
//    }




//AFTER HERRE USELESS OLD SHTUGJfkfd





//                Toast.makeText(getApplicationContext(),String.valueOf(sum), Toast.LENGTH_LONG).show();
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