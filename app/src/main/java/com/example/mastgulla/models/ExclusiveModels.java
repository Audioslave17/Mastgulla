package com.example.mastgulla.models;

public class ExclusiveModels {
    int image;
    String name;
    String location;
    String rating;

    public ExclusiveModels(int image, String name, String location, String rating) {
        this.image = image;
        this.name = name;
        this.location = location;
        this.rating = rating;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
