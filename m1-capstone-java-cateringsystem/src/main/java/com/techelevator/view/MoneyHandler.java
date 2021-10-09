package com.techelevator.view;

public class MoneyHandler {

    // Member Variables
    private double balance = 0;
    private int twenties;  //20
    private int tens;  //10
    private int fives;  //5
    private int ones; //1
    private int quarters; //.25
    private int dimes; //.10
    private int nickels; //.05
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

    public void deductMoney(double amount) {
        balance -= amount;
    }

    public void getChange() {
        double balance = this.balance;
        twenties = (int) balance / 20;
        balance -= twenties * 20;

        tens = (int) balance / 10;
        balance -= tens * 10;

        fives = (int) balance / 5;
        balance -= fives * 5;

        ones = (int) balance;
        balance -= ones;

        quarters = (int) (balance / 0.25);
        balance -= quarters * 0.25;

        dimes = (int) (balance / 0.10);
        balance -= dimes * 0.10;

        nickels = (int) (balance / 0.05);
        balance -= nickels * 0.05;
    }

    public void reset_balance() {
        balance = 0;
    }

    //Getters
    public int getTwenties() {
        return twenties;
    }

    public int getTens() {
        return tens;
    }

    public int getFives() {
        return fives;
    }

    public double getBalance() {
        return balance;
    }

    public int getOnes() {
        return ones;
    }

    public int getQuarters() {
        return quarters;
    }

    public int getDimes() {
        return dimes;
    }

    public int getNickels() {
        return nickels;
    }
}
