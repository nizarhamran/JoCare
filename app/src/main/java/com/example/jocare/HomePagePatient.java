package com.example.jocare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jocare.Model.Reminder;
import com.example.jocare.ViewHolder.ReminderViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.annotations.Nullable;

public class HomePagePatient extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    //NewsFeed
    TextView news1, news2, news3, news4, news5;
    //Drawer Menu
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ImageView menuIcon;
    ImageView userInfo;
    ImageView askForblood;
    //Variables
    static final float END_SCALE = 0.7f;
    ConstraintLayout contentView;
    TextView medicationAdd;
    //Care Guidelines
    ImageView bodyCare, hairCare, dentalCare, skinCare;
    //panic
    ImageView Panic_Button;
    private static final int REQUEST_CALL = 1;
    TextView call_panic,ccp_panic;
   // DatabaseReference callRef;
    //Recycler Med
    RecyclerView recyclerView;
    FirebaseDatabase database;
    DatabaseReference reminderDb;
    FirebaseRecyclerOptions<Reminder> options;
    FirebaseRecyclerAdapter<Reminder, ReminderViewHolder> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page_patient);

        Intent intent = getIntent();
       String PNID = intent.getStringExtra("PID");


       askForblood=findViewById(R.id.askBlood);
       askForblood.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(HomePagePatient.this,AskForBlood.class);
               intent.putExtra("PID",PNID);
               startActivity(intent);
           }
       });
        //News
        news1 = findViewById(R.id.news1);
        news1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ns1 = new Intent(HomePagePatient.this, News1.class);
                ns1.putExtra("PID",PNID);
                startActivity(ns1);
            }
        });
        news2 = findViewById(R.id.news2);
        news2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ns2 = new Intent(HomePagePatient.this, News2.class);
                ns2.putExtra("PID",PNID);
                startActivity(ns2);
            }
        });
        news3 = findViewById(R.id.news3);
        news3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ns3 = new Intent(HomePagePatient.this, News3.class);
                ns3.putExtra("PID",PNID);
                startActivity(ns3);
            }
        });
        news4 = findViewById(R.id.news4);
        news4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ns4 = new Intent(HomePagePatient.this, News4.class);
                ns4.putExtra("PID",PNID);
                startActivity(ns4);
            }
        });
        news5 = findViewById(R.id.news5);
        news5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ns5 = new Intent(HomePagePatient.this, News5.class);
                ns5.putExtra("PID",PNID);
                startActivity(ns5);
            }
        });


        //User Information
        userInfo = findViewById(R.id.userInfo);
        userInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent userIn = new Intent(HomePagePatient.this, UserInformation.class);
                userIn.putExtra("userId",PNID);
                startActivity(userIn);
            }
        });
        //Care
        bodyCare = findViewById(R.id.bodyCare);
        bodyCare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent bodyIn = new Intent(HomePagePatient.this, BodyCare.class);
                bodyIn.putExtra("PID",PNID);
                startActivity(bodyIn);
            }
        });
        hairCare = findViewById(R.id.hairCare);
        hairCare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent hairIn = new Intent(HomePagePatient.this, HairCare.class);
                hairIn.putExtra("PID",PNID);
                startActivity(hairIn);
            }
        });
        dentalCare = findViewById(R.id.dentalCare);
        dentalCare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dentalIn = new Intent(HomePagePatient.this, DentalCare.class);
                dentalIn.putExtra("PID",PNID);
                startActivity(dentalIn);
            }
        });
        skinCare = findViewById(R.id.skinCare);
        skinCare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent skinIn = new Intent(HomePagePatient.this, SkinCare.class);
                skinIn.putExtra("PID",PNID);
                startActivity(skinIn);
            }
        });

        contentView = findViewById(R.id.content);
        //Medication connect
        medicationAdd = findViewById(R.id.MedicationAdd);
        medicationAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent medIntent = new Intent(HomePagePatient.this, MedicationReminder.class);
                medIntent.putExtra("medId",PNID);
                startActivity(medIntent);
            }
        });
        //Menu Hooks
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);
        menuIcon = findViewById(R.id.menu_icon);
        navigationDrawer();
        //Recycler MView
        database = FirebaseDatabase.getInstance();
        reminderDb = database.getReference("Users").child(PNID).child("Reminder");
        LinearLayoutManager layoutManager = new LinearLayoutManager(
                HomePagePatient.this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        showReminder();

        //panic_button
        call_panic = findViewById(R.id.call_panic);
        ccp_panic= findViewById(R.id.ccp_panic);
        //Database
        reminderDb = FirebaseDatabase.getInstance().getReference("Users").child(PNID);
        reminderDb.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@Nullable DataSnapshot snapshot) {
                String callP = snapshot.child("emr").getValue().toString();
                String ccP = snapshot.child("ccpE").getValue().toString();
                call_panic.setText(callP);
                ccp_panic.setText(ccP);
            }

            @Override
            public void onCancelled(@Nullable DatabaseError error) {

            }
        });
        //panicCall
        Panic_Button = findViewById(R.id.Panic_Button);
        Panic_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makePhoneCall();
            }
        });
    }

    private void makePhoneCall() {
        String number = call_panic.getText().toString();
        String cc_number = ccp_panic.getText().toString();

        if (number.trim().length() > 0) {

            if (ContextCompat.checkSelfPermission(HomePagePatient.this,
                    Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(HomePagePatient.this,
                        new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);
            } else {
                String dial = "tel:"+ cc_number + number;
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
            }

        } else {
            Toast.makeText(HomePagePatient.this, "Enter Phone Number", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQUEST_CALL) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                makePhoneCall();
            } else {
                Toast.makeText(this, "Permission DENIED", Toast.LENGTH_SHORT).show();
            }
        }
    }


    //Navigation Drawer Functions
    private void navigationDrawer() {
        //Navigation Drawer
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        //if you want one of them to be selected
        navigationView.setCheckedItem(R.id.nav_personal);
        menuIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawerLayout.isDrawerOpen(GravityCompat.START))
                    drawerLayout.closeDrawer(GravityCompat.START);
                else drawerLayout.openDrawer(GravityCompat.START);
            }
        });
        animateNavigationDrawer();
    }

    private void animateNavigationDrawer() {
        drawerLayout.setScrimColor(getResources().getColor(R.color.blue));
        drawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {
                // Scale the View based on current slide offset
                final float diffScaledOffset = slideOffset * (1 - END_SCALE);
                final float offsetScale = 1 - diffScaledOffset;
                contentView.setScaleX(offsetScale);
                contentView.setScaleY(offsetScale);
                // Translate the View, accounting for the scaled width
                final float xOffset = drawerView.getWidth() * slideOffset;
                final float xOffsetDiff = contentView.getWidth() * diffScaledOffset / 2;
                final float xTranslation = xOffset - xOffsetDiff;
                contentView.setTranslationX(xTranslation);
            }

            @Override
            public void onDrawerOpened(@NonNull View drawerView) {
            }

            @Override
            public void onDrawerClosed(@NonNull View drawerView) {
            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });
    }

    @Override
    public void onBackPressed() {

        if (drawerLayout.isDrawerVisible(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else
            super.onBackPressed();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
         Intent intent = getIntent();
        String PNID = intent.getStringExtra("PID");
        if (id == R.id.nav_personal) {
            Intent i =new Intent(HomePagePatient.this, PersonalInformation.class);
             i.putExtra("PID",PNID);
            startActivity(i);
        } else if (id == R.id.nav_reports) {
            Intent p = new Intent (HomePagePatient.this,medical_permission.class);
            p.putExtra("PID",PNID);
            startActivity(p);

        } else if (id == R.id.nav_panic) {
           Intent p = new Intent(HomePagePatient.this, PanicButton.class);
           p.putExtra("PID",PNID);
            startActivity(p);
        } else if (id == R.id.nav_about) {
           Intent AB = new Intent(HomePagePatient.this, AboutJoCare.class);
           AB.putExtra("PID",PNID);
            startActivity(AB);
        } else if (id == R.id.nav_disclaimer) {
            Intent p= new Intent(HomePagePatient.this, Disclaimer.class);
            p.putExtra("PID",PNID);
            startActivity(p);
        } else if (id == R.id.nav_terms) {
         Intent p= new Intent(HomePagePatient.this, Conditions.class);
            p.putExtra("PID",PNID);
         startActivity(p);
        } else if (id == R.id.nav_policy) {
           Intent p = new Intent(HomePagePatient.this, PrivacyPolicy.class);
            p.putExtra("PID",PNID);
            startActivity(p);
        } else if (id == R.id.nav_logout) {
           Intent p = new Intent(HomePagePatient.this, SignIn.class);

            startActivity(p);
        }
        return true;
    }


    private void showReminder() {
        options = new FirebaseRecyclerOptions.Builder<Reminder>()
                .setQuery(reminderDb, Reminder.class)
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

}

