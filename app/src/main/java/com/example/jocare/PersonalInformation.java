package com.example.jocare;

import androidx.annotation.NonNull;
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
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.hbb20.CountryCodePicker;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import static android.widget.Toast.LENGTH_LONG;

public class PersonalInformation extends AppCompatActivity {

    EditText editTxtCity,editTxtPo,editTxtAdd;
    CountryCodePicker ccNat;
    CountryCodePicker ccpPhone;
    EditText editTxtPhone;
    DatePickerDialog DobPicker;
    TextView editTxtDob,natId,editTxtFname,editTxtLname,viewRole;
    Button SaveBtn, ClearBtn;
    Spinner emp;
    Spinner civil;
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
        viewRole = findViewById(R.id.viewRole);
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
        ccNat = findViewById(R.id.ccpNat);
        //database
        Intent i =getIntent();
        String PNID = i.getStringExtra("PID");
        info = FirebaseDatabase.getInstance().getReference("Users").child(PNID);

        //Back Button
        infoBack = findViewById(R.id.infoBack);
        infoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent infoB = new Intent(PersonalInformation.this,HomePagePatient.class);
                infoB.putExtra("PID",PNID);
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
                Clear.putExtra("PID",PNID);
                startActivity(Clear);
            }
        });
        //Save button Function
        SaveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent personal =new Intent(PersonalInformation.this,HomePagePatient.class);
                perInfo();
                personal.putExtra("PID",PNID);
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
        info.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String namef = snapshot.child("fName").getValue().toString();
                String namel = snapshot.child("lName").getValue().toString();
                String Nid = snapshot.child("natid").getValue().toString();
                String ro = snapshot.child("role").getValue().toString();
                natId.setText(Nid);
                editTxtFname.setText(namef);
                editTxtLname.setText(namel);
                viewRole.setText(ro);



            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
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
        String Natio = ccNat.getSelectedCountryEnglishName();



        if(!TextUtils.isEmpty(Dob) && !TextUtils.isEmpty(Natio)){
            Map<String, Object> updates = new HashMap<String, Object>();
            updates.put("postal",postal);
            updates.put("address",Address);
            updates.put("city",city);
            updates.put("ccp",ccp);
            updates.put("emps",emps);
            updates.put("civils",civils);
            updates.put("natio",Natio);
            updates.put("phone",phone);
            updates.put("dob",Dob);

            info.updateChildren(updates);

            Toast.makeText(this,"Record Saved", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this,"Please fill the missing fields", Toast.LENGTH_SHORT).show();

        }

    }


}