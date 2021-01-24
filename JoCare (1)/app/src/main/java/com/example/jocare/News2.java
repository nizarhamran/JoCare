package com.example.jocare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class News2 extends AppCompatActivity {

    ImageView n2Back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news2);

        n2Back = findViewById(R.id.news2Back);
        n2Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent n2 = new Intent(News2.this,HomePagePatient.class);
                startActivity(n2);
            }
        });
    }
}