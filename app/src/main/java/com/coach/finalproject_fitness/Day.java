package com.coach.finalproject_fitness;

import androidx.annotation.NonNull;

public class Day {

    private String day;
    private boolean isSelected;

    public Day(String day, boolean isSelected) {
        this.day = day;
        this.isSelected = isSelected;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    @NonNull
    @Override
    public String toString() {
        return day + " : " + isSelected ;
    }
}
