package com.techelevator.view;

import com.techelevator.items.CateringItem;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private List<CartItem> itemsCollection;

    //Constructor
    public ShoppingCart() {
        itemsCollection = new ArrayList<>(); //creating an empty list
    }

    public double addItem(CateringItem item, int quantity) {
        CartItem cartItem = new CartItem(item, quantity);
        itemsCollection.add(cartItem);
        return cartItem.getSubtotal();
    }

    public double getGrandTotal() {
        double total = 0;
        for (CartItem item : itemsCollection) {
            total += item.getSubtotal();
        }
        return total;
    }

    public List<CartItem> getItems() {
        return itemsCollection;
    }

    //For the LogWriter
    public String recordAddedMoney(String productCode, int quantity) {
        CateringItem cateringItem = new CateringItem();
        List<CartItem> listLog = itemsCollection;
        String productName = "";
        for (CartItem item : listLog) {
            if (productCode.equalsIgnoreCase(cateringItem.getItemCode())) {
                productName = cateringItem.getNameOfItem();
            }
        }
        return quantity + " " + productName + " " + productCode;
    }

    public double recordedBalanceDifference(String productCode, int quantity) {
        CateringItem cateringItem = new CateringItem();
        List<CartItem> listLog = itemsCollection;
        double productSum = 0;
        for (CartItem item : listLog) {
            if (productCode.equalsIgnoreCase(cateringItem.getItemCode())) {
                productSum = cateringItem.getPriceOfItem() * quantity;
            }
        }
        return productSum;
    }
}


