package com.alozta.achievementhero;

import android.graphics.Color;
import java.util.Calendar;

/**
 * Created by alozta on 8/13/16.
 */
public class Entry {
    int id;
    String date;
    String entry;
    int color=Color.GRAY;

    public Entry(int id, String entry){
        this.id=id;
        this.entry=entry;
        date = Calendar.getInstance().getTime().toString();
    }

    public Entry(Integer id, String entry, String date, Integer color){
        this.id=id;
        this.entry=entry;
        this.date=date;
        this.color=color;
    }

    public Entry(){}

    public String getDate() {
        return date;
    }

    public int getId() {
        return id;
    }

    public String getEntry() {
        return entry;
    }

    public int getColor() {
        return color;
    }

    public void setEntry(String entry) {
        this.entry = entry;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
