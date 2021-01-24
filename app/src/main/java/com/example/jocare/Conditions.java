package com.example.jocare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Conditions extends AppCompatActivity {

    ImageView TermsBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conditions);
        Intent Ab = getIntent();
        String ConIn = Ab.getStringExtra("PID");
        TermsBack= findViewById(R.id.TermsBack);
        TermsBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent terms = new Intent(Conditions.this,HomePagePatient.class);
                terms.putExtra("PID",ConIn);
                startActivity(terms);
            }
        });
    }
}