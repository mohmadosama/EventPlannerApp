package com.example.eventplannerapp;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;

public class UserProfileActivity extends AppCompatActivity {

    ImageView imgProfilePic;
    TextView tvUserName, tvUserEmail;
    Button btnEditProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        imgProfilePic = findViewById(R.id.imgProfilePic);
        tvUserName = findViewById(R.id.tvUserName);
        tvUserEmail = findViewById(R.id.tvUserEmail);
        btnEditProfile = findViewById(R.id.btnEditProfile);

        btnEditProfile.setOnClickListener(view ->
                Toast.makeText(this, "خاصية تعديل الملف الشخصي (وهمية حالياً)", Toast.LENGTH_SHORT).show()
        );
    }
}
