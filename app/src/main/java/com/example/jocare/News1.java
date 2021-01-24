package com.example.jocare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class News1 extends AppCompatActivity {

    ImageView newsBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news1);
        Intent ns1 =getIntent();
        String N1 = ns1.getStringExtra("PID");
        newsBack = findViewById(R.id.news1Back);
        newsBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent n1 = new Intent(News1.this,HomePagePatient.class);
                n1.putExtra("PID",N1);
                startActivity(n1);
            }
        });
    }
}