package com.techelevator.items;

/*
    This represents a single catering item in the system
 */
public class CateringItem {

    //This class will hold the information for Item and Price

    //Member Variables
    private double priceOfItem;
    private String itemName;
    private String itemCode;
    private String itemType;
    private int startingQuantity;
    private int itemBought;


    //Constructor

    public CateringItem() {

    }

    public CateringItem (String itemType, String itemCode, String itemName,
                         double priceOfItem) {
        this.itemType = itemType;
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.priceOfItem = priceOfItem;
        startingQuantity = 25;
    }

    public int stockOfItem() {
        if (startingQuantity == 0) {
            return Integer.parseInt("SOLD OUT");
        } else {
            startingQuantity -= itemBought;
        } return startingQuantity;
    }

    //Getter
    public double getPriceOfItem() {
        return priceOfItem;
    }

    public String getNameOfItem() {
        return itemName;
    }

    public String getItemCode() {
        return itemCode;
    }

    public int getStartingQuantity() {
        return startingQuantity;
    }
}
