package com.example.finaltest;

public class placeDetails {
    private String placeName;
    private String imageName;
    private double price;

    public placeDetails(String placeName, String imageName, double price) {
        this.placeName = placeName;
        this.imageName = imageName;
        this.price = price;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
