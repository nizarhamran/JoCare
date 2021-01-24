package com.example.jocare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jocare.Model.usersHelper;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import static android.widget.Toast.LENGTH_LONG;

public class SignUp extends AppCompatActivity {
    Button signupbt;
    TextView UpView;
    CheckBox accept;
    EditText regfirstName,reglastName,regemail,regpass,regcoPass,natId;
    RadioButton patient,doctor;

    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        signupbt= findViewById(R.id.upBt);
        regfirstName= findViewById(R.id.firstName);
        reglastName= findViewById(R.id.lastName);
        regemail= findViewById(R.id.phoneNumReg);
        regpass= findViewById(R.id.upPass);
        regcoPass= findViewById(R.id.confirm);
        patient = findViewById(R.id.rbPatient);
        doctor = findViewById(R.id.rbDoctor);
        natId = findViewById(R.id.natId);

        reference = FirebaseDatabase.getInstance().getReference("Users");

        signupbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addUser();
                Intent i=new Intent(SignUp.this,SignIn.class);
                startActivity(i);
            }
        });
        UpView=findViewById(R.id.upText);
        UpView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(SignUp.this,SignIn.class);
                startActivity(intent);
            }
        });
    }

    private void addUser() {
        String fName = regfirstName.getEditableText().toString();
        String lName = reglastName.getEditableText().toString();
        String email = regemail.getEditableText().toString();
        String pass = regpass.getEditableText().toString();
        String coPass = regcoPass.getEditableText().toString();
        String Patient = String.valueOf(patient.isChecked());
        String Doctor = String.valueOf(doctor.isChecked());
        String natid =natId.getEditableText().toString();
        String Role;
        if(Patient.equals("true")){
            Role = "Patient";

        }else{
            Role = "Doctor";
        }


        if(!TextUtils.isEmpty(fName)&&pass.equals(coPass)&&!TextUtils.isEmpty(natid)){
            usersHelper usershelper = new usersHelper(fName,lName,email,pass,coPass/*,Patient,Doctor*/,natid,Role);
            reference.child(natid).setValue(usershelper);
            Toast.makeText(this,"Use added", LENGTH_LONG).show();

        }
        else{

            Toast.makeText(this,"Please fill the missing fields", LENGTH_LONG).show();

        }
    }
}