package com.example.eventplannerapp;


import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

import com.example.myapplication.R;

public class RateUsActivity extends AppCompatActivity {

    RatingBar ratingBar;
    Button btnSubmitRating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate_us);

        ratingBar = findViewById(R.id.ratingBar);
        btnSubmitRating = findViewById(R.id.btnSubmitRating);

        btnSubmitRating.setOnClickListener(view -> {
            int rating = (int) ratingBar.getRating();
            if (rating == 0) {
                Toast.makeText(this, "يرجى اختيار تقييم قبل الإرسال", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "شكرًا على تقييمك: " + rating + " نجوم", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
