package com.example.eventplannerapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.R;

import java.util.ArrayList;

public class NotificationsFragment extends Fragment {

    private ListView listViewNotifications;
    private TextView tvEmptyNotifications;
    private NotificationAdapter notificationAdapter;

    private ArrayList<Notification> notificationList = new ArrayList<>();

    public NotificationsFragment() {}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_notifications, container, false);
        listViewNotifications = view.findViewById(R.id.listViewNotifications);
        tvEmptyNotifications = view.findViewById(R.id.tvEmptyNotifications);

        EventDataStore.initialize();
        notificationList = EventDataStore.notificationList;
        notificationAdapter = new NotificationAdapter(getActivity(), notificationList);
        listViewNotifications.setAdapter(notificationAdapter);
        if(notificationList.isEmpty()) {
            listViewNotifications.setVisibility(View.GONE);
            tvEmptyNotifications.setVisibility(View.VISIBLE);
        } else {
            listViewNotifications.setVisibility(View.VISIBLE);
            tvEmptyNotifications.setVisibility(View.GONE);
        }


//
//        notificationList.add(new Notification("فعالية جديدة: مؤتمر التقنية", "20-08-2025 15:00"));
//        notificationList.add(new Notification("تم تعديل موعد فعالية الورشة", "19-08-2025 10:30"));
//        notificationList.add(new Notification("تذكير: فعالية الرياضة غداً", "18-08-2025 09:00"));
//
//        notificationAdapter = new NotificationAdapter(getActivity(), notificationList);
//        listViewNotifications.setAdapter(notificationAdapter);
//
//        if(notificationList.isEmpty()) {
//            listViewNotifications.setVisibility(View.GONE);
//            tvEmptyNotifications.setVisibility(View.VISIBLE);
//        } else {
//            listViewNotifications.setVisibility(View.VISIBLE);
//            tvEmptyNotifications.setVisibility(View.GONE);
//        }

        return view;
    }
}
