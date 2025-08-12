package com.example.eventplannerapp;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.R;

public class EventEditFragment extends Fragment {

    private static final String ARG_EVENT_POSITION = "arg_event_position";

    private EditText etName, etDate, etLocation, etDescription;
    private ImageView imgEventPhoto;
    private Button btnSave;


    private int eventPosition;
    private Event event;

    public static EventEditFragment newInstance(int position) {
        EventEditFragment fragment = new EventEditFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_EVENT_POSITION, position);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_event_edit, container, false);

        imgEventPhoto = view.findViewById(R.id.imgEventPhoto);
        etName = view.findViewById(R.id.etEventName);
        etDate = view.findViewById(R.id.etEventDate);
        etLocation = view.findViewById(R.id.etEventLocation);
        etDescription = view.findViewById(R.id.etEventDescription);
        btnSave = view.findViewById(R.id.btnSave);
        ImageButton btnDelete = view.findViewById(R.id.btnDeleteEvent);

        if (getArguments() != null) {
            eventPosition = getArguments().getInt(ARG_EVENT_POSITION, -1);
            if (eventPosition != -1) {
                event = AddEventFragment.eventList.get(eventPosition);
            }
        }

        if (event != null) {
            //imgEventPhoto.setImageResource(event.getImageResId());
            etName.setText(event.getName());
            etDate.setText(event.getDate());
            etLocation.setText(event.getLocation());
            etDescription.setText(event.getDescription());
        }
        btnDelete.setOnClickListener(v -> {
            // حذف الفعالية من القائمة المشتركة
            AddEventFragment.eventList.remove(eventPosition);

            // الرجوع لقائمة الفعاليات
            requireActivity().getSupportFragmentManager().popBackStack();
        });
        btnSave.setOnClickListener(v -> {
            String newName = etName.getText().toString().trim();
            String newDate = etDate.getText().toString().trim();
            String newLocation = etLocation.getText().toString().trim();
            String newDescription = etDescription.getText().toString().trim();

            if (TextUtils.isEmpty(newName) || TextUtils.isEmpty(newDate) || TextUtils.isEmpty(newLocation)) {
                Toast.makeText(getContext(), "يرجى ملء الاسم، التاريخ، والمكان", Toast.LENGTH_SHORT).show();
                return;
            }

            // تحديث بيانات الحدث في القائمة المشتركة
            event = AddEventFragment.eventList.get(eventPosition);
            event.setName(newName);
            event.setDate(newDate);
            event.setLocation(newLocation);
            event.setDescription(newDescription);

            Toast.makeText(getContext(), "تم حفظ التعديلات", Toast.LENGTH_SHORT).show();
        });



        return view;
    }
}
