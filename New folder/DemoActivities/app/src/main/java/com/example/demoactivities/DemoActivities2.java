package com.example.demoactivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DemoActivities2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_activities2);

        Intent i = getIntent();

        String[] info = i.getStringArrayExtra("info");

        TextView tv1 = findViewById(R.id.textView);

        tv1.setText("You are "+ info[0] + ", age "+ info[1]);
    }
}
