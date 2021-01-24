package com.example.jocare;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.jocare.Model.Reminder;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class InputActivity extends AppCompatActivity {
    private EditText edit_name, edit_notes, edit_dosage,edit_dob;
    TextView edit_time;
    int t1Hour,t1Minute;
    DatePickerDialog DobPicker;
    private Spinner edit_daytime, edit_weekday;
    private Button btn_add, btn_cancel;

    FirebaseDatabase database;
    DatabaseReference reminderDb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        edit_name= findViewById(R.id.edit_name);
        edit_notes = findViewById(R.id.edit_notes);
        edit_dosage= findViewById(R.id.edit_dosage);
        edit_daytime = findViewById(R.id.edit_daytime);
        edit_weekday = findViewById(R.id.edit_weekday);
        edit_dob = findViewById(R.id.edit_dob);
        edit_time = findViewById(R.id.edit_time);
        //Date Picker
        edit_dob.setInputType(InputType.TYPE_NULL);
        edit_dob.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                final Calendar cal =Calendar.getInstance();
                int day = cal.get(Calendar.DAY_OF_MONTH);
                int month = cal.get(Calendar.MONTH);
                int year = cal.get(Calendar.YEAR);
                DobPicker = new DatePickerDialog(InputActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                edit_dob.setText(dayOfMonth + "/" +(month + 1) + "/" + year );
                            }
                        }, year, month, day);
                DobPicker.show();

            }
        });
        //Time Picker
        edit_time.setInputType(InputType.TYPE_NULL);
        edit_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(
                        InputActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                t1Hour = hourOfDay;
                                t1Minute = minute;
                                String times = t1Hour + ":" + t1Minute;
                                SimpleDateFormat f24Hours = new SimpleDateFormat(
                                        "HH:mm"
                                );
                                try {
                                    Date date = f24Hours.parse(times);
                                    SimpleDateFormat f12Hours = new SimpleDateFormat(
                                            "HH:mm aa"
                                    );
                                    edit_time.setText(f12Hours.format(date));
                                } catch (ParseException e){
                                    e.printStackTrace();
                                }
                            }
                        },12,0,false
                );
                timePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                timePickerDialog.updateTime(t1Hour, t1Minute);
                timePickerDialog.show();
            }
        });
        //Cancel Button
        btn_cancel = findViewById(R.id.btn_cancel);
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cancelIntent= new Intent(InputActivity.this,MedicationReminder.class);
                startActivity(cancelIntent);
                Toast.makeText(InputActivity.this,"Medication Is Canceled.",Toast.LENGTH_SHORT).show();
            }
        });
        //Add Button
        btn_add = findViewById(R.id.btn_add);

        database =FirebaseDatabase.getInstance();
        reminderDb =database.getReference("Reminder");

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveToFirebase();
            }
        });
    }

    private void saveToFirebase() {
        String name = edit_name.getText().toString();
        String notes = edit_notes.getText().toString();
        String dosage = edit_dosage.getText().toString();
        String daytime = edit_daytime.getSelectedItem().toString();
        String weekday = edit_weekday.getSelectedItem().toString();
        String dob = edit_dob.getText().toString();
        String time = edit_time.getText().toString();

        if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(notes)
                && !TextUtils.isEmpty(dosage) && !TextUtils.isEmpty(dob) && !TextUtils.isEmpty(time)){
            Reminder reminder =new Reminder(name,notes,dosage,daytime,weekday,dob,time);
            reminderDb.push().setValue(reminder).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void aV) {

                    Intent intent = new Intent(InputActivity.this,MedicationReminder.class);

                    Toast.makeText(InputActivity.this,"Medication Is Added.",Toast.LENGTH_SHORT).show();

                    edit_name.setText("");
                    edit_notes.setText("");
                    edit_dosage.setText("");
                    edit_dob.setText("");
                    edit_time.setText("");
                    startActivity(intent);
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(InputActivity.this,e.getMessage(),Toast.LENGTH_SHORT).show();
                }
            });
        }else {
            Toast.makeText(this, "All Fields Should Be Filled.", Toast.LENGTH_SHORT).show();
        }
    }
}