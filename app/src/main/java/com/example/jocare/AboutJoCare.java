package com.example.jocare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class AboutJoCare extends AppCompatActivity {

    ImageView AboutBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_jo_care);
        Intent Ab = getIntent();
        String AboutIN = Ab.getStringExtra("PID");

        AboutBack = findViewById(R.id.AboutBack);
        AboutBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent about = new Intent(AboutJoCare.this,HomePagePatient.class);
                about.putExtra("PID",AboutIN);
                startActivity(about);
            }
        });
    }
}