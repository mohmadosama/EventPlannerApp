package com.example.eventplannerapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.myapplication.R;

public class EventListFragment extends Fragment {

    private ListView listViewEvents;
    private EventAdapter eventAdapter;
    private TextView tvEmptyList;


    public EventListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_event_list, container, false);

        listViewEvents = view.findViewById(R.id.listViewEvents);
        tvEmptyList = view.findViewById(R.id.tvEmptyList);
        // ربط الـ Adapter مع الـ ArrayList من AddEventFragment
        eventAdapter = new EventAdapter(getActivity(), AddEventFragment.eventList);

        listViewEvents.setAdapter(eventAdapter);

        listViewEvents.setOnItemClickListener((parent, viewItem, position, id) -> {
            EventEditFragment editFragment = EventEditFragment.newInstance(position);

            requireActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, editFragment)
                    .addToBackStack(null)
                    .commit();
        });

        if (AddEventFragment.eventList.isEmpty()) {
            listViewEvents.setVisibility(View.GONE);
            tvEmptyList.setVisibility(View.VISIBLE);
        } else {
            listViewEvents.setVisibility(View.VISIBLE);
            tvEmptyList.setVisibility(View.GONE);
        }

        return view;
    }
}
