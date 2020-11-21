package com.example.harvest_calendar;

import com.github.javafaker.Faker;

public class WeeklyChallenge {
    Faker faker = new Faker();
    String currChallenge = "";

    public void setChallenge() {
        String ingredient = faker.food().ingredient();
        currChallenge = "Weekly Harvest Mission:\n" + ingredient;
    }

    public String getChallenge() { return currChallenge; }

}
