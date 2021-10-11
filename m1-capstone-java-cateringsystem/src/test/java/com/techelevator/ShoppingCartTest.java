package com.techelevator;

import com.techelevator.items.CateringItem;
import com.techelevator.view.CartItem;
import com.techelevator.view.ShoppingCart;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartTest extends TestCase {

    private ShoppingCart shoppingCart;
    private List<CartItem> shoppingList;


    @Before
    public void setUp() throws Exception {
        shoppingCart = new ShoppingCart();
        shoppingList = new ArrayList<>();
        // add items to the list
        shoppingList.add(new CartItem(
                new CateringItem("A", "A1", "Aa", 1.50),
                10
        ));
        shoppingList.add(new CartItem(
                new CateringItem("B", "B1", "Bb", 0.75),
                15
        ));
        shoppingList.add(new CartItem(
                new CateringItem("D", "D1", "Dd", 2.25),
                5
        ));

        shoppingList.add(new CartItem(
                new CateringItem("E", "E1", "Ee", 2.25),
                5

        ));
    }


    @Test
    public void testAddItem() {
        double subtotal;
        // add an item from the shoppingList
        // check if the returned subtotal matches the expected result
        for (CartItem item : shoppingList) {
            subtotal = shoppingCart.addItem(item.getItem(), item.getItemQuantity());
            assertEquals(item.getSubtotal(), subtotal);
        }
    }
    @Test
    public void testGetGrandTotal() {
        double total = 0;
        for (CartItem item : shoppingList) {
            total += shoppingCart.addItem(item.getItem(), item.getItemQuantity());
        }

        assertEquals(total, shoppingCart.getGrandTotal());
    }

    @Test
    public void testGetItems() {
        for (CartItem item : shoppingList) {
            shoppingCart.addItem(item.getItem(), item.getItemQuantity());
        }

        List<CartItem> result = shoppingCart.getItems();
        // test if the returned list has the same size as the expected
        assertEquals(shoppingList.size(), result.size());

        for (int i = 0; i < result.size(); i++) {
            assertSame(shoppingList.get(i).getItem(), result.get(i).getItem());
            assertEquals(shoppingList.get(i).getItemQuantity(), result.get(i).getItemQuantity());

        }
    }

    @After
    public void tearDown() throws Exception {
    }

}