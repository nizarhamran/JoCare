package com.example.jocare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class DentalCare extends AppCompatActivity {

    ImageView dentalBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dental_care);
        Intent DentalC =getIntent();
        String dentalC = DentalC.getStringExtra("PID");
        dentalBack = findViewById(R.id.dentalBack);
        dentalBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dental =new Intent(DentalCare.this,HomePagePatient.class);
                dental.putExtra("PID",dentalC);
                startActivity(dental);
            }
        });
    }
}