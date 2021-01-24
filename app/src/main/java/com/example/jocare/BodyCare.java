package com.example.jocare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class BodyCare extends AppCompatActivity {

    ImageView bodyBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_body_care);
        Intent BodyC =getIntent();
        String bodyC = BodyC.getStringExtra("PID");

        bodyBack = findViewById(R.id.bodyBack);
        bodyBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent body = new Intent(BodyCare.this,HomePagePatient.class);
                body.putExtra("PID",bodyC);
                startActivity(body);
            }
        });
    }
}