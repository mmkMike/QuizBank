import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

import com.example.quizbank.R;

public class SaveFile extends AppCompatActivity {
    private EditText score, quizName;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edittext);
        score = findViewById(R.id.edit1);
        quizName = findViewById(R.id.edit2);
    }

    @Override
    protected void onResume(){
        super.onResume();
        SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        int result = sh.getInt("score", 0);
        String qn = sh.getString("quizName", "");
        score.setText(String.valueOf(result));
        quizName.setText(qn);
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        SharedPreferences.Editor myEdit = sharedPreferences.edit();
        myEdit.putInt("score", Integer.parseInt(score.getText().toString()));
        myEdit.putString("quizName", quizName.getText().toString());
        myEdit.apply();
    }
}
