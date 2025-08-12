package com.example.eventplannerapp;

import java.io.Serializable;

public class Notification implements Serializable {
    private String message;
    private String dateTime;

    public Notification(String message, String dateTime) {
        this.message = message;
        this.dateTime = dateTime;
    }

    public String getMessage() {
        return message;
    }

    public String getDateTime() {
        return dateTime;
    }
}
