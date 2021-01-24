package com.example.jocare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class SignIn extends AppCompatActivity {

    private TextView eName,ePassword,forgetPass;
    private Button eLogin;
    //private RadioButton patient,doctor;
    private String Username = "Admin";
    private String Password= "Admin";
    boolean isValid= false;
    private Button signUp;
    RadioGroup rGRole;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        eName= findViewById(R.id.et_username);
        ePassword= findViewById(R.id.et_password);
        eLogin= findViewById(R.id.bt_login);
        forgetPass = findViewById(R.id.forget);
        forgetPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignIn.this,ForgetPassword.class);
                startActivity(intent);
            }
        });
        eLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputName = eName.getText().toString().trim();
                String inputPassword = ePassword.getText().toString().trim();
                if(inputName.isEmpty() || inputPassword.isEmpty())
                {
                    Toast.makeText(SignIn.this, "Please enter all the details correctly !",Toast.LENGTH_SHORT).show();

                }else {
                    //data base
                    Query checkUser = FirebaseDatabase.getInstance().getReference("Users").orderByChild("fName").equalTo(inputName);
                    checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if (snapshot.exists()) {

                                eName.setError(null);
                                eName.setEnabled(true);

                                for (DataSnapshot userSnapShot : snapshot.getChildren()) {
                                    if (userSnapShot.child("pass").getValue(String.class).equals(inputPassword)) {
                                        Log.e("password", "Valid");

                                        ePassword.setError(null);
                                        ePassword.setEnabled(true);
                                        Toast.makeText(SignIn.this, "Login was successful!", Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(SignIn.this, HomePagePatient.class);
                                        startActivity(intent);
                                    } else {
                                        Toast.makeText(SignIn.this, "Incorrect Password! ", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            } else {
                                Toast.makeText(SignIn.this, "Incorrect Username! ", Toast.LENGTH_SHORT).show();
                            }
                        }
                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            Toast.makeText(SignIn.this, error.getMessage(), Toast.LENGTH_LONG).show();

                        }
                    });
                }

            }

        });
        signUp=findViewById(R.id.signUpIn);
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent z=new Intent(SignIn.this,SignUp.class);
                startActivity(z);
            }
        });

    }
}