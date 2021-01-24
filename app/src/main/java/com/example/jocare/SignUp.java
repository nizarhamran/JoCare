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
import com.hbb20.CountryCodePicker;

import java.util.regex.Pattern;

import static android.widget.Toast.LENGTH_LONG;

public class SignUp extends AppCompatActivity {
    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^" +
                    "(?=.[0-9])" +         //at least 1 digit
                    "(?=.[a-z])" +         //at least 1 lower case letter
                    "(?=.[A-Z])" +         //at least 1 upper case letter
                    "(?=.[@#$%^&+=])" +    //at least 1 special character
                    "(?=\\S+$)" +           //no white spaces
                    ".{5,}" +               //at least 5 characters
                    "$");
    Button signupbt;
    TextView UpView;
    EditText regfirstName,reglastName,regEmr,regpass,regcoPass,natId;
    RadioButton patient,doctor;
    CountryCodePicker ccp;

    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        ccp = findViewById(R.id.signCode);
        signupbt= findViewById(R.id.upBt);
        regfirstName= findViewById(R.id.firstName);
        reglastName= findViewById(R.id.lastName);
        regEmr= findViewById(R.id.phoneNumReg);
        regpass= findViewById(R.id.upPass);
        regcoPass= findViewById(R.id.confirm);
        patient = findViewById(R.id.rbPatient);
        doctor = findViewById(R.id.rbDoctor);
        natId = findViewById(R.id.natId);

        reference = FirebaseDatabase.getInstance().getReference("Users");

        signupbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!addUser()) {
                    addUser();
                }else{
                    addUser();
                    Intent i = new Intent(SignUp.this, SignIn.class);
                    startActivity(i);
                }
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

    private boolean validatePass(){
        String inPass = regpass.getEditableText().toString().trim();
        if (!PASSWORD_PATTERN.matcher(inPass).matches()){
            regpass.setError("Please Include at least (1 number, 1 lower, 1 upper,  1 specialChar[@#$%^&+=], 5 characters long)");
            return false;
        }else{
            regpass.setError(null);
            return true;
        }

    }

    private boolean addUser() {
        String fName = regfirstName.getEditableText().toString();
        String lName = reglastName.getEditableText().toString();
        String emr = regEmr.getEditableText().toString();
        String pass = regpass.getEditableText().toString();
        String coPass = regcoPass.getEditableText().toString();
        String Patient = String.valueOf(patient.isChecked());
        String Doctor = String.valueOf(doctor.isChecked());
        String natid =natId.getEditableText().toString();
        String ccpE = ccp.getDefaultCountryCodeWithPlus();
        String Role;
        if(Patient.equals("true")){
            Role = "Patient";

        }else{
            Role = "Doctor";
        }


        if(!TextUtils.isEmpty(fName)&&pass.equals(coPass)&&!TextUtils.isEmpty(natid)&& validatePass()){
            usersHelper usershelper = new usersHelper(fName,lName,emr,pass,coPass,natid,Role,ccpE);
            reference.child(natid).setValue(usershelper);
            Toast.makeText(this,"Use added", LENGTH_LONG).show();
            return true;

        }
        else{

            Toast.makeText(this,"Please fill the missing fields if any, and check password", LENGTH_LONG).show();
            return false;

        }
    }
}