package com.example.jocare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;




public class AddRecord1 extends AppCompatActivity {

    Button Next;
    ImageButton back1;
    EditText editFName, editLName,editDob,editNatId,editExamination;

    RadioGroup GeneralGroup, HospitalizationGroup,HeartGroup,EndocarditisGroup,HeartDefectGroup,
            PacemakerGroup,ProsthesisGroup,BloodpressureGroup,StrokeGroup,BloodDisorderGroup,InjuriesGroup,
            SlightCutGroup,BreathGroup,AsthmaGroup,KidneyGroup,LiverGroup,JaundiceGroup,ThyroidGroup,HormoneGroup,
            CholesterolGroup,DiabetesGroup,UlcerGroup;

    RadioButton BExcellent,BGood,BBad,YHospitalization,NHospitalization,YHeartProblems,NHeartProblems,
            YEndocarditis,NEndocarditis, YHeartDefect,NHeartDefect,YPacemaker,NPacemaker,YProsthesis,
            NProsthesis,YBloodPressure, NBloodPressure,YStroke,NStroke,YBloodDisorder,NBloodDisorder,
            YInjuries,NInjuries, YSlightCut,NSlightCut,YBreath,NBreath,YAsthma,NAsthma,YKidney,NKidney,
            YLiver,NLiver,YJaundice,NJaundice,YThyroid,NThyroid,YHormone,NHormone,
            YCholesterol,NCholesterol,YDiabetes,NDiabetes,YUlcer,NUlcer;

    Record record;

