package org.example;

public class Food {

    //name and price, ctx, getters

    //attributes
    private String name;
    private double price;

    //constructors
    public Food(String name, double price){
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
