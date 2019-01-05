package com.example.rathana.adapter_demo.model;

public class Product {
    String name;
    double price;
    int thumb;

    public Product() { }

    public Product(String name, double price, int thumb) {
        this.name = name;
        this.price = price;
        this.thumb = thumb;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getThumb() {
        return thumb;
    }

    public void setThumb(int thumb) {
        this.thumb = thumb;
    }
}
