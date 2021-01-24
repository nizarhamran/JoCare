package com.example.jocare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.jocare.Model.PanicBtn;
import com.example.jocare.Model.usersHelper;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.hbb20.CountryCodePicker;

import java.util.HashMap;
import java.util.Map;

public class PanicButton extends AppCompatActivity {

    private static final int REQUEST_CALL = 1;
    private Button saveBtn, cancelPanic;
    private EditText mEditTextNumber;
    ImageView panicBack;
DatabaseReference panicRef;
CountryCodePicker phonePanic;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panic_button);
        phonePanic = findViewById(R.id.phonePanic);
        cancelPanic = findViewById(R.id.cancelPanic);
        Intent panicIntent = getIntent();
        String Panic = panicIntent.getStringExtra("PID");
panicRef = FirebaseDatabase.getInstance().getReference("Users").child(Panic);

        mEditTextNumber= findViewById(R.id.edtPanic);
        saveBtn= findViewById(R.id.Call);
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                panicCall();

            }
        });
        cancelPanic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditTextNumber.getText().clear();
            }
        });
        panicBack = findViewById(R.id.panicBack);
        panicBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backPAn = new Intent(PanicButton.this,HomePagePatient.class);
                backPAn.putExtra("PID",Panic);
                startActivity(backPAn);
            }
        });

    }

    private void panicCall() {
        String panic = mEditTextNumber.getText().toString();
        String cCPi = phonePanic.getSelectedCountryCodeWithPlus();

        if(!TextUtils.isEmpty(panic) && !TextUtils.isEmpty(cCPi) ){
            Map<String, Object> updates = new HashMap<String, Object>();
            updates.put("emr", panic);
            updates.put("ccpE",cCPi);

            panicRef.updateChildren(updates);
            Toast.makeText(this,"Record Saved", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this,"Please fill the fields", Toast.LENGTH_SHORT).show();

        }
    }



}