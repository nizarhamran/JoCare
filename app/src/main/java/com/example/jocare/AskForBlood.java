package com.example.jocare;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jocare.ViewHolder.BloodReqViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AskForBlood extends AppCompatActivity {

    private FloatingActionButton fab;
    RecyclerView recyclerView;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("requests");
    ImageButton back;
    FirebaseRecyclerOptions<BloodReq> options;
    FirebaseRecyclerAdapter<BloodReq, BloodReqViewHolder> adapter;
    BloodReq bloodReq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ask_for_blood);

        Intent ASKBLOOD = getIntent();
        String askBlood= ASKBLOOD.getStringExtra("PID");

        bloodReq = new BloodReq();

        back =findViewById(R.id.ask_blood_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AskForBlood.this, HomePagePatient.class);
                intent.putExtra("PID",askBlood);
                startActivity(intent);
            }
        });
        //FloatingActionButton
        fab = findViewById(R.id.addBFab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent t=new Intent(AskForBlood.this,AddBlood.class);
                t.putExtra("PID",askBlood);
                startActivity(t);


            }
        });

        //Recycler View
        recyclerView = findViewById(R.id.AskBloodRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        showReminder();
    }

    private void showReminder() {

        options = new FirebaseRecyclerOptions.Builder<BloodReq>()
                .setQuery(myRef, BloodReq.class )
                .build();
        adapter =new FirebaseRecyclerAdapter<BloodReq, BloodReqViewHolder>(options) {

            protected void onBindViewHolder(@NonNull BloodReqViewHolder holder, int position, @NonNull BloodReq model) {

                holder.PatientNameV.setText(model.getPatientName().substring(0,1).toUpperCase()+model.getPatientName().substring(1));
                holder.PatientBloodTypeV.setText(model.getPatientBloodType());
                holder.BloodNeededV.setText(model.getBloodTypeNeeded());
                holder.UnitsNeededV.setText(model.getUnitsNeeded());
                holder.BankNameV.setText(model.getNameOfBloodBank().substring(0,1).toUpperCase()+model.getNameOfBloodBank().substring(1));

            }

            @NonNull
            @Override
            public BloodReqViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

                View itemView = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.blood_row, parent, false);
                return new BloodReqViewHolder(itemView);
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

        myRef.child(key).removeValue();
    }


}