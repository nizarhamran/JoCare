package com.example.jocare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class update_record extends AppCompatActivity {
    TextView NatID, FName, LName, PDob;
    ImageButton back;
    Button Update;

    EditText editDescription, editTakenMedicine,editExamination;
    RadioGroup HappyGroup,SupplementGroup,PregnantGroup,ProstateGroup,PillsGroup,IllnessGroup,
            AwareGroup, ManagementGroup,OftenGroup,HeadachesGroup,SmokerGroup,TouchyGroup;
    RadioButton YIllness, NIllness, YAware, NAware, YManagement, NManagement, YOften, NOften,
            YHeadaches, NHeadaches, YSmoker, NSmoker, YTouchy, NTouchy, YUnhappy, NUnhappy,
            YSupplement, NSupplement, YPregnant, NPregnant, YProstate, NProstate, YPills, NPills;

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

    String CHG1="Excellent";
    String CHG2="Good";
    String CHG3="Bad";

    String CH1 = "YES";
    String CH2 = "NO";



    DatabaseReference ref ;
    Record getRecord;
    AskForRecord updateRecord;
    AddRecord1 add1;
    AddRecord2 add2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_record);
        getRecord = new Record();
        updateRecord = new AskForRecord();
        back=findViewById(R.id.BckBtn);
        Update=findViewById(R.id.updateBtn);
        NatID=findViewById(R.id.NatIdView);
        FName=findViewById(R.id.PFNameView);
        LName=findViewById(R.id.PLNameView);
        PDob=findViewById(R.id.PDobView);
        add1 = new AddRecord1();
        add2 = new AddRecord2();

        BExcellent = findViewById(R.id.ChBExcellent);
        BGood = findViewById(R.id.ChBGood);
        BBad = findViewById(R.id.ChBBad);
