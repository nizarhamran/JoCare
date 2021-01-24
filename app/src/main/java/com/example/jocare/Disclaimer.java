package com.example.jocare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Disclaimer extends AppCompatActivity {

    ImageView DiscBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disclaimer);
        Intent Ab = getIntent();
        String DisIN = Ab.getStringExtra("PID");

        DiscBack = findViewById(R.id.DiscBack);
        DiscBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent disc = new Intent(Disclaimer.this,HomePagePatient.class);
                disc.putExtra("PID",DisIN);
                startActivity(disc);
            }
        });
    }
}