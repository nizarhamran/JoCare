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
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

public class Activation_Password extends AppCompatActivity {

    EditText phoneText;
    Button verify;
    private String verificationId;
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activation__password);

        TextView textmobile = findViewById(R.id.TextMobile);
        textmobile.setText(String.format("+962-%s" , getIntent().getStringExtra("mobile")));
        phoneText = findViewById(R.id.editTextNumber);
        verify = findViewById(R.id.button);
        //back to forget password
        back = findViewById(R.id.Fback);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent bf = new Intent(Activation_Password.this,ForgetPassword.class);
                startActivity(bf);
            }
        });
        final ProgressBar progressBar = findViewById(R.id.progressbar);

        verificationId = getIntent().getStringExtra("verificationId");

        verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(phoneText.getText().toString().trim().isEmpty()){
                    Toast.makeText(Activation_Password.this,"Please Enter Validation Code",Toast.LENGTH_LONG).show();
                    return;
                }
                String code = phoneText.getText().toString();
                if(verificationId != null){

                    progressBar.setVisibility(View.VISIBLE);
                    verify.setVisibility(View.INVISIBLE);

                    PhoneAuthCredential phoneauthcredential = PhoneAuthProvider.getCredential(verificationId,code);

                    FirebaseAuth.getInstance().signInWithCredential(phoneauthcredential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            progressBar.setVisibility(View.GONE);
                            verify.setVisibility(View.VISIBLE);

                            if(task.isSuccessful()){
                                Intent i = new Intent(Activation_Password.this,SetNewPassword.class);
                                startActivity(i);
                            }else{
                                Toast.makeText(Activation_Password.this,"Wrong Validation Code",Toast.LENGTH_LONG).show();

                            }

                        }
                    });

                }
            }
        });
    }
}