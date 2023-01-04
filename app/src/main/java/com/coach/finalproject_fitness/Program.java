package com.coach.finalproject_fitness;

import java.util.ArrayList;

public class Program {
    String name;
    ArrayList<Workout> workouts;

    public Program(String name, ArrayList<Workout> workouts) {
        this.name = name;
        this.workouts = workouts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Workout> getWorkouts() {
        return workouts;
    }

    public void setWorkouts(ArrayList<Workout> workouts) {
        this.workouts = workouts;
    }
}
