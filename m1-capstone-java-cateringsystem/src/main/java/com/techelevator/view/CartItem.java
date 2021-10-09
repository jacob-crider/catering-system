package com.techelevator.view;

import com.techelevator.items.CateringItem;

public class CartItem {
    private CateringItem item;
    private int qty;
    private double subtotal;

    public CartItem(CateringItem item, int qty) {
        this.item = item;
        this.qty = qty;
        this.subtotal = item.getPriceOfItem() * qty;
    }

    public CateringItem getItem() {
        return item;
    }

    public int getQty() {
        return qty;
    }

    public double getSubtotal() {
        return subtotal;
    }
}