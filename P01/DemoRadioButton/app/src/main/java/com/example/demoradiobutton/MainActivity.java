package com.example.demoradiobutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.button1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioGroup rg = findViewById(R.id.RadioGroup1);

                int selectedButtonId = rg.getCheckedRadioButtonId();

                RadioButton rb = findViewById(selectedButtonId);

                Toast.makeText(getBaseContext(), rb.getText(),Toast.LENGTH_LONG).show();
            }
        });
    }
}
