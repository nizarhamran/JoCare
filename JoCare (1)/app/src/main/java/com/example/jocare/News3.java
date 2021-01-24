package com.example.jocare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class News3 extends AppCompatActivity {

    ImageView n3back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news3);

        n3back = findViewById(R.id.news3Back);
        n3back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent n3 =new Intent(News3.this,HomePagePatient.class);
                startActivity(n3);
            }
        });
    }
}