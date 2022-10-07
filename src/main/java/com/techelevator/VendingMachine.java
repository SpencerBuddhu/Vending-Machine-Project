package com.techelevator;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VendingMachine {

    File inventory = new File("vendingmachine.csv");

    public List<Product> products = new ArrayList<>();

    public void printInventory() {
        for (Product itemInfo : products) {
            System.out.println(itemInfo.getSlotNumber() + " | " + itemInfo.getName() + " | " + itemInfo.getPrice() + " | " + itemInfo.getNumberOFItems());
        }
    }


    public double readInventoryForPrice(String itemCode) {
        double itemPrice = 0.0;
        try {
            for (Product itemInfo : products) {
                if (itemInfo.getSlotNumber().equals(itemCode)) {
                    return Double.parseDouble(itemInfo.getPrice());
                }
            }
        } catch (Exception e) {
            System.out.println("Item code invalid");
        }
        return itemPrice;
    }


    public String inventoryItemLine(String itemCode) {
        String itemLine = "";
        try {
            for (Product itemInfo : products) {
                if (itemInfo.getSlotNumber().equals(itemCode)) {
                    itemLine = itemInfo.getSlotNumber() + " | " + itemInfo.getName();  //ADD REMAINING PRODUCT HERE
                }
            }
        } catch (Exception e) {
            System.out.println("Item code invalid");
        }
        return itemLine;
    }


    public String itemSound(String itemCode) {
        String sound = "";
        try {
            for (Product itemInfo : products) {
                if (itemInfo.getSlotNumber().equals(itemCode)) {
                    sound = itemInfo.getSound();
                }
            }
        } catch (Exception e) {
            System.out.println("Item code invalid");
        }
        return sound;
    }


    public void addToInventoryList() {
        try (Scanner inventoryFile = new Scanner(inventory)) {
            while (inventoryFile.hasNextLine()) {
                String line = inventoryFile.nextLine();
                String[] productInfo = line.split("\\|");
                Product lineProduct = new Product(productInfo[0], productInfo[1], productInfo[2], productInfo[3]);
                products.add(lineProduct);
            }
        } catch (FileNotFoundException e) {
            System.out.println("There is no inventory");
        }
    }
}
