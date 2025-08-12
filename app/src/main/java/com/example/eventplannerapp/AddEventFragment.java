package com.example.eventplannerapp;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.myapplication.R;

import java.util.ArrayList;

public class AddEventFragment extends Fragment {

    private EditText etEventName, etEventDate, etEventLocation;
    private Button btnSaveEvent;

    // ArrayList لتخزين الأحداث مؤقتًا (يفضل نقلها لمكان مشترك لاحقًا)
    public static ArrayList<Event> eventList = new ArrayList<>();

    public AddEventFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_add_event, container, false);

        etEventName = view.findViewById(R.id.etEventName);
        etEventDate = view.findViewById(R.id.etEventDate);
        etEventLocation = view.findViewById(R.id.etEventLocation);
        btnSaveEvent = view.findViewById(R.id.btnSaveEvent);

        btnSaveEvent.setOnClickListener(v -> {
            String name = etEventName.getText().toString().trim();
            String date = etEventDate.getText().toString().trim();
            String location = etEventLocation.getText().toString().trim();

            if (TextUtils.isEmpty(name) || TextUtils.isEmpty(date) || TextUtils.isEmpty(location)) {
                Toast.makeText(getActivity(), "يرجى تعبئة جميع الحقول", Toast.LENGTH_SHORT).show();
            } else {
                // إنشاء كائن حدث جديد
                Event newEvent = new Event(name, date, location);

                // حفظ الحدث في القائمة
                eventList.add(newEvent);

                Toast.makeText(getActivity(), "تم حفظ الفعالية", Toast.LENGTH_SHORT).show();

                // مسح الحقول للادخال الجديد
                etEventName.setText("");
                etEventDate.setText("");
                etEventLocation.setText("");
            }
        });

        return view;
    }
}
