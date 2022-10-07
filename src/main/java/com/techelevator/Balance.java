package com.techelevator;

public class Balance {

    private double balance = 0;

//***************************************
    public double getBalance() {
        return balance;
    }

    public void setBalance(double insertMoney) {

        this.balance = balance + insertMoney;
    }

    public void purchase(double itemPrice) {
        balance -= itemPrice;
    }

}
