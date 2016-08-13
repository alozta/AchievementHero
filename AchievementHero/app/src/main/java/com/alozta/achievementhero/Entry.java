package com.alozta.achievementhero;

import android.graphics.Color;

import java.util.Calendar;

/**
 * Created by alozta on 8/13/16.
 */
public class Entry {
    Calendar date;
    String entry;
    int color=Color.GRAY;

    public Entry(String entry){
        this.entry=entry;
        date = Calendar.getInstance();
    }

    public void changeColor(int color){
        this.color=color;
    }
}
