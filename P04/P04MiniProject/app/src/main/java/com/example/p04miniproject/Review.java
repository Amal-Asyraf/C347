package com.example.p04miniproject;

public class Review {
    private int id;
    private String description;
    private int stars;

    public Review(int id, String description, int stars) {
        this.id = id;
        this.description = description;
        this.stars = stars;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public int getStars() {
        return stars;
    }

}
