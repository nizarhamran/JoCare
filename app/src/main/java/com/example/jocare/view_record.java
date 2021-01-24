package com.example.jocare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ExpandableListView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class view_record extends AppCompatActivity {

    TextView PNat, PFName, PLName, PDob, RecentExam, GeneralHealth, Hospitalized, HeartProblem,
            Endocarditis, HeartDefect, PaceMaker, Prosthesis, BloodPressure, Stroke, BloodDisorder,
            Injuries, SlightCut, Breath, Asthma, Kidney, Liver, Jaundice, Thyroid, Hormone, Cholesterol,
            Diabetes, Ulcer, Happy, Supplement, Pregnant, Prostate, Pills, Illness, Aware, Management,
            Fatigued, Headaches, Smoker, Touchy, MedicalTreatments, ListOfMedicine;
    ImageButton Back;
    DatabaseReference ref ;
    Record getRecord;
    AskForRecord viewRecord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_record1);
        getRecord = new Record();
        viewRecord = new AskForRecord();
        Intent i =getIntent();
        String PNatId = i.getStringExtra("Nat-Id");
        Intent s=getIntent();
        String id=s.getStringExtra("PID");

        Back=findViewById(R.id.imageButton3);

        PNat= findViewById(R.id.MedicalGetPatientNatId);
        PFName= findViewById(R.id.MedicalGetPatientFName);
        PLName= findViewById(R.id.MedicalGetPatientLName);
        PDob= findViewById(R.id.MedicalGetPatientDob);
        RecentExam= findViewById(R.id.MedicalGetPatientRecentExam);
        GeneralHealth= findViewById(R.id.MedicalGetPatientGEstimate);
        Hospitalized= findViewById(R.id.MedicalGetPatientHos);
        HeartProblem= findViewById(R.id.MedicalGetPatientHeartP);
        Endocarditis= findViewById(R.id.MedicalGetPatientEndocar);
        HeartDefect= findViewById(R.id.MedicalGetPatientHeartDefect);
        PaceMaker= findViewById(R.id.MedicalGetPatientPaceMaker);
        Prosthesis= findViewById(R.id.MedicalGetPatientProsthesis);
        BloodPressure= findViewById(R.id.MedicalGetPatientBloodPressure);
        Stroke= findViewById(R.id.MedicalGetPatientStroke);
        BloodDisorder= findViewById(R.id.MedicalGetBloodDisorder);
        Injuries= findViewById(R.id.MedicalGetInjuries);
        SlightCut= findViewById(R.id.MedicalGetSlightCut);
        Breath= findViewById(R.id.MedicalGetEmphysema);
        Asthma= findViewById(R.id.MedicalGetAsthma);
        Kidney= findViewById(R.id.MedicalGetKidney);
        Liver= findViewById(R.id.MedicalGetLiver);
        Jaundice= findViewById(R.id.MedicalGetJaundice);
        Thyroid= findViewById(R.id.MedicalGetThyroid);
        Hormone= findViewById(R.id.MedicalGetHormone);
        Cholesterol= findViewById(R.id.MedicalGetCholesterol);
        Diabetes= findViewById(R.id.MedicalGetDiabetes);
        Ulcer= findViewById(R.id.MedicalGetUlcer);
        Happy= findViewById(R.id.MedicalGetUnhappy);
        Supplement= findViewById(R.id.MedicalGetSupplement);
        Pregnant= findViewById(R.id.MedicalGetPregnant);
        Prostate= findViewById(R.id.MedicalGetProstate);
        Pills= findViewById(R.id.MedicalGetPills);
        Illness= findViewById(R.id.MedicalGetIllness);
        Aware= findViewById(R.id.MedicalGetChange);
        Management= findViewById(R.id.MedicalGetWeight);
        Fatigued= findViewById(R.id.MedicalGetFatigued);
        Headaches= findViewById(R.id.MedicalGetHeadaches);
        Smoker= findViewById(R.id.MedicalGetSmoker);
        Touchy= findViewById(R.id.MedicalGetTouchy);
        MedicalTreatments= findViewById(R.id.MedicalGetTreatment);
        ListOfMedicine= findViewById(R.id.MedicalGetMedications);

        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent o = new Intent(view_record.this, AskForRecord.class);
                o.putExtra("PID",id);
                startActivity(o);
            }
        });

        ref =FirebaseDatabase.getInstance().getReference("Patients Records").child(PNatId);
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String Nat=snapshot.child("patientNatId").getValue().toString();
                String FName = snapshot.child("patientFName").getValue().toString();
                String LName = snapshot.child("patientLName").getValue().toString();
                String Dob = snapshot.child("patientDob").getValue().toString();
                String RExam = snapshot.child("recentExamination").getValue().toString();
                String HealthEstimate =snapshot.child("generalHealth").getValue().toString();
                String Hospital= snapshot.child("hospitalization").getValue().toString();
                String HeartP = snapshot.child("heartProblem").getValue().toString();
                String Endo = snapshot.child("endocarditis").getValue().toString();
                String HeartD = snapshot.child("heartValve").getValue().toString();
                String Pace = snapshot.child("paceMaker").getValue().toString();
                String PProsthesis= snapshot.child("prosthesis").getValue().toString();
                String BloodP = snapshot.child("bloodPressure").getValue().toString();
                String PStroke = snapshot.child("stroke").getValue().toString();
                String BloodD = snapshot.child("bloodDisorders").getValue().toString();
                String HeadInjuries= snapshot.child("headInjuries").getValue().toString();
                String Bleeding= snapshot.child("prolongBleeding").getValue().toString();
                String Emphysema= snapshot.child("emphysema").getValue().toString();
                String PAsthma= snapshot.child("asthma").getValue().toString();
                String KidneyDisease= snapshot.child("kidneyDisease").getValue().toString();
                String LiverDisease= snapshot.child("liverDisease").getValue().toString();
                String PJaundice= snapshot.child("jaundice").getValue().toString();
                String PThyroid= snapshot.child("thyroidDiseases").getValue().toString();
                String PHormone= snapshot.child("hormoneDeficiency").getValue().toString();
                String PCholesterol= snapshot.child("highCholesterol").getValue().toString();
                String PDiabetes= snapshot.child("diabetes").getValue().toString();
                String PUlcer= snapshot.child("stomachUlcer").getValue().toString();
                String PIllness= snapshot.child("beingTreatedForIllnesses").getValue().toString();
                String ChangeInHealth= snapshot.child("changeInHealth").getValue().toString();
                String WeightManagement= snapshot.child("weightMedications").getValue().toString();
                String PFatigued= snapshot.child("fatigued").getValue().toString();
                String PHeadaches= snapshot.child("freqHeadaches").getValue().toString();
                String PSmoker= snapshot.child("smoker").getValue().toString();
                String PTouchy= snapshot.child("touchy").getValue().toString();
                String Depressed= snapshot.child("depression").getValue().toString();
                String PSupplement = snapshot.child("dietarySupplement").getValue().toString();
                String PPregnant= snapshot.child("pregnant").getValue().toString();
                String PProstate= snapshot.child("prostateDisorder").getValue().toString();
                String PPills= snapshot.child("birthPills").getValue().toString();
                String MedTreatments= snapshot.child("medicalDescription").getValue().toString();
                String ListMed= snapshot.child("listOfMedicine").getValue().toString();

                PNat.setText(Nat);
                PFName.setText(FName.substring(0,1).toUpperCase()+FName.substring(1));
                PLName.setText(LName.substring(0,1).toUpperCase()+LName.substring(1));
                PDob.setText(Dob);
                RecentExam.setText(RExam);
                GeneralHealth.setText(HealthEstimate);
                Hospitalized.setText(Hospital);
                HeartProblem.setText(HeartP);
                Endocarditis.setText(Endo);
                HeartDefect.setText(HeartD);
                PaceMaker.setText(Pace);
                Prosthesis.setText(PProsthesis);
                BloodPressure.setText(BloodP);
                Stroke.setText(PStroke);
                BloodDisorder.setText(BloodD);
                Injuries.setText(HeadInjuries);
                SlightCut.setText(Bleeding);
                Breath.setText(Emphysema);
                Asthma.setText(PAsthma);
                Kidney.setText(KidneyDisease);
                Liver.setText(LiverDisease);
                Jaundice.setText(PJaundice);
                Thyroid.setText(PThyroid);
                Hormone.setText(PHormone);
                Cholesterol.setText(PCholesterol);
                Diabetes.setText(PDiabetes);
                Ulcer.setText(PUlcer);
                Happy.setText(Depressed);
                Supplement.setText(PSupplement);
                Pregnant.setText(PPregnant);
                Prostate.setText(PProstate);
                Pills.setText(PPills);
                Illness.setText(PIllness);
                Aware.setText(ChangeInHealth);
                Management.setText(WeightManagement);
                Fatigued.setText(PFatigued);
                Headaches.setText(PHeadaches);
                Smoker.setText(PSmoker);
                Touchy.setText(PTouchy);
                MedicalTreatments.setText(MedTreatments);
                ListOfMedicine.setText(ListMed);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}