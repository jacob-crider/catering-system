package com.techelevator.view;
import com.techelevator.items.CateringItem;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private List<CartItem> items;

    public ShoppingCart() {
        items = new ArrayList<>();
    }

    public double addItem(CateringItem item, int qty) {
        CartItem c_item = new CartItem(item, qty);
        items.add(c_item);
        return c_item.getSubtotal();
    }

    public double get_grant_total() {
        double total = 0;
        for (CartItem item : items) {
            total += item.getSubtotal();
        }
        return total;
    }

    public List<CartItem> getItems() {
        return items;
    }
}
