package com.techelevator.view;

import com.techelevator.items.CateringItem;

public class CartItem {

    private CateringItem item;
    private int itemQuantity;
    private double subtotal;


    public CartItem(CateringItem item, int quantity) {
        this.item = item;
        this.itemQuantity = quantity;
        this.subtotal = item.getPriceOfItem() * quantity;
    }

    public CateringItem getItem() {
        return item;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }

    public double getSubtotal() {
        return subtotal;
    }
}