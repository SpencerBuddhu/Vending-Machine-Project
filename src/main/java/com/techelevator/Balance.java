package com.techelevator;

public class Balance {

    private double balance;

//***************************************
    public double getBalance() {
        return balance;
    }

    public void setBalance(double insertMoney) {

        balance = balance + insertMoney;
    }

    public void purchase(double itemPrice) {
        balance -= itemPrice;
    }

}
