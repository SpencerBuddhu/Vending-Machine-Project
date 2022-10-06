package com.techelevator;

public class Product {

    private int numberOFItems = 5;
    private String slotNumber;
    private String price;
    private String name;
    private String type;
    private String sound;


    public Product(String slotNumber, String name, String price, String type) {
        this.slotNumber = slotNumber;
        this.price = price;
        this.name = name;
        this.type = type;
    }

    public int getNumberOFItems() {
        return numberOFItems;
    }

    public String getSlotNumber() {
        return slotNumber;
    }

    public String getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    //****************

    //Setters
    public void setSlotNumber(String slotNumber) {
        this.slotNumber = slotNumber;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSound() {
        if (type.equals("Chip")) {
            sound = "Crunch Crunch, Yum!";
        } else if (type.equals("Candy")) {
            sound = "Munch Munch, Yum!";
        } else if (type.equals("Drink")) {
            sound = "Glug Glug, Yum!";
        } else if (type.equals("Gum")) {
            sound = "Chew Chew, Yum!";
        }
        return sound;
    }

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

