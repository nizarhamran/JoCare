package com.example.jocare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class AskForRecord extends AppCompatActivity {
    Button CreateBtn, UpdateBtn, ViewBtn;
ImageView back;
    Record PRecord1;
    view_record MedRecord;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ask_for_record);
        Intent Ask =getIntent();
        String ask = Ask.getStringExtra("PID");
        PRecord1= new Record();
        MedRecord = new view_record();
        back = findViewById(R.id.MedBack);
        CreateBtn = findViewById(R.id.CreateNBtn);
        UpdateBtn = findViewById(R.id.UpdateBtn);
        ViewBtn = findViewById(R.id.ViewBtn);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AskForRecord.this,HomePagePatient.class);
                intent.putExtra("PID",ask);
                startActivity(intent);

            }
        });
        CreateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent w=new Intent(AskForRecord.this,AddRecord1.class);
                w.putExtra("PID",ask);
                startActivity(w);
            }
        });

        ViewBtn.setOnClickListener(new View.OnClickListener() {


                                       @Override
                                       public void onClick(View v) {
                                           LayoutInflater inflater = (LayoutInflater) getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
                                           View popupView = inflater.inflate(R.layout.viewpopup,null);
                                           int width = LinearLayout.LayoutParams.MATCH_PARENT;
                                           int height = LinearLayout.LayoutParams.MATCH_PARENT;
                                           boolean focusable = true;
                                           final PopupWindow popupWindow = new PopupWindow(popupView,width,height,focusable);
                                           popupWindow.showAtLocation(ViewBtn,Gravity.CENTER, 0, 0);
                                           TextView requestTxt= popupView.findViewById(R.id.cardTextView);
                                           EditText editPNatId=popupView.findViewById(R.id.cardEditTxtNat);
                                           requestTxt.setText(R.string.NatEnter);

                                           Button viewBtn = popupView.findViewById(R.id.cardViewBtn);




                                           viewBtn.setOnClickListener(new View.OnClickListener() {
                                               @Override
                                               public void onClick(View v) {
                                                   String PNatId=editPNatId.getText().toString().trim();
                                                   DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
                                                   Query checkNat= ref.child("Patients Records").orderByChild("patientNatId").equalTo(PNatId);
                                                   checkNat.addValueEventListener(new ValueEventListener() {
                                                       @Override
                                                       public void onDataChange(@NonNull DataSnapshot snapshot) {
                                                           if (snapshot.exists()){

                                                               Intent i = new Intent(AskForRecord.this, view_record.class);
                                                               i.putExtra("Nat-Id",PNatId);
                                                               i.putExtra("PID",ask);
                                                               startActivity(i);

                                                           }else{Toast.makeText(AskForRecord.this,"Invalid",Toast.LENGTH_SHORT).show();
                                                           }


                                                       }

                                                       @Override
                                                       public void onCancelled(@NonNull DatabaseError error) {

                                                       }
                                                   });






                                               }

                                           });

                                           popupView.setOnTouchListener(new View.OnTouchListener() {
                                               @Override
                                               public boolean onTouch(View v, MotionEvent event) {

                                                   //Close the window when clicked
                                                   popupWindow.dismiss();
                                                   return true;
                                               }
                                           });
                                       }
                                   }
        );
        UpdateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater = (LayoutInflater) getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
                View popupView = inflater.inflate(R.layout.updatepopup,null);
                int width = LinearLayout.LayoutParams.MATCH_PARENT;
                int height = LinearLayout.LayoutParams.MATCH_PARENT;
                boolean focusable = true;
                final PopupWindow popupWindow = new PopupWindow(popupView,width,height,focusable);
                popupWindow.showAtLocation(ViewBtn,Gravity.CENTER, 0, 0);
                TextView requestTxt= popupView.findViewById(R.id.cardTextUpdateView);
                EditText editPNatId=popupView.findViewById(R.id.cardEditTxtUpdateNat);
                requestTxt.setText(R.string.NatUpdateRecord);

                Button updateBtn = popupView.findViewById(R.id.cardViewUpdateBtn);




                updateBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String PNatId=editPNatId.getText().toString().trim();
                        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
                        Query checkNat= ref.child("Patients Records").orderByChild("patientNatId").equalTo(PNatId);
                        checkNat.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                if (snapshot.exists()){

                                    Intent i = new Intent(AskForRecord.this, update_record.class);
                                    i.putExtra("Nat-Id",PNatId);
                                    i.putExtra("PID",ask);
                                    startActivity(i);

                                }else{Toast.makeText(AskForRecord.this,"Invalid",Toast.LENGTH_SHORT).show();
                                }


                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {

                            }
                        });






                    }

                });

                popupView.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {

                        //Close the window when clicked
                        popupWindow.dismiss();
                        return true;
                    }
                });
            }


        });
    }
}