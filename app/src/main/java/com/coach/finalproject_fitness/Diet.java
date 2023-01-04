package com.coach.finalproject_fitness;

public class Diet {

    private String day;
    private String meal;
    private String name;
    private String ingredients;

    public Diet(String day, String meal, String name, String ingredients) {
        this.day = day;
        this.meal = meal;
        this.name = name;
        this.ingredients = ingredients;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }
}
