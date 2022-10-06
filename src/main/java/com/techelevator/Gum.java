package com.techelevator;

public class Gum extends Product {

    public Gum(String slotNumber, double price, String name) {
        super(slotNumber, price, name);
    }

    public String getSound(){
        return "Chew Chew, Yum!";
    }

}
