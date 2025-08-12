package com.example.eventplannerapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.R;

public class RateUsFragment extends Fragment {

    private RatingBar ratingBar;
    private Button btnSubmitRating;

    public RateUsFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // ربط ملف XML الخاص بالـ Fragment
        View view = inflater.inflate(R.layout.fragment_rate_us, container, false);

        // ربط العناصر
        ratingBar = view.findViewById(R.id.ratingBar);
        btnSubmitRating = view.findViewById(R.id.btnSubmitRating);

        // حدث الضغط على الزر
        btnSubmitRating.setOnClickListener(v -> {
            int rating = (int) ratingBar.getRating();
            if (rating == 0) {
                Toast.makeText(getActivity(), "يرجى اختيار تقييم قبل الإرسال", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getActivity(), "شكرًا على تقييمك: " + rating + " نجوم", Toast.LENGTH_SHORT).show();
                requireActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container, new MainFragment())
                        .commit();
            }
        });

        return view;
    }
}
