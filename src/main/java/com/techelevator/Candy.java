package com.techelevator;

public class Candy extends Product {

    public Candy(String slotNumber, double price, String name) {
        super(slotNumber, price, name);
    }

    public String getSound(){
        return "Munch Munch, Yum!";
    }


}
