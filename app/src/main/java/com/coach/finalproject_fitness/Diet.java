package com.coach.finalproject_fitness;

public class Diet {

    private String day;
    private String meal;
    //private String name;
    //private String ingredients;


    public Diet(String day, String meal) {
        this.day = day;
        this.meal = meal;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getMeal() {
        return meal;
    }

    public void setMeal(String meal) {
        this.meal = meal;
    }
}
