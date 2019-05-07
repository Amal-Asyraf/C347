package com.example.demoexplicitintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HeroStatsActivity extends AppCompatActivity {


    TextView tvName, tvStrength, tvTechnicalProwess;
    Button btnLike, btnDislike;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hero_stats);

        Intent i = getIntent();

        Hero hero = (Hero) i.getSerializableExtra("hero");

        tvName = findViewById(R.id.tVName);
        tvStrength = findViewById(R.id.tVStrength);
        tvTechnicalProwess = findViewById(R.id.tVTechnicalProwess);

        btnLike = findViewById(R.id.btnLike);
        btnDislike = findViewById(R.id.btnDislike);

        tvName.setText(hero.getName());
        tvStrength.setText("Strength: " + hero.getStrenght());
        tvTechnicalProwess.setText("Technical: " + hero.getTechnicalProwess());

        btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.putExtra("like", "like");
                // Set result to RESULT_OK to indicate normal			// response and pass in the intent containing the 		// like
                setResult(RESULT_OK, i);
                finish();

            }
        });

        btnDislike.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                //Create intent & pass in String data
                Intent i = new Intent();
                i.putExtra("like", "dislike");
                // Set result to RESULT_OK to indicate normal
                // response and pass in the intent containing the
                // dislike
                setResult(RESULT_OK, i);
                finish();
            }});


    }
}
