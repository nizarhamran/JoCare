package com.example.jocare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class News5 extends AppCompatActivity {
    ImageView n5back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news5);
        Intent ns5 =getIntent();
        String N5 = ns5.getStringExtra("PID");
        n5back = findViewById(R.id.news5Back);
        n5back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent n5 =new Intent(News5.this,HomePagePatient.class);
                n5.putExtra("PID",N5);
                startActivity(n5);
            }
        });
    }
}