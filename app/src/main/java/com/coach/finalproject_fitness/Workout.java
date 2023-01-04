package com.coach.finalproject_fitness;

import java.util.ArrayList;

public class Workout {
    String day;
    ArrayList<Exercise> exercises;

    public Workout(String day, ArrayList<Exercise> exercises) {
        this.day = day;
        this.exercises = exercises;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public ArrayList<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(ArrayList<Exercise> exercises) {
        this.exercises = exercises;
    }
}
