package com.example.jocare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
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
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class HomePagePatient extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    //NewsFeed
    TextView news1, news2, news3, news4, news5;
    //Drawer Menu
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ImageView menuIcon;
    ImageView userInfo;
    //Variables
    static final float END_SCALE = 0.7f;
    ConstraintLayout contentView;
    TextView medicationAdd;
    //Care Guidelines
    ImageView bodyCare, hairCare, dentalCare, skinCare;
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


        //News
        news1 = findViewById(R.id.news1);
        news1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ns1 = new Intent(HomePagePatient.this, News1.class);
                startActivity(ns1);
            }
        });
        news2 = findViewById(R.id.news2);
        news2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ns2 = new Intent(HomePagePatient.this, News2.class);
                startActivity(ns2);
            }
        });
        news3 = findViewById(R.id.news3);
        news3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ns3 = new Intent(HomePagePatient.this, News3.class);
                startActivity(ns3);
            }
        });
        news4 = findViewById(R.id.news4);
        news4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ns4 = new Intent(HomePagePatient.this, News4.class);
                startActivity(ns4);
            }
        });
        news5 = findViewById(R.id.news5);
        news5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ns5 = new Intent(HomePagePatient.this, News5.class);
                startActivity(ns5);
            }
        });


        //User Information
        userInfo = findViewById(R.id.userInfo);
        userInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent userIn = new Intent(HomePagePatient.this, UserInformation.class);
                startActivity(userIn);
            }
        });
        //Care
        bodyCare = findViewById(R.id.bodyCare);
        bodyCare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent bodyIn = new Intent(HomePagePatient.this, BodyCare.class);
                startActivity(bodyIn);
            }
        });
        hairCare = findViewById(R.id.hairCare);
        hairCare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent hairIn = new Intent(HomePagePatient.this, HairCare.class);
                startActivity(hairIn);
            }
        });
        dentalCare = findViewById(R.id.dentalCare);
        dentalCare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dentalIn = new Intent(HomePagePatient.this, DentalCare.class);
                startActivity(dentalIn);
            }
        });
        skinCare = findViewById(R.id.skinCare);
        skinCare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent skinIn = new Intent(HomePagePatient.this, SkinCare.class);
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
        reminderDb = database.getReference("Reminder");
        LinearLayoutManager layoutManager = new LinearLayoutManager(
                HomePagePatient.this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        showReminder();
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
        if (id == R.id.nav_personal) {
            startActivity(new Intent(HomePagePatient.this, PersonalInformation.class));
        } else if (id == R.id.nav_reports) {

        } else if (id == R.id.nav_panic) {
            startActivity(new Intent(HomePagePatient.this, PanicButton.class));
        } else if (id == R.id.nav_about) {
            startActivity(new Intent(HomePagePatient.this, AboutJoCare.class));
        } else if (id == R.id.nav_disclaimer) {
            startActivity(new Intent(HomePagePatient.this, Disclaimer.class));
        } else if (id == R.id.nav_terms) {
            startActivity(new Intent(HomePagePatient.this, Conditions.class));
        } else if (id == R.id.nav_policy) {
            startActivity(new Intent(HomePagePatient.this, PrivacyPolicy.class));
        } else if (id == R.id.nav_logout) {
            startActivity(new Intent(HomePagePatient.this, SignIn.class));
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
                holder.text_name.setText(model.getName());
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

