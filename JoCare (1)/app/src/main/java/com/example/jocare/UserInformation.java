package com.example.jocare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.hbb20.CountryCodePicker;

public class UserInformation extends AppCompatActivity {

    TextView ViewFname,ViewLname,ViewDob,ViewNatID,ViewCity,ViewPhone,ViewAddress,ViewPo,ccpPhone,ViewCcpNat,ViewEmp,ViewCivil,ViewRole;
    RadioButton patient,doctor;
    ImageView userBack;
    DatabaseReference UserInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_information);

        ViewFname = findViewById(R.id.ViewFname);
        ViewLname = findViewById(R.id.ViewLname);
        ViewNatID = findViewById(R.id.ViewNatID);
        ViewDob = findViewById(R.id.ViewDob);
        ViewCity = findViewById(R.id.ViewCity);
        ViewPhone = findViewById(R.id.ViewPhone);
        ViewPo = findViewById(R.id.ViewPo);
        ViewAddress = findViewById(R.id.ViewAddress);
        ccpPhone =  findViewById(R.id.ccpPhone);
        ViewCcpNat = findViewById(R.id.ViewCcpNat);
        ViewEmp = findViewById(R.id.ViewEmp);
        ViewCivil = findViewById(R.id.ViewCivil);
        ViewRole = findViewById(R.id.ViewRole);


        UserInfo = FirebaseDatabase.getInstance().getReference("PersonalInfo");
        UserInfo.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        String f = snapshot.child("fName").getValue().toString();
                        String l = snapshot.child("lName").getValue().toString();
                        String nat = snapshot.child("natId").getValue().toString();
                        String dob = snapshot.child("dob").getValue().toString();
                        String city = snapshot.child("city").getValue().toString();
                        String phone = snapshot.child("phone").getValue().toString();
                        String postal = snapshot.child("postal").getValue().toString();
                        String address = snapshot.child("address").getValue().toString();
                        String ccPhone = snapshot.child("ccp").getValue().toString();
                        String ccNat = snapshot.child("natio").getValue().toString();
                        String emp = snapshot.child("emps").getValue().toString();
                        String civil = snapshot.child("civils").getValue().toString();
                        String role= snapshot.child("role").getValue().toString();
                        ViewFname.setText(f);
                        ViewLname.setText(l);
                        ViewNatID.setText(nat);
                        ViewDob.setText(dob);
                        ViewCity.setText(city);
                        ViewPhone.setText(phone);
                        ViewPo.setText(postal);
                        ViewAddress.setText(address);
                        ccpPhone.setText(ccPhone);
                        ViewCcpNat.setText(ccNat);
                        ViewEmp.setText(emp);
                        ViewCivil.setText(civil);
                        ViewRole.setText(role);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
        userBack = findViewById(R.id.userBack);
        userBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent user= new Intent(UserInformation.this,HomePagePatient.class);
                startActivity(user);
            }
        });
            }


    }
