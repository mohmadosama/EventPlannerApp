// UserProfileFragment.java
package com.example.eventplannerapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.R;

public class UserProfileFragment extends Fragment {

    ImageView imgProfilePic;
    TextView tvUserName, tvUserEmail;
    Button btnEditProfile;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, 
                             @Nullable ViewGroup container, 
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user_profile, container, false);

        imgProfilePic = view.findViewById(R.id.imgProfilePic);
        tvUserName = view.findViewById(R.id.tvUserName);
        tvUserEmail = view.findViewById(R.id.tvUserEmail);
        btnEditProfile = view.findViewById(R.id.btnEditProfile);

        btnEditProfile.setOnClickListener(v -> 
            Toast.makeText(getActivity(), "خاصية تعديل الملف الشخصي (وهمية حالياً)", Toast.LENGTH_SHORT).show()
        );

        return view;
    }
}
