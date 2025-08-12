package com.example.eventplannerapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.myapplication.R;

import java.util.ArrayList;

public class NotificationAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Notification> notificationList;

    public NotificationAdapter(Context context, ArrayList<Notification> notificationList) {
        this.context = context;
        this.notificationList = notificationList;
    }

    @Override
    public int getCount() {
        return notificationList.size();
    }

    @Override
    public Object getItem(int position) {
        return notificationList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    static class ViewHolder {
        TextView tvMessage, tvDateTime;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_notification, parent, false);
            holder = new ViewHolder();
            holder.tvMessage = convertView.findViewById(R.id.tvNotificationMessage);
            holder.tvDateTime = convertView.findViewById(R.id.tvNotificationDateTime);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Notification notification = notificationList.get(position);
        holder.tvMessage.setText(notification.getMessage());
        holder.tvDateTime.setText(notification.getDateTime());

        return convertView;
    }
}
