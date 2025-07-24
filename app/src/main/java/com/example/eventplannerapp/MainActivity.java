package com.example.eventplannerapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class MainActivity extends AppCompatActivity {

    Button btnAddEvent, btnEventList, btnEventDetails, btnEditEvent, btnDeleteEvent,
            btnSearchEvent, btnSettings, btnAbout, btnHelp, btnRateUs,
            btnEventSchedule, btnNotifications, btnUserProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAddEvent = findViewById(R.id.btnAddEvent);
        btnEventList = findViewById(R.id.btnEventList);
        btnEventDetails = findViewById(R.id.btnEventDetails);
        btnEditEvent = findViewById(R.id.btnEditEvent);
        btnDeleteEvent = findViewById(R.id.btnDeleteEvent);
        btnSearchEvent = findViewById(R.id.btnSearchEvent);
        btnSettings = findViewById(R.id.btnSettings);
        btnAbout = findViewById(R.id.btnAbout);
        btnHelp = findViewById(R.id.btnHelp);
        btnRateUs = findViewById(R.id.btnRateUs);
        btnEventSchedule = findViewById(R.id.btnEventSchedule);
        btnNotifications = findViewById(R.id.btnNotifications);
        btnUserProfile = findViewById(R.id.btnUserProfile);

        btnAddEvent.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, AddEventActivity.class)));

        btnSettings.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, SettingsActivity.class)));
        btnAbout.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, AboutActivity.class)));
        btnHelp.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, HelpActivity.class)));
        btnRateUs.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, RateUsActivity.class)));
//
        btnUserProfile.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, UserProfileActivity.class)));


        btnEventList.setOnClickListener(v -> showToast("قيد البرمجة"));
        btnEventDetails.setOnClickListener(v -> showToast("قيد البرمجة"));
        btnEditEvent.setOnClickListener(v -> showToast("قيد البرمجة"));
        btnDeleteEvent.setOnClickListener(v -> showToast("قيد البرمجة"));
        btnSearchEvent.setOnClickListener(v -> showToast("قيد البرمجة"));
        btnEventSchedule.setOnClickListener(v -> showToast("قيد البرمجة"));
        btnNotifications.setOnClickListener(v -> showToast("قيد البرمجة"));


    }


    private void showToast(String message) {
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
    }
}
