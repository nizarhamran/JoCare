package com.example.jocare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class AddRecord2 extends AppCompatActivity {

    private ImageButton back2;
    private Button SaveRecBtn;
    EditText editDescription, editTakenMedicine;
    RadioGroup HappyGroup,SupplementGroup,PregnantGroup,ProstateGroup,PillsGroup,IllnessGroup,
            AwareGroup, ManagementGroup,OftenGroup,HeadachesGroup,SmokerGroup,TouchyGroup;
    RadioButton YIllness, NIllness, YAware, NAware, YManagement, NManagement, YOften, NOften,
            YHeadaches, NHeadaches, YSmoker, NSmoker, YTouchy, NTouchy, YUnhappy, NUnhappy,
            YSupplement, NSupplement, YPregnant, NPregnant, YProstate, NProstate, YPills, NPills;

    Record record;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference PRecords = database.getReference("Patients Records");

    String CH1 = "YES";
    String CH2 = "NO";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_record2);
        Intent ADD2=getIntent();
        String add2=ADD2.getStringExtra("PID");

        record = new Record();
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

            HappyGroup =findViewById(R.id.HappyGroup);
            SupplementGroup =findViewById(R.id.SupplementGroup);
            PregnantGroup =findViewById(R.id.PregnantGroup);
            ProstateGroup =findViewById(R.id.ProstateGroup);
            PillsGroup =findViewById(R.id.PillsGroup);
            IllnessGroup =findViewById(R.id.IllnessGroup);
            AwareGroup =findViewById(R.id.AwareGroup);
            ManagementGroup =findViewById(R.id.ManagementGroup);
            OftenGroup =findViewById(R.id.OftenGroup);
            HeadachesGroup =findViewById(R.id.HeadachesGroup);
            SmokerGroup =findViewById(R.id.SmokerGroup);
            TouchyGroup =findViewById(R.id.TouchyGroup);
        }

        SaveRecBtn = findViewById(R.id.SaveRecBtn);
        back2 =  findViewById(R.id.back2);

        back2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent o = new Intent(AddRecord2.this, AskForRecord.class);
                o.putExtra("PID",add2);
                startActivity(o);
            }
        });

        SaveRecBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addRecord2();
                Toast.makeText(AddRecord2.this, "Record Saved",Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void addRecord2(){
        String [] answer={CH1,CH2};
        String MedicalTreatments = editDescription.getText().toString().trim();
        String ListOfMedSup =editTakenMedicine.getText().toString().trim();
        RadioGroup [] allGroups2={HappyGroup,SupplementGroup,PregnantGroup,ProstateGroup,PillsGroup,IllnessGroup,
                AwareGroup, ManagementGroup,OftenGroup,HeadachesGroup,SmokerGroup,TouchyGroup};
        RadioButton [] Happy={YUnhappy, NUnhappy};
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
        }record.setMedicalDescription(MedicalTreatments);
        record.setListOfMedicine(ListOfMedSup);
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        record.setGeneralHealth(extras.getString("General_Health"));
        record.setHospitalization(extras.getString("Hospitalization"));
        record.setHeartProblem(extras.getString("Heart_Problems"));
        record.setEndocarditis(extras.getString("Endocarditis"));
        record.setHeartValve(extras.getString("Heart_Defect"));
        record.setPaceMaker(extras.getString("Pace_Maker"));
        record.setProsthesis(extras.getString("Prosthesis"));
        record.setBloodPressure(extras.getString("Blood_Pressure"));
        record.setStroke(extras.getString("Stroke"));
        record.setBloodDisorders(extras.getString("Blood_Disorder"));
        record.setHeadInjuries(extras.getString("Injuries"));
        record.setProlongBleeding(extras.getString("Slight_Cut"));
        record.setEmphysema(extras.getString("Breath"));
        record.setAsthma(extras.getString("Asthma"));
        record.setKidneyDisease(extras.getString("Kidney"));
        record.setLiverDisease(extras.getString("Liver"));
        record.setJaundice(extras.getString("Jaundice"));
        record.setThyroidDiseases(extras.getString("Thyroid"));
        record.setHormoneDeficiency(extras.getString("Hormone"));
        record.setHighCholesterol(extras.getString("Cholesterol"));
        record.setDiabetes(extras.getString("Diabetes"));
        record.setStomachUlcer(extras.getString("Ulcer"));

        record.setPatientFName(extras.getString("PATIENT_FNAME"));
        record.setPatientLName(extras.getString("PATIENT_LNAME"));
        record.setPatientDob(extras.getString("PATIENT_DOB"));
        record.setRecentExamination(extras.getString("RECENT"));
        record.setPatientNatId(extras.getString("PATIENT_NATID"));
        PRecords.child(extras.getString("PATIENT_NATID")).setValue(record);

    }

}