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
        Intent ns3 =getIntent();
        String N3 = ns3.getStringExtra("PID");
        n3back = findViewById(R.id.news3Back);
        n3back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent n3 =new Intent(News3.this,HomePagePatient.class);
                n3.putExtra("PID",N3);
                startActivity(n3);
            }
        });
    }
}