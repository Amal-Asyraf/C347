package com.example.p03;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class ActivityAdd extends AppCompatActivity {

    TextView tvweek;
    RadioGroup rg;
    Button btnSubmit;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        i = getIntent();
        final int weekno = i.getIntExtra("weekno", 0) + 1;


        tvweek = findViewById(R.id.textViewWeek);
        btnSubmit = findViewById(R.id.buttonSubmit);
        rg = findViewById(R.id.RG);


        tvweek.setText("week " + weekno);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedButtonId = rg.getCheckedRadioButtonId();
                RadioButton rb = findViewById(selectedButtonId);
                String grade =  rb.getText().toString();
                String code = i.getStringExtra("code");
                Grade grd = new Grade(grade,code);
                Intent intent = new Intent();
                intent.putExtra("grade", grd);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}