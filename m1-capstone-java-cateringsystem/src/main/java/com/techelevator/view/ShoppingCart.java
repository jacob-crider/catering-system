package com.techelevator.view;

import com.techelevator.items.CateringItem;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private List<CartItem> items;

    public ShoppingCart() {
        items = new ArrayList<>();
    }

    public double addItem(CateringItem item, int quantity) {
        CartItem cartItem = new CartItem(item, quantity);
        items.add(cartItem);
        return cartItem.getSubtotal();
    }

    public double getGrandTotal() {
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
