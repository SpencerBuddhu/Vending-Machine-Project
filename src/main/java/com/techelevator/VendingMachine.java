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





    public double readInventoryForPrice(String itemCode) {
        double itemPrice = 0.0;
        try (Scanner inventoryFile = new Scanner(inventory)) {
            while (inventoryFile.hasNextLine()) {
                String line = inventoryFile.nextLine();
                String[] productInfo = line.split("\\|");
                if (line.contains(itemCode)) {
                    return itemPrice = Double.parseDouble(productInfo[2]);
                } else {
                    System.out.println("Item code invalid");
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("There is no inventory");
        }
        return itemPrice;
    }
    

    public String inventoryItemLine(String itemCode) {
        String itemLine = "";
        try (Scanner inventoryFile = new Scanner(inventory)) {
            while (inventoryFile.hasNextLine()) {
                String line = inventoryFile.nextLine();
                String[] productInfo = line.split("\\|");
                Product lineProduct = new Product(productInfo[0], productInfo[1], productInfo[2], productInfo[3]);
                if (line.contains(itemCode)) {
                    return itemLine = productInfo[0] + " | " + productInfo[1];
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("There is no inventory");
        }
        return itemLine;
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
