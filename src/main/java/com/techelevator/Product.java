package com.techelevator;

public abstract class Product {

    private int numberOFItems = 5;
    private String slotNumber;
    private double price;
    private String name;


    public Product(String slotNumber, double price, String name) {
        this.slotNumber = slotNumber;
        this.price = price;
        this.name = name;
    }

    public int getNumberOFItems() {
        return numberOFItems;
    }

    public String getSlotNumber() {
        return slotNumber;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public abstract String getSound();

    public void purchase(){
        numberOFItems = numberOFItems - 1;
    }

    public boolean canPurchase(){
        if(this.numberOFItems >= 1) {
            return true;
        } else {
            return false;
        }

    }


}

