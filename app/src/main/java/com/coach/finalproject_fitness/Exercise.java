package com.coach.finalproject_fitness;

import androidx.annotation.NonNull;

public class Exercise {
    int repCount;
    int setCount;
    String name;

    public Exercise(int repCount, int setCount, String name) {
        this.repCount = repCount;
        this.setCount = setCount;
        this.name = name;
    }

    public int getRepCount() {
        return repCount;
    }

    public void setRepCount(int repCount) {
        this.repCount = repCount;
    }

    public int getSetCount() {
        return setCount;
    }

    public void setSetCount(int setCount) {
        this.setCount = setCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NonNull
    @Override
    public String toString() {
        return "Exercise{" +
                "repCount=" + repCount +
                ", setCount=" + setCount +
                ", name='" + name + '\'' +
                '}';
    }
}
