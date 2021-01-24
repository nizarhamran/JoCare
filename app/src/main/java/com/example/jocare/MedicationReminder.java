package com.example.jocare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.jocare.Model.Reminder;
import com.example.jocare.ViewHolder.ReminderViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MedicationReminder extends AppCompatActivity {

    ImageView medicationBack;
    RecyclerView recyclerView;
    private FloatingActionButton fab;

    FirebaseDatabase database;
    DatabaseReference reminderDb;

    FirebaseRecyclerOptions<Reminder> options;
    FirebaseRecyclerAdapter<Reminder, ReminderViewHolder> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent medIntent =getIntent();
        String medId = medIntent.getStringExtra("medId");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medication_reminder);

        //Medication Back
        medicationBack = findViewById(R.id.MedicationBack);
        medicationBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backIntent= new Intent(MedicationReminder.this,HomePagePatient.class);
                backIntent.putExtra("PID",medId);
                startActivity(backIntent);
            }
        });
        //FloatingActionButton
        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fabIntent = new Intent(MedicationReminder.this,InputActivity.class);
                fabIntent.putExtra("InpID",medId);
                startActivity(fabIntent);
            }
        });

        database = FirebaseDatabase.getInstance();
        reminderDb =database.getReference("Users").child(medId).child("Reminder");
        //Recycler View
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        showReminder();
    }

    private void showReminder() {
        options = new FirebaseRecyclerOptions.Builder<Reminder>()
                .setQuery(reminderDb, Reminder.class )
                .build();
        adapter = new FirebaseRecyclerAdapter<Reminder, ReminderViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull ReminderViewHolder holder, int position, @NonNull Reminder model) {
                holder.text_name.setText(model.getName().substring(0,1).toUpperCase()+model.getName().substring(1));
                holder.text_notes.setText(model.getNotes());
                holder.text_dosage.setText(model.getDosage());
                holder.text_daytime.setText(model.getDaytime());
                holder.text_weekday.setText(model.getWeekday());
                holder.text_dob.setText(model.getDob());
                holder.text_Time.setText(model.getTime());
            }

            @NonNull
            @Override
            public ReminderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View itemView = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.reminder_row, parent, false);
                return new ReminderViewHolder(itemView);
            }
        };
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();

    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();

    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        item.getTitle().equals("Delete");
        deleteReminder(adapter.getRef(item.getOrder()).getKey());
        return super.onContextItemSelected(item);
    }

    private void deleteReminder(String key) {
        reminderDb.child(key).removeValue();
    }
}