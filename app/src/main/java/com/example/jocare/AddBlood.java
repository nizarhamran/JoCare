package com.example.jocare;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class AddBlood extends AppCompatActivity {
    CheckBox  APlus,OPlus,BPlus,ABPlus,AMinus,OMinus,BMinus,ABMinus,
            APlusN,OPlusN,BPlusN,ABPlusN,AMinusN,OMinusN,BMinusN,ABMinusN;
    Button Savebutton,Clearbutton;
    EditText PName;
    EditText UnitsNeeded;
    EditText BBankName;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("requests");
    ImageButton button1;
    BloodReq bloodReq;
    String C0="A+";
    String C1="A-";
    String C2="O+";
    String C3="O-";
    String C4="B+";
    String C5="B-";
    String C6="AB+";
    String C7="AB-";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_blood);
        button1 = findViewById(R.id.imageButton);

        Intent ADDBLOOD = getIntent();
        String addBlood = ADDBLOOD.getStringExtra("PID");

        bloodReq = new BloodReq();

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent r = new Intent(AddBlood.this, AskForBlood.class);
                r.putExtra("PID",addBlood);
                startActivity(r);
            }
        });
        {
            UnitsNeeded = findViewById(R.id.editTxtUnitsNeeded);
            BBankName = findViewById(R.id.editTxtBloodBankN);
            PName= findViewById(R.id.editTxtPatientName);
            APlus = findViewById(R.id.ChAPlusPatient);
            OPlus = findViewById(R.id.ChOPlusPatient);
            BPlus = findViewById(R.id.ChBPlusPatient);
            ABPlus = findViewById(R.id.ChABPlusPatient);
            AMinus = findViewById(R.id.ChAMinusPatient);
            OMinus = findViewById(R.id.ChOMinusPatient);
            BMinus = findViewById(R.id.ChBMinusPatient);
            ABMinus = findViewById(R.id.ChABMinusPatient);

            APlusN = findViewById(R.id.ChAPlusNeed);
            OPlusN = findViewById(R.id.ChOPlusNeed);
            BPlusN = findViewById(R.id.ChBPlusNeed);
            ABPlusN = findViewById(R.id.ChABPlusNeed);
            AMinusN = findViewById(R.id.ChAMinusNeed);
            OMinusN = findViewById(R.id.ChOMinusNeed);
            BMinusN = findViewById(R.id.ChBMinusNeed);
            ABMinusN = findViewById(R.id.ChABMinusNeed);

            Savebutton = findViewById(R.id.Save);
            Clearbutton = findViewById(R.id.Clear);
        }

        CheckBox [] PType ={APlus,AMinus,OPlus,OMinus,BPlus,BMinus,ABPlus,ABMinus};
        CheckBox [] Needed = {APlusN, AMinusN,OPlusN, OMinusN,BPlusN, BMinusN,ABPlusN, ABMinusN};

        for(int i=0;i<Needed.length;i++){
            Needed[i].setEnabled(false);
        }
        {
            APlus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    for (int e = 0; e < Needed.length; e++) {
                        if (e == 0 || e == 1 || e == 2 || e == 3) {
                            Needed[e].setEnabled(true);
                        } else {
                            Needed[e].setVisibility(View.INVISIBLE);
                            for (int w = 1; w < PType.length; w++) {
                                PType[w].setEnabled(false);
                            }

                        }
                    }

                }
            });
            AMinus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    for (int e = 0; e < Needed.length; e++) {
                        if (e == 1 || e == 3) {
                            Needed[e].setEnabled(true);
                        } else {
                            Needed[e].setVisibility(View.INVISIBLE);
                            for (int w = 2; w < PType.length; w++) {
                                PType[w].setEnabled(false);
                                APlus.setEnabled(false);
                            }
                        }
                    }
                }
            });
            OPlus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    for (int e = 0; e < Needed.length; e++) {
                        if (e == 2 || e == 3) {
                            Needed[e].setEnabled(true);
                        } else {
                            Needed[e].setVisibility(View.INVISIBLE);
                            for (int w = 3; w < PType.length; w++) {
                                for (int a = 1; a < 2 && a >= 0; a--) {
                                    PType[w].setEnabled(false);
                                    PType[a].setEnabled(false);
                                }
                            }
                        }
                    }
                }
            });
            OMinus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    for (int e = 0; e < Needed.length; e++) {
                        if (e == 3) {
                            Needed[e].setEnabled(true);
                        } else {
                            Needed[e].setVisibility(View.INVISIBLE);
                            for (int w = 4; w < PType.length; w++) {
                                for (int a = 2; a < 3 && a >= 0; a--) {
                                    PType[w].setEnabled(false);
                                    PType[a].setEnabled(false);
                                }
                            }
                        }
                    }
                }
            });
            BPlus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    for (int e = 0; e < Needed.length; e++) {
                        if (e == 2 || e == 3 || e == 4 || e == 5) {
                            Needed[e].setEnabled(true);
                        } else {
                            Needed[e].setVisibility(View.INVISIBLE);
                            for (int w = 5; w < PType.length; w++) {
                                for (int a = 3; a < 4 && a >= 0; a--) {
                                    PType[w].setEnabled(false);
                                    PType[a].setEnabled(false);
                                }
                            }
                        }
                    }
                }
            });
            BMinus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    for (int e = 0; e < Needed.length; e++) {
                        if (e == 3 || e == 5) {
                            Needed[e].setEnabled(true);
                        } else {
                            Needed[e].setVisibility(View.INVISIBLE);
                            for (int w = 6; w < PType.length; w++) {
                                for (int a = 4; a < 5 && a >= 0; a--) {
                                    PType[w].setEnabled(false);
                                    PType[a].setEnabled(false);
                                }
                            }
                        }
                    }

                }
            });
            ABPlus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    for (int e = 0; e < Needed.length; e++) {
                        Needed[e].setEnabled(true);
                    }
                    for (int w = 7; w < PType.length; w++) {
                        for (int a = 5; a < 6 && a >= 0; a--) {
                            PType[w].setEnabled(false);
                            PType[a].setEnabled(false);
                        }
                    }
                }
            });
            ABMinus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    for (int e = 0; e < Needed.length; e++) {
                        if (e == 1 || e == 3 || e == 5 || e == 7) {
                            Needed[e].setEnabled(true);
                        } else {
                            Needed[e].setVisibility(View.INVISIBLE);
                            for (int w = 6; w < 7 && w >= 0; w--) {
                                PType[w].setEnabled(false);
                            }
                        }
                    }
                }
            });
        }
        Savebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addBloodRequest();
            }
        });

        Clearbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                for (int i=0 ; i<PType.length;i++){

                    PType[i].setChecked(false);
                    PType[i].setEnabled(true);
                    Needed[i].setChecked(false);
                    Needed[i].setEnabled(false);
                    Needed[i].setVisibility(View.VISIBLE);
                }
                PName.setText("");
                UnitsNeeded.setText("");
                BBankName.setText("");
            }
        });
    }

    private void addBloodRequest(){
        String PatientName = PName.getText().toString().trim();
        CheckBox [] PType ={APlus,AMinus,OPlus,OMinus,BPlus,BMinus,ABPlus,ABMinus};
        CheckBox [] Needed = {APlusN, AMinusN,OPlusN, OMinusN,BPlusN, BMinusN,ABPlusN, ABMinusN};
        String [] BloodType={C0, C1, C2, C3, C4, C5, C6, C7};
        String NeededUnits = UnitsNeeded.getText().toString().trim();
        String BloodBankName=BBankName.getText().toString().trim();

        BloodReq bloodReq = new BloodReq();

        if (PatientName.length()!=0 && NeededUnits.length()!=0 && BloodBankName.length()!=0 && (( !PType[0].isChecked()||
        !PType[1].isChecked() ||  !PType[2].isChecked() || !PType[3].isChecked() || !PType[4].isChecked()||
        !PType[5].isChecked()|| !PType[6].isChecked()|| !PType[7].isChecked()) && (!Needed[0].isChecked() ||
        !Needed[1].isChecked()|| !Needed[2].isChecked()||  !Needed[3].isChecked()|| !Needed[4].isChecked()|| !Needed[5].isChecked()||
        !Needed[6].isChecked()||  !Needed[7].isChecked()))){
            Toast.makeText(AddBlood.this, "record saved ", Toast.LENGTH_SHORT).show();
                    for(int b=0;b<8;b++){
                        if(PType[b].isChecked()){
                            bloodReq.setPatientBloodType(BloodType[b]);
                        }if(Needed[b].isChecked()){
                            bloodReq.setBloodTypeNeeded(BloodType[b]);
                        }
                        bloodReq.setUnitsNeeded(NeededUnits);
                        bloodReq.setNameOfBloodBank(BloodBankName);
                        bloodReq.setPatientName(PatientName);
                        myRef.child(PatientName).setValue(bloodReq);


                    }
                }else{
                    Toast.makeText(AddBlood.this, "Please fill all Fields ",Toast.LENGTH_SHORT).show();
            }}
        }
