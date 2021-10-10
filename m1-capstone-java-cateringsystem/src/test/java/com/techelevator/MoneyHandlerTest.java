package com.techelevator;

import com.techelevator.view.MoneyHandler;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MoneyHandlerTest {

    private MoneyHandler moneyHandler;
    private static final int MAX_BALANCE = 4500;
    private int balance;

    @Before
    public void setup() {
        moneyHandler = new MoneyHandler();
    }

    @Test
    public void adding_money() {
        int moneyToAdd = 250;
        moneyHandler.addMoney(moneyToAdd);

        double expectedBalance = balance + moneyToAdd;
        double actualBalance = moneyHandler.getBalance();

        Assert.assertEquals(expectedBalance, actualBalance, .09);
    }

    @Test
    public void adding_money_at_max_balance() {
        balance = MAX_BALANCE;
        moneyHandler.addMoney(balance);

        double expectedBalance = balance;
        double actualBalance = MAX_BALANCE;

        Assert.assertEquals(expectedBalance, actualBalance, .09);
    }

    @Test
    public void deducting_money() {
        double amountToDeduct = 500.0;
        double startingBalance = 500.0;
        moneyHandler.deductMoney(amountToDeduct);

        double expectedBalance = startingBalance - amountToDeduct;
        double actualBalance = 0;

        Assert.assertEquals(expectedBalance, actualBalance, .09);
    }

    @Test
    public void reset_balance() {
        double result = 0;
        moneyHandler.resetBalance();

        double expectedBalance = result;
        double actualBalance = moneyHandler.getBalance();

        Assert.assertEquals(expectedBalance, actualBalance, .09);
    }

    @Test
    public void make_change() {
        int moneyToAdd = 500;
        moneyHandler.addMoney(moneyToAdd);

        double moneyToDeduct = 400.50;
        moneyHandler.deductMoney(moneyToDeduct);

        double expectedBalance = moneyToAdd - moneyToDeduct;
        double actualBalance = moneyHandler.getBalance();

        Assert.assertEquals(expectedBalance, actualBalance, .09);
    }
}
