package com.example.eventplannerapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.example.myapplication.R;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_navigation);

        // تعيين الفراجمنت الافتراضي عند بداية التطبيق
        loadFragment(new MainFragment());

        bottomNavigationView.setOnItemSelectedListener(item -> {
            Fragment selectedFragment = null;

            int id = item.getItemId();
            if (id == R.id.nav_main) {
                selectedFragment = new MainFragment();
            } else if (id == R.id.nav_add_event) {
                selectedFragment = new AddEventFragment();
            }else if (id == R.id.nav_event_list) {
                selectedFragment = new EventListFragment();
            } else if (id == R.id.nav_user_profile) {
                selectedFragment = new UserProfileFragment();
            } else if (id == R.id.nav_settings) {
                selectedFragment = new SettingsFragment();
            }


            return loadFragment(selectedFragment);
        });
    }
    private void showToast(String message) {
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
    }
    boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }
}
