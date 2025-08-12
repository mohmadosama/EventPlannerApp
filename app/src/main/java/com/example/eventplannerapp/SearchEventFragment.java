package com.example.eventplannerapp;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.R;

import java.util.ArrayList;

public class SearchEventFragment extends Fragment {

    private EditText etSearch;
    private ListView listViewSearchResults;
    private EventAdapter eventAdapter;

    private ArrayList<Event> fullEventList;
    private ArrayList<Event> filteredList;

    public SearchEventFragment() {
        // Required empty constructor
    }

    private TextView tvNoResults;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_search_event, container, false);

        etSearch = view.findViewById(R.id.etSearch);
        listViewSearchResults = view.findViewById(R.id.listViewSearchResults);
        tvNoResults = view.findViewById(R.id.tvNoResults);

        fullEventList = AddEventFragment.eventList;
        filteredList = new ArrayList<>();

        eventAdapter = new EventAdapter(getActivity(), filteredList);
        listViewSearchResults.setAdapter(eventAdapter);

        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                filterEvents(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        return view;
    }

    private void filterEvents(String query) {
        query = query.toLowerCase().trim();

        filteredList.clear();

        if (!query.isEmpty()) {
            for (Event event : fullEventList) {
                if (event.getName().toLowerCase().contains(query)) {
                    filteredList.add(event);
                }
            }
        }

        eventAdapter.notifyDataSetChanged();

        // إظهار أو إخفاء رسالة "لا توجد نتائج"
        if (filteredList.isEmpty()) {
            tvNoResults.setVisibility(View.VISIBLE);
            listViewSearchResults.setVisibility(View.GONE);
        } else {
            tvNoResults.setVisibility(View.GONE);
            listViewSearchResults.setVisibility(View.VISIBLE);
        }
    }
}
