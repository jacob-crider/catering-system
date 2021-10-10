package com.techelevator;

import com.techelevator.items.CateringItem;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CateringItemTest {

    private final int STARTING_QUANTITY = 25;
    private CateringItem cateringItem;

    @Before
    public void setup() {
        cateringItem = new CateringItem(STARTING_QUANTITY);
    }

    @Test
    public void item_is_out_of_stock() {
        boolean result = cateringItem.isOutOfStock();
        Assert.assertTrue(result);
    }

    @Test
    public void buying_all_product_changes_quantity_to_zero() {
        int amountToPurchase = 25;
        cateringItem.boughtProduct(amountToPurchase);

        int expectedNewQuantity = STARTING_QUANTITY - amountToPurchase;
        int actualNewQuantity = 0;

        Assert.assertEquals(expectedNewQuantity, actualNewQuantity);
    }

    @Test
    public void buying_product_changes_quantity() {
        int amountToPurchase = 10;
        cateringItem.boughtProduct(amountToPurchase);

        int expectedNewQuantity = STARTING_QUANTITY - amountToPurchase;
        int actualNewQuantity = 15;

        Assert.assertEquals(expectedNewQuantity, actualNewQuantity);
    }
}
