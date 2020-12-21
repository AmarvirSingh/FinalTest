package com.example.finaltest;

public class details {
    private String countryName;
    private String capitalName;
    private String flagImage;
    private String place;
    private String placeImage;
    private double price;

    public details(String countryName, String capitalName, String flagImage, String place, String placeImage, double price) {
        this.countryName = countryName;
        this.capitalName = capitalName;
        this.flagImage = flagImage;
        this.place = place;
        this.placeImage = placeImage;
        this.price = price;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCapitalName() {
        return capitalName;
    }

    public void setCapitalName(String capitalName) {
        this.capitalName = capitalName;
    }

    public String getFlagImage() {
        return flagImage;
    }

    public void setFlagImage(String flagImage) {
        this.flagImage = flagImage;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getPlaceImage() {
        return placeImage;
    }

    public void setPlaceImage(String placeImage) {
        this.placeImage = placeImage;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
