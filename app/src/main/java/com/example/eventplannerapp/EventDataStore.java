package com.example.eventplannerapp;

import java.util.ArrayList;

public class EventDataStore {
    public static ArrayList<Event> eventList = new ArrayList<>();
    public static ArrayList<Notification> notificationList = new ArrayList<>();
    public static void initialize() {
        if (notificationList.isEmpty()) {
            notificationList.add(new Notification("فعالية جديدة: معرض الابتكار الهندسي", "15-09-2025 10:00"));
            notificationList.add(new Notification("تم تعديل موعد ورشة الذكاء الاصطناعي", "12-09-2025 14:30"));
            notificationList.add(new Notification("تذكير: انطلاق ماراثون البرمجة بعد غد", "10-09-2025 09:00"));
            notificationList.add(new Notification("إلغاء: جلسة ريادة الأعمال لهذا الأسبوع", "08-09-2025 16:45"));
            notificationList.add(new Notification("فعالية قادمة: ملتقى المطورين العرب", "05-09-2025 11:15"));

        }
    }
}
