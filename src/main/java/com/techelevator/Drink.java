package com.techelevator;

public class Drink extends Product {

    public Drink(String slotNumber, double price, String name) {
        super(slotNumber, price, name);
    }

    public String getSound(){
        return "Glug Glug, Yum!";
    }


}
