package com.example.p03;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class GradeActivity extends AppCompatActivity {
    ListView lvGrade;
    ArrayList<Grade> alGrade, grades;
    GradeCustomAdapter gca;
    Button btnAdd, btnEmail;
    private final static int REQUEST_CODE_1 = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grade);

        Intent i = getIntent();
        setTitle("Info for " + i.getStringExtra("code"));

        lvGrade = findViewById(R.id.lVGrade);
        alGrade = new ArrayList<>();
        btnEmail = findViewById(R.id.btnEmail);
        btnAdd = findViewById(R.id.btnAdd);

        Grade a = new Grade("A", "C347");
        Grade b = new Grade("B", "C349");
        Grade c = new Grade("C", "C349");
        Grade d = new Grade("D", "C347");
        Grade f = new Grade("F", "C347");
        Grade x = new Grade("X", "C349");


        alGrade.add(a);
        alGrade.add(c);
        alGrade.add(b);
        alGrade.add(d);
        alGrade.add(f);
        alGrade.add(x);

        grades = new ArrayList<>();
        for (int j = 0; j < alGrade.size(); j++) {
            if (alGrade.get(j).getCode().equalsIgnoreCase(i.getStringExtra("code"))) {
                grades.add(alGrade.get(j));
            }
        }
        gca = new GradeCustomAdapter(this, R.layout.grade_row, grades);
        lvGrade.setAdapter(gca);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(GradeActivity.this, ActivityAdd.class);
                int weekno = grades.size();
                i.putExtra("weekno", weekno);
                i.putExtra("code", i.getStringExtra("code"));
                startActivityForResult(i, REQUEST_CODE_1);
            }
        });

        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // The action you want this intent to do;
                // ACTION_SEND is used to indicate sending text

                String message = "Hi Faci,\nI am ...\nPlease see my remarks so far thank you";

                for (int j = 0; j < grades.size(); j++) {
                    String line = "\nWeek " + (j + 1) + ": DG " + grades.get(j).getGrade();
                    message += line;
                }


                Intent email = new Intent(Intent.ACTION_SEND);
                // Put essentials like email address, subject & body text
                email.putExtra(Intent.EXTRA_EMAIL,
                        new String[]{"jason_lim@rp.edu.sg"});
                email.putExtra(Intent.EXTRA_SUBJECT,
                        "Test Email from C347");
                email.putExtra(Intent.EXTRA_TEXT,
                        message);
                // This MIME type indicates email
                email.setType("message/rfc822");
                // createChooser shows user a list of app that can handle
                // this MIME type, which is, email
                startActivity(Intent.createChooser(email,
                        "Choose an Email client :"));

            }
        });

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            // This request code is set by startActivityForResult(intent, REQUEST_CODE_1) method.
            case REQUEST_CODE_1:
                if (resultCode == RESULT_OK) {
                    Grade grade = (Grade) data.getSerializableExtra("grade");
                    grades.add(grade);
                    alGrade.add(grade);
                    gca.notifyDataSetChanged();

                }
        }

    }
}