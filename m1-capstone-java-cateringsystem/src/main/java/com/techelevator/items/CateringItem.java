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

    //had to create this for unit testing
    public CateringItem(int starting_quantity) {
    }

    //Switch statement for cleaner code
  public String getItemType() {

      if (itemType == "A") {
          return "Appetizer";
      } else if (itemType == "B") {
          return "Beverage";
      } else if (itemType == "D") {
          return "Dessert";
      } else if (itemType == "E") {
          return "Entree";
      } return itemType;
  }
    public void boughtProduct(int quantityPurchased) {
        this.quantity -= quantityPurchased;
    }

    public boolean isOutOfStock() {
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
}
