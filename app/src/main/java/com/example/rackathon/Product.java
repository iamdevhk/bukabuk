package com.example.rackathon;


public class Product {
    public String id;
    public String title;
    private String shortdesc;
    private double rating;
    private String price;
    private int image;
    private String dist;
    public String mail;

    public Product(String id, String title, String shortdesc, double rating, String price,String mail,String dist, int image) {
        this.id = id;
        this.title = title;
        this.shortdesc = shortdesc;
        this.rating = rating;
        this.price = price;
        this.mail=mail;
        this.dist=dist;
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getShortdesc() {
        return shortdesc;
    }

    public double getRating() {
        return rating;
    }

    public String getPrice() {
        return price;
    }
    public String getMail() {
        return mail;
    }
    public String getdist() {
        return dist;
    }

    public int getImage() {
        return image;
    }
}

