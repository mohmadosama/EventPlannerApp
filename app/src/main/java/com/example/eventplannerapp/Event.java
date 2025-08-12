package com.example.eventplannerapp;

import java.io.Serializable;

public class Event implements Serializable {
    private String name;
    private String date;
    private String location;
    private String description;
    private int imageResId;


    public Event(String name, String date, String location) {
        this.name = name;
        this.date = date;
        this.location = location;
    }

    public Event(String name, String date, String location, String description, int imageResId) {
        this.name = name;
        this.date = date;
        this.location = location;
        this.description = description;
        this.imageResId = imageResId;
    }

    public String getName() { return name; }
    public String getDate() { return date; }
    public String getLocation() { return location; }
    public String getDescription() { return description; }
    public int getImageResId() { return imageResId; }

    public void setName(String name) { this.name = name; }
    public void setDate(String date) { this.date = date; }
    public void setLocation(String location) { this.location = location; }
    public void setDescription(String description) { this.description = description; }

}
