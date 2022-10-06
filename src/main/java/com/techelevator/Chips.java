package com.techelevator;

public class Chips extends Product {

    public Chips(String slotNumber, double price, String name) {
        super(slotNumber, price, name);
    }

    public String getSound(){
        return "Crunch Crunch, Yum!";
    }

}
