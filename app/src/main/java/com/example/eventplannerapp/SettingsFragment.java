// SettingsFragment.java
package com.example.eventplannerapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.R;

public class SettingsFragment extends Fragment {

    Switch switchNotifications, switchDarkMode;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, 
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings, container, false);

        switchNotifications = view.findViewById(R.id.switchNotifications);
        switchDarkMode = view.findViewById(R.id.switchDarkMode);

        switchNotifications.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked)
                Toast.makeText(getActivity(), "تم تفعيل الإشعارات", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(getActivity(), "تم إيقاف الإشعارات", Toast.LENGTH_SHORT).show();
        });

        switchDarkMode.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked)
                Toast.makeText(getActivity(), "تم تفعيل الوضع الليلي (وهمي)", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(getActivity(), "تم إيقاف الوضع الليلي", Toast.LENGTH_SHORT).show();
        });

        return view;
    }
}
