package com.example.jocare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class News4 extends AppCompatActivity {
    ImageView n4back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news4);
        Intent ns4 =getIntent();
        String N4 = ns4.getStringExtra("PID");
        n4back = findViewById(R.id.news4Back);
        n4back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent n4 =new Intent(News4.this,HomePagePatient.class);
                n4.putExtra("PID",N4);
                startActivity(n4);
            }
        });
    }
}