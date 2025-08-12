package com.example.eventplannerapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.example.myapplication.R;

public class MainFragment extends Fragment {
    Button  btnHelp, btnRateUs,btnAbout;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // ربط الفراجمنت مع واجهته xml
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        btnHelp  = view.findViewById(R.id.btnHelp);
        btnAbout  = view.findViewById(R.id.btnAbout);
        btnRateUs  = view.findViewById(R.id.btnRateUs);
        Button btnSearchEvent = view.findViewById(R.id.btnSearchEvent);
        Button btnNotificationsEvent = view.findViewById(R.id.btnNotificationsEvent);

        btnSearchEvent.setOnClickListener(v -> {
            // استبدل الـ Fragment الحالي بـ SearchEventFragment
            getParentFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, new SearchEventFragment())
                    .addToBackStack(null)  // حتى تقدر ترجع بالزر الخلفي
                    .commit();
        });
        btnHelp.setOnClickListener(v -> {
            ((MainActivity) getActivity()).loadFragment(new HelpFragment());
        });
        btnAbout.setOnClickListener(v -> {
            ((MainActivity) getActivity()).loadFragment(new AboutFragment());
        });
        btnRateUs.setOnClickListener(v -> {
            ((MainActivity) getActivity()).loadFragment(new RateUsFragment());
        });
        btnNotificationsEvent.setOnClickListener(v -> {
            ((MainActivity) getActivity()).loadFragment(new NotificationsFragment());
        });

        return view;
    }

}
