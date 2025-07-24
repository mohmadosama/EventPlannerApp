package com.example.eventplannerapp;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Switch;
import android.widget.Toast;

import com.example.myapplication.R;

public class SettingsActivity extends AppCompatActivity {

    Switch switchNotifications, switchDarkMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        switchNotifications = findViewById(R.id.switchNotifications);
        switchDarkMode = findViewById(R.id.switchDarkMode);

        switchNotifications.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked)
                Toast.makeText(this, "تم تفعيل الإشعارات", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(this, "تم إيقاف الإشعارات", Toast.LENGTH_SHORT).show();
        });

        switchDarkMode.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked)
                Toast.makeText(this, "تم تفعيل الوضع الليلي (وهمي)", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(this, "تم إيقاف الوضع الليلي", Toast.LENGTH_SHORT).show();
        });
    }
}
