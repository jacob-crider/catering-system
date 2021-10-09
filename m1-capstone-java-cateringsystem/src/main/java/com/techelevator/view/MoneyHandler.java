package com.techelevator.view;

public class MoneyHandler {

    // Member Variables
    private double balance = 0;
    private int hundreds;
    private int fifties;
    private int twenties;
    private int tens;
    private int fives;
    private int singles;
    private static final int MAX_BALANCE = 4500;

    //Methods

    // 3 Functions:
    //deposit funds
    //return change (member variables)
    //return to zero at end of the transaction

    public void addMoney(int amountToAdd) {
        if (balance < MAX_BALANCE) {
            balance += amountToAdd;
        }
        if (balance >= MAX_BALANCE) {
            balance = MAX_BALANCE;
        }
    }

    //Getters
    public int getHundreds() {
        return hundreds;
    }

    public int getFifties() {
        return fifties;
    }

    public int getTwenties() {
        return twenties;
    }

    public int getTens() {
        return tens;
    }

    public int getFives() {
        return fives;
    }

    public int getSingles() {
        return singles;
    }

    public double getBalance() {
        return balance;
    }
}
