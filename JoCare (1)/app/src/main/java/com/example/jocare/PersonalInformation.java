package com.example.jocare;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.location.Address;
import android.nfc.Tag;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jocare.Model.Pinformation;
import com.example.jocare.Model.usersHelper;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.hbb20.CountryCodePicker;

import java.util.Calendar;

import static android.widget.Toast.LENGTH_LONG;

public class PersonalInformation extends AppCompatActivity {

    EditText editTxtFname,editTxtLname,editTxtCity,editTxtPo,natId,editTxtAdd;
    CountryCodePicker ccNat;
    CountryCodePicker ccpPhone;
    EditText editTxtPhone;
    DatePickerDialog DobPicker;
    TextView editTxtDob;
    Button SaveBtn, ClearBtn;
    Spinner emp;
    Spinner civil;
    RadioButton patient,doctor;
    ImageView infoBack;
    //RadioGroup role;
    DatabaseReference info;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    private static final String TAG = PersonalInformation.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_information);

        //Per Info
        ccpPhone =  findViewById(R.id.ccpPhone);
        editTxtPhone =  findViewById(R.id.editTxtPhone);
        emp = findViewById(R.id.SpinnerEmployment);
        civil = findViewById(R.id.SpinnerCivil);
        SaveBtn =  findViewById(R.id.SaveBtn);
        ClearBtn = findViewById(R.id.ClearBtn);
        editTxtAdd = findViewById(R.id.editTextAddress);
        editTxtFname = findViewById(R.id.editTxtFname);
        editTxtLname = findViewById(R.id.editTxtLname);
        editTxtCity = findViewById(R.id.editTxtCity);
        editTxtPo = findViewById(R.id.editTxtPo);
        natId = findViewById(R.id.NatID);
        patient = findViewById(R.id.rbPatient);
        doctor = findViewById(R.id.rbDoctor);
        ccNat = findViewById(R.id.ccpNat);
        //database
        info = FirebaseDatabase.getInstance().getReference("PersonalInfo");

        //Back Button
        infoBack = findViewById(R.id.infoBack);
        infoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent infoB = new Intent(PersonalInformation.this,HomePagePatient.class);
                startActivity(infoB);
            }
        });

        //Clear Button Function
        ClearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Clear = new Intent(PersonalInformation.this,HomePagePatient.class);
                StringBuffer result = new StringBuffer();
                result.append("Record Cleared");
                Message.message(PersonalInformation.this, result.toString());
                startActivity(Clear);
            }
        });
        //Save button Function
        SaveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent personal =new Intent(PersonalInformation.this,HomePagePatient.class);
                perInfo();
                startActivity(personal);
            }
        });

        //Date Of Birth Picker
        editTxtDob =  findViewById(R.id.editTxtDob);
        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);
        editTxtDob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog dialog = new DatePickerDialog(
                        PersonalInformation.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener, year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });
        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                month = month+1;
                Log.d(TAG, "onDateSet: mm/dd/yyy"+month+"/"+dayOfMonth+"/"+year);

                String date = month +"/" + dayOfMonth +"/"+ year;
                editTxtDob.setText(date);

            }
        };
    }

    private void perInfo() {
        String fName = editTxtFname.getText().toString();
        String lName = editTxtLname.getText().toString();
        String city = editTxtCity.getText().toString();
        String postal = editTxtPo.getText().toString();
        String phone = editTxtPhone.getText().toString();
        String ccp = ccpPhone.getSelectedCountryCodeWithPlus();
        String natid = natId.getText().toString();
        String Dob = editTxtDob.getText().toString();
        String Address = editTxtAdd.getText().toString();
        String emps = emp.getSelectedItem().toString();
        String civils = civil.getSelectedItem().toString();
        String Patient = String.valueOf(patient.isChecked());
        String Natio = ccNat.getSelectedCountryEnglishName();
        String Role ;
        if(Patient.equals("true")){
            Role = "Patinet";
        }else{
            Role = "Doctor";
        }

        if(!TextUtils.isEmpty(fName) && !TextUtils.isEmpty(natid)){
            Pinformation pinformation = new Pinformation(fName,lName,city,postal,phone,ccp,natid,Role,emps,civils,Natio,Address,Dob);
            info.setValue(pinformation);
            Toast.makeText(this,"Record Saved", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this,"Please fill the missing fields", Toast.LENGTH_SHORT).show();

        }

    }


}