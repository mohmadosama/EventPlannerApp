package com.example.eventplannerapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.myapplication.R;

import java.util.ArrayList;

public class EventAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Event> eventArrayList;

    public EventAdapter(Context context, ArrayList<Event> eventArrayList) {
        this.context = context;
        this.eventArrayList = eventArrayList;
    }

    @Override
    public int getCount() {
        return eventArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return eventArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_event, parent, false);
            holder = new ViewHolder();
            holder.tvName = convertView.findViewById(R.id.tvEventName);
            holder.tvDate = convertView.findViewById(R.id.tvEventDate);
            holder.tvLocation = convertView.findViewById(R.id.tvEventLocation);
//            holder.btnDelete = convertView.findViewById(R.id.btnDeleteEvent);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Event event = eventArrayList.get(position);

        holder.tvName.setText(event.getName());
        holder.tvDate.setText(event.getDate());
        holder.tvLocation.setText(event.getLocation());

//        holder.btnDelete.setOnClickListener(v -> {
//            // حذف العنصر من القائمة
//            eventArrayList.remove(position);
//            // تحديث العرض
//            notifyDataSetChanged();
//        });

        return convertView;
    }

    private static class ViewHolder {
        TextView tvName, tvDate, tvLocation;
        ImageButton btnDelete;
    }


}
