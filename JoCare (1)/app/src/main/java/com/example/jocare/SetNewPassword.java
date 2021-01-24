package com.example.jocare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class SetNewPassword extends AppCompatActivity {

    EditText password,newPassword,natId;
    Button updatepassword;
    DatabaseReference reference;
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_new_password);

        password = findViewById(R.id.newPassword);
        newPassword = findViewById(R.id.conNewPassword);
        updatepassword = findViewById(R.id.update);
        natId = findViewById(R.id.yournat);
        back = findViewById(R.id.bakHome);

        reference = FirebaseDatabase.getInstance().getReference("Users");

        updatepassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String pass= password.getText().toString().trim();
                String newpass= newPassword.getText().toString().trim();
                String natid = natId.getText().toString().trim();

                if (pass.isEmpty() || newpass.isEmpty() || !pass.equals(newpass)) {
                    Toast.makeText(SetNewPassword.this,"Passwords Does Not matches",Toast.LENGTH_LONG).show();

                }else{

                    // Data base
                    Query checknatid = FirebaseDatabase.getInstance().getReference("Users").orderByChild("natid").equalTo(natid);
                    checknatid.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if(snapshot.exists()){

                                snapshot.getRef().child(natid).child("pass").setValue(pass);
                                snapshot.getRef().child(natid).child("coPass").setValue(newpass);
                                Toast.makeText(SetNewPassword.this, "Password Updated",Toast.LENGTH_SHORT).show();
                                Intent n = new Intent(SetNewPassword.this,PasswordUpdated.class);
                                startActivity(n);

                            }else{
                                Toast.makeText(SetNewPassword.this,"Wrong National ID !",Toast.LENGTH_LONG );
                            }
                        }
                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            Toast.makeText(SetNewPassword.this, error.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    });
                }
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent hb = new Intent(SetNewPassword.this,SignIn.class);
                startActivity(hb);
            }
        });
    }
}