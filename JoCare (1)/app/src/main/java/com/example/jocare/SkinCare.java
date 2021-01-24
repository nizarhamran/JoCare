package com.example.jocare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class SkinCare extends AppCompatActivity {

    ImageView skinBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skin_care);

        skinBack = findViewById(R.id.skinBack);
        skinBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent skin = new Intent(SkinCare.this,HomePagePatient.class);
                startActivity(skin);
            }
        });
    }
}