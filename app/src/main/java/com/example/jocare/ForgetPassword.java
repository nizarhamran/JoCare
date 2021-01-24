package com.example.jocare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.FirebaseException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.hbb20.CountryCodePicker;

import java.util.concurrent.TimeUnit;

public class ForgetPassword extends AppCompatActivity {

    Button button;
    EditText PhoneNum;
    ImageView Hback;
    CountryCodePicker cp ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);

        ProgressBar progressbar = findViewById(R.id.progressbar);
        PhoneNum = findViewById(R.id.phonenum);
        button = findViewById(R.id.forgetBt);
        Hback = findViewById(R.id.HoBack);
        cp = findViewById(R.id.ccpPhone);

        // back to signIn page
        Hback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent b = new Intent(ForgetPassword.this,SignIn.class);
                startActivity(b);
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = PhoneNum.getText().toString().trim();
                String ccp = cp.getSelectedCountryCodeWithPlus();

                if (PhoneNum.getText().toString().trim().isEmpty()) {
                    Toast.makeText(ForgetPassword.this, "Please Enter Phone Number", Toast.LENGTH_LONG).show();
                    return;
                }
                progressbar.setVisibility(View.VISIBLE);
                button.setVisibility(View.INVISIBLE);
                PhoneAuthProvider.getInstance().verifyPhoneNumber(
                        ccp + PhoneNum.getText().toString(),
                        60,
                        TimeUnit.SECONDS,
                        ForgetPassword.this,
                        new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

                            @Override
                            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                                progressbar.setVisibility(View.GONE);
                                button.setVisibility(View.VISIBLE);
                            }

                            @Override
                            public void onVerificationFailed(@NonNull FirebaseException e) {
                                progressbar.setVisibility(View.GONE);
                                button.setVisibility(View.VISIBLE);
                                Toast.makeText(ForgetPassword.this, e.getMessage(), Toast.LENGTH_SHORT).show();

                            }

                            @Override
                            public void onCodeSent(@NonNull String verificationId, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                                progressbar.setVisibility(View.GONE);
                                button.setVisibility(View.VISIBLE);



                                Intent intent = new Intent(getApplicationContext(), Activation_Password.class);
                                intent.putExtra("mobile", PhoneNum.getText().toString());
                                intent.putExtra("verificationId", verificationId);
                                startActivity(intent);

                            }
                        }

                );
            }

        });
    }
}