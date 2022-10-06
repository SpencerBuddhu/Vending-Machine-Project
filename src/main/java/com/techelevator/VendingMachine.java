package com.techelevator;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class VendingMachine {

//    Product potatoChip = new Product();
    File inventory = new File("vendingmachine.csv");

//    public Map<Product> productArray = new ArrayList<>();


    public void readInventory() {
        try (Scanner inventoryFile = new Scanner(inventory)) {
                while (inventoryFile.hasNextLine()) {
                    String line = inventoryFile.nextLine();
                    String[] productInfo = line.split("\\|");
                    Product lineProduct = new Product(productInfo[0], productInfo[1], productInfo[2], productInfo[3]);
                    System.out.println(lineProduct.getSlotNumber() + " | " + lineProduct.getName() + " | " + lineProduct.getPrice() + " | " + lineProduct.getNumberOFItems());
                }
        } catch (FileNotFoundException e) {
            System.out.println("There is no inventory");
        }
    }



}
