package com.example.mvp.models;

public class Garage {

    private String garage_name;
    private  int garage_rating;
    private int garage_image;

    public Garage(String garage_name, int garage_rating, int garage_image) {
        this.garage_image = garage_image;
        this.garage_name = garage_name;
        this.garage_rating = garage_rating;
    }
    public  String getGarage_name() {
        return garage_name;

    }
    public void setGarage_name (String garage_name) {
        this.garage_name = garage_name;
    }
    public int getGarage_rating () {
        return garage_rating;

    }

    public void setGarage_rating (int garage_rating) {
        this.garage_rating = garage_rating;
    }

    public int getGarage_image () {
        return garage_image;
    }

    public void setGarage_image(int garage_image) {
        this.garage_image = garage_image;
    }
}
