package com.example.jocare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class medical_permission extends AppCompatActivity {
    Button check_permission;
    ImageView permission_back;
    EditText edt_permission;
    private String Permission = "Doctor129860";
    boolean isValid= false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent medPer =getIntent();
        String Medper = medPer.getStringExtra("PID");
        setContentView(R.layout.activity_medical_permission);
        permission_back = findViewById(R.id.permission_back);
        permission_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent perB = new Intent(medical_permission.this,HomePagePatient.class);
                perB.putExtra("PID",Medper);
                startActivity(perB);
            }
        });

        edt_permission = findViewById(R.id.edt_permission);
        check_permission = findViewById(R.id.check_permission);
        check_permission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputPermission = edt_permission.getText().toString();
                if (inputPermission.isEmpty()){
                    Toast.makeText(medical_permission.this, "Please enter your code",Toast.LENGTH_SHORT).show();
                }else {
                    isValid = validate(inputPermission);
                    if (!isValid){
                        Toast.makeText(medical_permission.this, "Incorrect Code",Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(medical_permission.this, "Permission Granted", Toast.LENGTH_SHORT).show();
                        //check Medical records
                        Intent perIn = new Intent(medical_permission.this,AskForRecord.class);
                        perIn.putExtra("PID",Medper);
                        startActivity(perIn);
                    }
                }
            }
        });


    }
    private boolean validate(String name) {
        if (name.equals(Permission) ) {
            return true;
        }
        return false;
    }



}