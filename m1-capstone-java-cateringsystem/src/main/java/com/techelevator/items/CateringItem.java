package com.techelevator.items;

/*
    This represents a single catering item in the system
 */
public class CateringItem {

    //This class will hold the information for Item and Price
    private final int STARTING_QUANTITY = 25;
    //Member Variables
    private double priceOfItem;
    private String itemName;
    private String itemCode;
    private String itemType;
    private int quantity;


    //Constructor

    public CateringItem() {

    }

    public CateringItem (String itemType, String itemCode, String itemName,
                         double priceOfItem) {
        this.itemType = itemType;
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.priceOfItem = priceOfItem;
        quantity = STARTING_QUANTITY;
    }

    public String getItemType() {
        switch (itemType) {
            case "A":
                return "Appetizer";
            case "B":
                return "Beverage";
            case "D":
                return  "Dessert";
            case "E":
                return "Entree";
            default:
                return "";
        }
    }

    public boolean is_out_of_stock() {
        return (quantity == 0);
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

    public int getQuantity() {
        return quantity;
    }

    public void bought(int qty) {
        quantity -= qty;
    }
}
