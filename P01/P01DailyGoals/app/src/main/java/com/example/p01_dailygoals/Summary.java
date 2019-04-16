package com.example.p01_dailygoals;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Summary extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        Intent i = getIntent();

        String[] summary = i.getStringArrayExtra("summary");

        TextView tVResult1 = findViewById(R.id.tVResult1);
        TextView tVResult2 = findViewById(R.id.tvResult2);
        TextView tVResult3 = findViewById(R.id.tVResult3);
        TextView tVResult4 = findViewById(R.id.tVResult4);

        tVResult1.setText(summary[0]);
        tVResult2.setText(summary[1]);
        tVResult3.setText(summary[2]);
        tVResult4.setText(summary[3]);
    }
}
