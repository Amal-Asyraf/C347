package com.example.p01_dailygoals;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {


   //SharedPreferences sharedPref = MainActivity.this.getPreferences(Context.MODE_PRIVATE);

    /*
   @Override
   protected void onResume() {

       super.onResume();

       RadioButton rb1 = findViewById(R.id.radioButton);
       RadioButton rb2 = findViewById(R.id.radioButton2);
       RadioButton rb3 = findViewById(R.id.radioButton3);
       RadioButton rb4 = findViewById(R.id.radioButton4);
       RadioButton rb5 = findViewById(R.id.radioButton5);
       RadioButton rb6 = findViewById(R.id.radioButton6);
       EditText text = findViewById(R.id.eTReflection);

       SharedPreferences sharedPref = MainActivity.this.getPreferences(Context.MODE_PRIVATE);
       int j = 0;

       while (j < 4) {
           String result = sharedPref.getString("response" + j, null);
           if (result != null) {
               if (j == 0) {
                   if (result.equalsIgnoreCase("yes")) {
                       rb1.setChecked(true);
                   } else {
                       rb2.setChecked(true);
                   }
               } else if (j == 1) {
                   if (result.equalsIgnoreCase("yes")) {
                       rb3.setChecked(true);
                   } else {
                       rb4.setChecked(true);
                   }
               } else if (j == 2) {
                   if (result.equalsIgnoreCase("yes")) {
                       rb5.setChecked(true);
                   } else {
                       rb6.setChecked(true);
                   }
               } else if (j == 3) {
                   text.setText(result);
               }
           }
           j++;
       }


   }

   */
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
                String[] summary = {result1, result2, result3, reflection};
                /*
                SharedPreferences.Editor editor = sharedPref.edit();



                for (int i = 0; i < summary.length; i++) {
                    editor.putString("response" + i, summary[i]);
                }
                editor.commit();

                */
                Intent i = new Intent(MainActivity.this, Summary.class);
                i.putExtra("summary", summary);

                startActivity(i);


            }
        });

    }
}
