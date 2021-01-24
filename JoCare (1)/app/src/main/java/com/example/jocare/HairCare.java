package com.example.jocare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class HairCare extends AppCompatActivity {

    ImageView hairBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hair_care);

        hairBack = findViewById(R.id.hairBack);
        hairBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent hair = new Intent(HairCare.this,HomePagePatient.class);
                startActivity(hair);
            }
        });
    }
}