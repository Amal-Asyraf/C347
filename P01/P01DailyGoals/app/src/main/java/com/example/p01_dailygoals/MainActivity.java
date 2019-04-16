package com.example.p01_dailygoals;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


        RadioGroup rG1 = findViewById(R.id.RG1);
        RadioGroup rG2 = findViewById(R.id.RG2);
        RadioGroup rG3 = findViewById(R.id.RG3);

        int result1Id = rG1.getCheckedRadioButtonId();
        int result2Id = rG2.getCheckedRadioButtonId();
        int result3Id = rG3.getCheckedRadioButtonId();

        RadioButton rb1 = findViewById(result1Id);
        RadioButton rb2 = findViewById(result2Id);
        RadioButton rb3 = findViewById(result3Id);

        String result1 = rb1.getText().toString();
        String result2 = rb2.getText().toString();
        String result3 = rb3.getText().toString();

        EditText eTRefelection = findViewById(R.id.eTReflection);

        String reflection = eTRefelection.getText().toString();

        String[] summary = {result1,result2,result3,reflection};

        Intent i = new Intent(MainActivity.this,Summary.class);

        i.putExtra("summary", summary);

        startActivity(i);

            }
        });

    }
}