    String CHG1="Excellent";
    String CHG2="Good";
    String CHG3="Bad";
    String CH1 = "YES";
    String CH2 = "NO";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_record1);
        Intent ADD1 = getIntent();
        String add1 = ADD1.getStringExtra("PID");

        record = new Record();
        {
            Next = findViewById(R.id.NextBtn);
            back1 = findViewById(R.id.back1);

            editFName = findViewById(R.id.editTxtFname);
            editLName = findViewById(R.id.editTxtLname);
            editDob = findViewById(R.id.editTxtDob);
            editNatId = findViewById(R.id.editTxtNatId);
            editExamination = findViewById(R.id.editTxtExamintaion);

            BExcellent = findViewById(R.id.ChBExcellent);
            BGood = findViewById(R.id.ChBGood);
            BBad = findViewById(R.id.ChBBad);

            YHospitalization = findViewById(R.id.ChYHospitalization);
            NHospitalization = findViewById(R.id.ChNHospitalization);

            YHeartProblems = findViewById(R.id.ChYHeartproblem);
            NHeartProblems = findViewById(R.id.ChNHeartproblem);
            YEndocarditis = findViewById(R.id.ChYEndocarditis);
            NEndocarditis = findViewById(R.id.ChNEndocarditis);
            YHeartDefect = findViewById(R.id.ChYHeartdefect);
            NHeartDefect = findViewById(R.id.ChNHeartdefect);
            YPacemaker = findViewById(R.id.ChYPacemaker);
            NPacemaker = findViewById(R.id.ChNPacemaker);
            YProsthesis = findViewById(R.id.ChYProsthesis);
            NProsthesis = findViewById(R.id.ChNProsthesis);
            YBloodPressure = findViewById(R.id.ChYBloodpressure);
            NBloodPressure = findViewById(R.id.ChNBloodpressure);
            YStroke = findViewById(R.id.ChYStroke);
            NStroke = findViewById(R.id.ChNStroke);
            YBloodDisorder = findViewById(R.id.ChYBloodDisorder);
            NBloodDisorder = findViewById(R.id.ChNBloodDisorder);
            YInjuries = findViewById(R.id.ChYInjuries);
            NInjuries = findViewById(R.id.ChNInjuries);
            YSlightCut = findViewById(R.id.ChYSlightCut);
            NSlightCut = findViewById(R.id.ChNSlightCut);
            YBreath = findViewById(R.id.ChYBreath);
            NBreath = findViewById(R.id.ChNBreath);
            YAsthma = findViewById(R.id.ChYAsthma);
            NAsthma = findViewById(R.id.ChNAsthma);
            YKidney = findViewById(R.id.ChYKidney);
            NKidney = findViewById(R.id.ChNKidney);
            YLiver = findViewById(R.id.ChYLiver);
            NLiver = findViewById(R.id.ChNLiver);
            YJaundice = findViewById(R.id.ChYJaundice);
            NJaundice = findViewById(R.id.ChNJaundice);
            YThyroid = findViewById(R.id.ChYThyroid);
            NThyroid = findViewById(R.id.ChNThyroid);
            YHormone = findViewById(R.id.ChYHormone);
            NHormone = findViewById(R.id.ChNHormone);
            YCholesterol = findViewById(R.id.ChYCholesterol);
            NCholesterol = findViewById(R.id.ChNCholesterol);
            YDiabetes = findViewById(R.id.ChYDiabetes);
            NDiabetes = findViewById(R.id.ChNDiabetes);
            YUlcer = findViewById(R.id.ChYUlcer);
            NUlcer = findViewById(R.id.ChNUlcer);

            GeneralGroup = findViewById(R.id.generalGroup);
            HospitalizationGroup= findViewById(R.id.HospitalizationGroup);
            HeartGroup= findViewById(R.id.HeartGroup);
            EndocarditisGroup= findViewById(R.id.EndocarditisGroup);
            HeartDefectGroup= findViewById(R.id.HearDefectGroup);
            PacemakerGroup= findViewById(R.id.PacemakerGroup);
            ProsthesisGroup= findViewById(R.id.ProsthesisGroup);
            BloodpressureGroup= findViewById(R.id.BloodpressureGroup);
            StrokeGroup= findViewById(R.id.StrokeGroup);
            BloodDisorderGroup= findViewById(R.id.BloodDisorderGroup);
            InjuriesGroup= findViewById(R.id.InjuriesGroup);
            SlightCutGroup= findViewById(R.id.SlightCutGroup);
            BreathGroup= findViewById(R.id.BreathGroup);
            AsthmaGroup= findViewById(R.id.AsthmaGroup);
            KidneyGroup= findViewById(R.id.KidneyGroup);
            LiverGroup= findViewById(R.id.LiverGroup);
            JaundiceGroup= findViewById(R.id.JaundiceGroup);
            ThyroidGroup= findViewById(R.id.ThyroidGroup);
            HormoneGroup= findViewById(R.id.HormoneGroup);
            CholesterolGroup= findViewById(R.id.CholesterolGroup);
            DiabetesGroup= findViewById(R.id.DiabetesGroup);
            UlcerGroup= findViewById(R.id.UlcerGroup);


        }

        Next.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                addRecord1();

            }
        });

        back1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(AddRecord1.this,AskForRecord.class);
                i.putExtra("PID",add1);
                startActivity(i);
            }
        });
    }

    //Todo insert Func in onclick btn save
    //Todo Remove name of physician from XML ask team
    private void addRecord1() {
        Intent ADD1 = getIntent();
        String add1 = ADD1.getStringExtra("PID");

        String PatientFirstName = editFName.getText().toString().trim();
        String PatientLastName = editLName.getText().toString().trim();
        String PatientDoB = editDob.getText().toString().trim();
        String PatientID = editNatId.getText().toString().trim();
        String RecentExam = editExamination.getText().toString().trim();
        String[] answer = {CH1, CH2};
        String[] estimate = {CHG1, CHG2, CHG3};
        RadioButton[] generalHealth = {BExcellent, BGood, BBad};
        RadioGroup[] allGroups = {GeneralGroup, HospitalizationGroup, HeartGroup, EndocarditisGroup, HeartDefectGroup,
                PacemakerGroup, ProsthesisGroup, BloodpressureGroup, StrokeGroup, BloodDisorderGroup, InjuriesGroup,
                SlightCutGroup, BreathGroup, AsthmaGroup, KidneyGroup, LiverGroup, JaundiceGroup, ThyroidGroup, HormoneGroup,
                CholesterolGroup, DiabetesGroup, UlcerGroup};




        RadioButton[] Hospitalization = {YHospitalization, NHospitalization};
        RadioButton[] HeartProblems = {YHeartProblems, NHeartProblems};
        RadioButton[] Endocarditis = {YEndocarditis, NEndocarditis};
        RadioButton[] HeartDefect = {YHeartDefect, NHeartDefect};
        RadioButton[] Pacemaker = {YPacemaker, NPacemaker};
        RadioButton[] Prosthesis = {YProsthesis, NProsthesis};
        RadioButton[] BloodPressure = {YBloodPressure, NBloodPressure};
        RadioButton[] Stroke = {YStroke, NStroke};
        RadioButton[] BloodDisorder = {YBloodDisorder, NBloodDisorder};
        RadioButton[] Injuries = {YInjuries, NInjuries};
        RadioButton[] SlightCut = {YSlightCut, NSlightCut};
        RadioButton[] Breath = {YBreath, NBreath};
        RadioButton[] Asthma = {YAsthma, NAsthma};
        RadioButton[] Kidney = {YKidney, NKidney};
        RadioButton[] Liver = {YLiver, NLiver};
        RadioButton[] Jaundice = {YJaundice, NJaundice};
        RadioButton[] Thyroid = {YThyroid, NThyroid};
        RadioButton[] Hormone = {YHormone, NHormone};
        RadioButton[] Cholesterol = {YCholesterol, NCholesterol};
        RadioButton[] Diabetes = {YDiabetes, NDiabetes};
        RadioButton[] Ulcer = {YUlcer, NUlcer};
        Bundle extras = new Bundle();

        // !(allGroups[c].getCheckedRadioButtonId() ==-1)
        Record record = new Record();
        for (int c = 0; c <allGroups.length; c++) {
            if (PatientFirstName.length()==0 && PatientLastName.length()==0 && PatientDoB.length()==0 && PatientID.length()==0 && RecentExam.length()==0 && allGroups[c].getCheckedRadioButtonId()==-1){
                Toast.makeText(AddRecord1.this, "Please fill all Fields ", Toast.LENGTH_SHORT).show();
            }else


                for (int i = 0; i < allGroups.length; i++) {
                    if (allGroups[i].equals(GeneralGroup)) {
                        for (int e = 0; e < generalHealth.length; e++) {
                            if (generalHealth[e].isChecked()) {
                                extras.putString("General_Health",record.setGeneralHealth(estimate[e]));
                            }
                        }

                    }
                    if (allGroups[i].equals(HospitalizationGroup)) {
                        for (int e = 0; e < answer.length; e++) {
                            if (Hospitalization[e].isChecked()) {
                                extras.putString("Hospitalization",record.setHospitalization(answer[e]));
                            }
                        }
                    }
                    if (allGroups[i].equals(HeartGroup)) {
                        for (int e = 0; e < answer.length; e++) {
                            if (HeartProblems[e].isChecked()) {
                                extras.putString("Heart_Problems",record.setHeartProblem(answer[e]));
                            }
                        }
                    }
                    if (allGroups[i].equals(EndocarditisGroup)) {
                        for (int e = 0; e < answer.length; e++) {
                            if (Endocarditis[e].isChecked()) {
                                extras.putString("Endocarditis",record.setEndocarditis(answer[e]));
                            }
                        }
                    }
                    if (allGroups[i].equals(HeartDefectGroup)) {
                        for (int e = 0; e < answer.length; e++) {
                            if (HeartDefect[e].isChecked()) {
                                extras.putString("Heart_Defect",record.setHeartValve(answer[e]));
                            }
                        }
                    }
                    if (allGroups[i].equals(PacemakerGroup)) {
                        for (int e = 0; e < answer.length; e++) {
                            if (Pacemaker[e].isChecked()) {
                                extras.putString("Pace_Maker",record.setPaceMaker(answer[e]));
                            }
                        }
                    }
                    if (allGroups[i].equals(ProsthesisGroup)) {
                        for (int e = 0; e < answer.length; e++) {
                            if (Prosthesis[e].isChecked()) {
                                extras.putString("Prosthesis",record.setProsthesis(answer[e]));
                            }
                        }
                    }
                    if (allGroups[i].equals(BloodpressureGroup)) {
                        for (int e = 0; e < answer.length; e++) {
                            if (BloodPressure[e].isChecked()) {
                                extras.putString("Blood_Pressure",record.setBloodPressure(answer[e]));
                            }
                        }
                    }
                    if (allGroups[i].equals(StrokeGroup)) {
                        for (int e = 0; e < answer.length; e++) {
                            if (Stroke[e].isChecked()) {
                                extras.putString("Stroke",record.setStroke(answer[e]));
                            }
                        }
                    }
                    if (allGroups[i].equals(BloodDisorderGroup)) {
                        for (int e = 0; e < answer.length; e++) {
                            if (BloodDisorder[e].isChecked()) {
                                extras.putString("Blood_Disorder",record.setBloodDisorders(answer[e]));
                            }
                        }
                    }
                    if (allGroups[i].equals(InjuriesGroup)) {
                        for (int e = 0; e < answer.length; e++) {
                            if (Injuries[e].isChecked()) {
                                extras.putString("Injuries",record.setHeadInjuries(answer[e]));
                            }
                        }
                    }
                    if (allGroups[i].equals(SlightCutGroup)) {
                        for (int e = 0; e < answer.length; e++) {
                            if (SlightCut[e].isChecked()) {
                                extras.putString("Slight_Cut",record.setProlongBleeding(answer[e]));
                            }
                        }
                    }
                    if (allGroups[i].equals(BreathGroup)) {
                        for (int e = 0; e < answer.length; e++) {
                            if (Breath[e].isChecked()) {
                                extras.putString("Breath",record.setEmphysema(answer[e]));
                            }
                        }
                    }
                    if (allGroups[i].equals(AsthmaGroup)) {
                        for (int e = 0; e < answer.length; e++) {
                            if (Asthma[e].isChecked()) {
                                extras.putString("Asthma",record.setAsthma(answer[e]));
                            }
                        }
                    }
                    if (allGroups[i].equals(KidneyGroup)) {
                        for (int e = 0; e < answer.length; e++) {
                            if (Kidney[e].isChecked()) {
                                extras.putString("Kidney",record.setKidneyDisease(answer[e]));
                            }
                        }
                    }
                    if (allGroups[i].equals(LiverGroup)) {
                        for (int e = 0; e < answer.length; e++) {
                            if (Liver[e].isChecked()) {
                                extras.putString("Liver",record.setLiverDisease(answer[e]));
                            }
                        }
                    }
                    if (allGroups[i].equals(JaundiceGroup)) {
                        for (int e = 0; e < answer.length; e++) {
                            if (Jaundice[e].isChecked()) {
                                extras.putString("Jaundice",record.setJaundice(answer[e]));
                            }
                        }
                    }
                    if (allGroups[i].equals(ThyroidGroup)) {
                        for (int e = 0; e < answer.length; e++) {
                            if (Thyroid[e].isChecked()) {
                                extras.putString("Thyroid",record.setThyroidDiseases(answer[e]));
                            }
                        }
                    }
                    if (allGroups[i].equals(HormoneGroup)) {
                        for (int e = 0; e < answer.length; e++) {
                            if (Hormone[e].isChecked()) {
                                extras.putString("Hormone",record.setHormoneDeficiency(answer[e]));
                            }
                        }
                    }
                    if (allGroups[i].equals(CholesterolGroup)) {
                        for (int e = 0; e < answer.length; e++) {
                            if (Cholesterol[e].isChecked()) {
                                extras.putString("Cholesterol",record.setHighCholesterol(answer[e]));
                            }
                        }
                    }
                    if (allGroups[i].equals(DiabetesGroup)) {
                        for (int e = 0; e < answer.length; e++) {
                            if (Diabetes[e].isChecked()) {
                                extras.putString("Diabetes",record.setDiabetes(answer[e]));
                            }
                        }
                    }
                    if (allGroups[i].equals(UlcerGroup)) {
                        for (int e = 0; e < answer.length; e++) {
                            if (Ulcer[e].isChecked()) {
                                extras.putString("Ulcer",record.setStomachUlcer(answer[e]));
                            }
                        }
                    }
                    extras.putString("PATIENT_FNAME",record.setPatientFName(PatientFirstName));
                    extras.putString("PATIENT_LNAME",record.setPatientLName(PatientLastName));
                    extras.putString("PATIENT_DOB",record.setPatientDob(PatientDoB));
                    extras.putString("RECENT",record.setRecentExamination(RecentExam));
                    extras.putString("PATIENT_NATID",record.setPatientNatId(PatientID));

                    Intent intent=new Intent(AddRecord1.this,AddRecord2.class);
                    intent.putExtras(extras);
                    intent.putExtra("PID",add1);
                    startActivity(intent);
                }



        }
    } }