//record1
        {
            YHospitalization = findViewById(R.id.ChYHospitalization);
            NHospitalization = findViewById(R.id.ChNHospitalization);
            editExamination = findViewById(R.id.editTxtExamintaion);
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
            HospitalizationGroup = findViewById(R.id.HospitalizationGroup);
            HeartGroup = findViewById(R.id.HeartGroup);
            EndocarditisGroup = findViewById(R.id.EndocarditisGroup);
            HeartDefectGroup = findViewById(R.id.HearDefectGroup);
            PacemakerGroup = findViewById(R.id.PacemakerGroup);
            ProsthesisGroup = findViewById(R.id.ProsthesisGroup);
            BloodpressureGroup = findViewById(R.id.BloodpressureGroup);
            StrokeGroup = findViewById(R.id.StrokeGroup);
            BloodDisorderGroup = findViewById(R.id.BloodDisorderGroup);
            InjuriesGroup = findViewById(R.id.InjuriesGroup);
            SlightCutGroup = findViewById(R.id.SlightCutGroup);
            BreathGroup = findViewById(R.id.BreathGroup);
            AsthmaGroup = findViewById(R.id.AsthmaGroup);
            KidneyGroup = findViewById(R.id.KidneyGroup);
            LiverGroup = findViewById(R.id.LiverGroup);
            JaundiceGroup = findViewById(R.id.JaundiceGroup);
            ThyroidGroup = findViewById(R.id.ThyroidGroup);
            HormoneGroup = findViewById(R.id.HormoneGroup);
            CholesterolGroup = findViewById(R.id.CholesterolGroup);
            DiabetesGroup = findViewById(R.id.DiabetesGroup);
            UlcerGroup = findViewById(R.id.UlcerGroup);
        }
        //record2
        {
            editDescription = findViewById(R.id.editTxtDescribe);
            editTakenMedicine = findViewById(R.id.editTxtMedicine);
            YIllness = findViewById(R.id.ChYIllness);
            NIllness = findViewById(R.id.ChNIllness);
            YAware = findViewById(R.id.ChYAware);
            NAware = findViewById(R.id.ChNAware);
            YManagement = findViewById(R.id.ChYManagement);
            NManagement = findViewById(R.id.ChNManagement);
            YOften = findViewById(R.id.ChYOften);
            NOften = findViewById(R.id.ChNOften);
            YHeadaches = findViewById(R.id.ChYHeadaches);
            NHeadaches = findViewById(R.id.ChNHeadaches);
            YSmoker = findViewById(R.id.ChYSmoker);
            NSmoker = findViewById(R.id.ChNSmoker);
            YTouchy = findViewById(R.id.ChYTouchy);
            NTouchy = findViewById(R.id.ChNTouchy);
            YUnhappy = findViewById(R.id.ChYUnhappy);
            NUnhappy = findViewById(R.id.ChNUnhappy);
            YSupplement = findViewById(R.id.ChYSupplement);
            NSupplement = findViewById(R.id.ChNSupplement);
            YPregnant = findViewById(R.id.ChYPregnant);
            NPregnant = findViewById(R.id.ChNPregnant);
            YProstate = findViewById(R.id.ChYProstate);
            NProstate = findViewById(R.id.ChNProstate);
            YPills = findViewById(R.id.ChYPills);
            NPills = findViewById(R.id.ChNPills);

            HappyGroup = findViewById(R.id.HappyGroup);
            SupplementGroup = findViewById(R.id.SupplementGroup);
            PregnantGroup = findViewById(R.id.PregnantGroup);
            ProstateGroup = findViewById(R.id.ProstateGroup);
            PillsGroup = findViewById(R.id.PillsGroup);
            IllnessGroup = findViewById(R.id.IllnessGroup);
            AwareGroup = findViewById(R.id.AwareGroup);
            ManagementGroup = findViewById(R.id.ManagementGroup);
            OftenGroup = findViewById(R.id.OftenGroup);
            HeadachesGroup = findViewById(R.id.HeadachesGroup);
            SmokerGroup = findViewById(R.id.SmokerGroup);
            TouchyGroup = findViewById(R.id.TouchyGroup);
        }




        Intent i =getIntent();
        String PNatId = i.getStringExtra("Nat-Id");

        Intent S=getIntent();
        String id = S.getStringExtra("PID");


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent o = new Intent(update_record.this, AskForRecord.class);
                o.putExtra("PID",id);
                startActivity(o);
            }
        });

        ref= FirebaseDatabase.getInstance().getReference("Patients Records").child(PNatId);
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String Nat = snapshot.child("patientNatId").getValue().toString();
                String PFName = snapshot.child("patientFName").getValue().toString();
                String PLName = snapshot.child("patientLName").getValue().toString();
                String Dob = snapshot.child("patientDob").getValue().toString();
                NatID.setText(Nat);
                FName.setText(PFName.substring(0,1).toUpperCase()+PFName.substring(1));
                LName.setText(PLName.substring(0,1).toUpperCase()+PLName.substring(1));
                PDob.setText(Dob);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        Update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateRecode();


            }
        });


    }
    private void updateRecode(){
        //record1
        String []  answer={CH1,CH2};
        String[] estimate = {CHG1, CHG2, CHG3};
        RadioButton[] generalHealth = {BExcellent, BGood, BBad};
        RadioGroup[] allGroups = {GeneralGroup, HospitalizationGroup, HeartGroup, EndocarditisGroup, HeartDefectGroup,
                PacemakerGroup, ProsthesisGroup, BloodpressureGroup, StrokeGroup, BloodDisorderGroup, InjuriesGroup,
                SlightCutGroup, BreathGroup, AsthmaGroup, KidneyGroup, LiverGroup, JaundiceGroup, ThyroidGroup, HormoneGroup,
                CholesterolGroup, DiabetesGroup, UlcerGroup};
        String RecentExam = editExamination.getText().toString().trim();

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

        //record2
        String MedicalTreatments = editDescription.getText().toString().trim();
        String ListOfMedSup =editTakenMedicine.getText().toString().trim();
        RadioGroup[] allGroups2={HappyGroup,SupplementGroup,PregnantGroup,ProstateGroup,PillsGroup,IllnessGroup,
                AwareGroup, ManagementGroup,OftenGroup,HeadachesGroup,SmokerGroup,TouchyGroup};
        RadioButton[] Happy={YUnhappy, NUnhappy};
        RadioButton [] Supplement={YSupplement, NSupplement};
        RadioButton [] Pregnant={YPregnant, NPregnant};
        RadioButton [] Prostate={YProstate, NProstate};
        RadioButton [] Pill={YPills, NPills};
        RadioButton [] Illness={YIllness, NIllness};
        RadioButton [] Aware={YAware, NAware};
        RadioButton [] Management={YManagement, NManagement};
        RadioButton [] Often={YOften, NOften};
        RadioButton [] Headaches={YHeadaches, NHeadaches};
        RadioButton [] Smoker={YSmoker, NSmoker};
        RadioButton [] Touchy={YTouchy, NTouchy};
        Record record = new Record();

        for (int i = 0; i < allGroups.length; i++) {
            if (allGroups[i].equals(GeneralGroup)) {
                for (int e = 0; e < generalHealth.length; e++) {
                    if (generalHealth[e].isChecked()) {
                        record.setGeneralHealth(estimate[e]);
                    }
                }

            }
            if (allGroups[i].equals(HospitalizationGroup)) {
                for (int e = 0; e < answer.length; e++) {
                    if (Hospitalization[e].isChecked()) {
                        record.setHospitalization(answer[e]);
                    }
                }
            }
            if (allGroups[i].equals(HeartGroup)) {
                for (int e = 0; e < answer.length; e++) {
                    if (HeartProblems[e].isChecked()) {
                        record.setHeartProblem(answer[e]);
                    }
                }
            }
            if (allGroups[i].equals(EndocarditisGroup)) {
                for (int e = 0; e < answer.length; e++) {
                    if (Endocarditis[e].isChecked()) {
                        record.setEndocarditis(answer[e]);
                    }
                }
            }
            if (allGroups[i].equals(HeartDefectGroup)) {
                for (int e = 0; e < answer.length; e++) {
                    if (HeartDefect[e].isChecked()) {
                        record.setHeartValve(answer[e]);
                    }
                }
            }
            if (allGroups[i].equals(PacemakerGroup)) {
                for (int e = 0; e < answer.length; e++) {
                    if (Pacemaker[e].isChecked()) {
                        record.setPaceMaker(answer[e]);
                    }
                }
            }
            if (allGroups[i].equals(ProsthesisGroup)) {
                for (int e = 0; e < answer.length; e++) {
                    if (Prosthesis[e].isChecked()) {
                        record.setProsthesis(answer[e]);
                    }
                }
            }
            if (allGroups[i].equals(BloodpressureGroup)) {
                for (int e = 0; e < answer.length; e++) {
                    if (BloodPressure[e].isChecked()) {
                        record.setBloodPressure(answer[e]);
                    }
                }
            }
            if (allGroups[i].equals(StrokeGroup)) {
                for (int e = 0; e < answer.length; e++) {
                    if (Stroke[e].isChecked()) {
                        record.setStroke(answer[e]);
                    }
                }
            }
            if (allGroups[i].equals(BloodDisorderGroup)) {
                for (int e = 0; e < answer.length; e++) {
                    if (BloodDisorder[e].isChecked()) {
                        record.setBloodDisorders(answer[e]);
                    }
                }
            }
            if (allGroups[i].equals(InjuriesGroup)) {
                for (int e = 0; e < answer.length; e++) {
                    if (Injuries[e].isChecked()) {
                        record.setHeadInjuries(answer[e]);
                    }
                }
            }
            if (allGroups[i].equals(SlightCutGroup)) {
                for (int e = 0; e < answer.length; e++) {
                    if (SlightCut[e].isChecked()) {
                        record.setProlongBleeding(answer[e]);
                    }
                }
            }
            if (allGroups[i].equals(BreathGroup)) {
                for (int e = 0; e < answer.length; e++) {
                    if (Breath[e].isChecked()) {
                        record.setEmphysema(answer[e]);
                    }
                }
            }
            if (allGroups[i].equals(AsthmaGroup)) {
                for (int e = 0; e < answer.length; e++) {
                    if (Asthma[e].isChecked()) {
                        record.setAsthma(answer[e]);
                    }
                }
            }
            if (allGroups[i].equals(KidneyGroup)) {
                for (int e = 0; e < answer.length; e++) {
                    if (Kidney[e].isChecked()) {
                        record.setKidneyDisease(answer[e]);
                    }
                }
            }
            if (allGroups[i].equals(LiverGroup)) {
                for (int e = 0; e < answer.length; e++) {
                    if (Liver[e].isChecked()) {
                        record.setLiverDisease(answer[e]);
                    }
                }
            }
            if (allGroups[i].equals(JaundiceGroup)) {
                for (int e = 0; e < answer.length; e++) {
                    if (Jaundice[e].isChecked()) {
                        record.setJaundice(answer[e]);
                    }
                }
            }
            if (allGroups[i].equals(ThyroidGroup)) {
                for (int e = 0; e < answer.length; e++) {
                    if (Thyroid[e].isChecked()) {
                        record.setThyroidDiseases(answer[e]);
                    }
                }
            }
            if (allGroups[i].equals(HormoneGroup)) {
                for (int e = 0; e < answer.length; e++) {
                    if (Hormone[e].isChecked()) {
                        record.setHormoneDeficiency(answer[e]);
                    }
                }
            }
            if (allGroups[i].equals(CholesterolGroup)) {
                for (int e = 0; e < answer.length; e++) {
                    if (Cholesterol[e].isChecked()) {
                        record.setHighCholesterol(answer[e]);
                    }
                }
            }
            if (allGroups[i].equals(DiabetesGroup)) {
                for (int e = 0; e < answer.length; e++) {
                    if (Diabetes[e].isChecked()) {
                        record.setDiabetes(answer[e]);
                    }
                }
            }
            if (allGroups[i].equals(UlcerGroup)) {
                for (int e = 0; e < answer.length; e++) {
                    if (Ulcer[e].isChecked()) {
                        record.setStomachUlcer(answer[e]);
                    }
                }
            }

        }

        for(int i=0;i<allGroups2.length;i++) {
            if (allGroups2[i].equals(HappyGroup)) {
                for (int e = 0; e < answer.length; e++) {
                    if (Happy[e].isChecked()) {
                        record.setDepression(answer[e]);
                    }
                }
            }if (allGroups2[i].equals(SupplementGroup)) {
                for (int e = 0; e < answer.length; e++) {
                    if (Supplement[e].isChecked()) {
                        record.setDietarySupplement(answer[e]);
                    }
                }
            }if (allGroups2[i].equals(PregnantGroup)) {
                for (int e = 0; e < answer.length; e++) {
                    if (Pregnant[e].isChecked()) {
                        record.setPregnant(answer[e]);
                    }
                }
            }if (allGroups2[i].equals(ProstateGroup)) {
                for (int e = 0; e < answer.length; e++) {
                    if (Prostate[e].isChecked()) {
                        record.setProstateDisorder(answer[e]);
                    }
                }
            }if (allGroups2[i].equals(PillsGroup)) {
                for (int e = 0; e < answer.length; e++) {
                    if (Pill[e].isChecked()) {
                        record.setBirthPills(answer[e]);
                    }
                }
            }if (allGroups2[i].equals(IllnessGroup)) {
                for (int e = 0; e < answer.length; e++) {
                    if (Illness[e].isChecked()) {
                        record.setBeingTreatedForIllnesses(answer[e]);
                    }
                }
            }if (allGroups2[i].equals(AwareGroup)) {
                for (int e = 0; e < answer.length; e++) {
                    if (Aware[e].isChecked()) {
                        record.setChangeInHealth(answer[e]);
                    }
                }
            }if (allGroups2[i].equals(ManagementGroup)) {
                for (int e = 0; e < answer.length; e++) {
                    if (Management[e].isChecked()) {
                        record.setWeightMedications(answer[e]);
                    }
                }
            }if (allGroups2[i].equals(OftenGroup)) {
                for (int e = 0; e < answer.length; e++) {
                    if (Often[e].isChecked()) {
                        record.setFatigued(answer[e]);
                    }
                }
            }if (allGroups2[i].equals(HeadachesGroup)) {
                for (int e = 0; e < answer.length; e++) {
                    if (Headaches[e].isChecked()) {
                        record.setFreqHeadaches(answer[e]);
                    }
                }
            }if (allGroups2[i].equals(SmokerGroup)) {
                for (int e = 0; e < answer.length; e++) {
                    if (Smoker[e].isChecked()) {
                        record.setSmoker(answer[e]);
                    }
                }
            }if (allGroups2[i].equals(TouchyGroup)) {
                for (int e = 0; e < answer.length; e++) {
                    if (Touchy[e].isChecked()) {
                        record.setTouchy(answer[e]);
                    }
                }
            }
        }
        String nat = NatID.getText().toString();
        String PfName = FName.getText().toString();
        String PlName = LName.getText().toString();
        String DOB = PDob.getText().toString();
        record.setPatientFName(PfName);
        record.setPatientLName(PlName);
        record.setPatientDob(DOB);
        record.setPatientNatId(nat);
        record.setRecentExamination(RecentExam);
        record.setMedicalDescription(MedicalTreatments);
        record.setListOfMedicine(ListOfMedSup);
        ref.setValue(record);



    }
}