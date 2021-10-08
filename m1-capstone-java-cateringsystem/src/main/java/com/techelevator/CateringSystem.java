package com.techelevator;

import com.techelevator.items.CateringItem;
import java.util.Map;


/*
    This class should encapsulate all the functionality of the Catering system, meaning it should
    contain all the "work"
 */
public class CateringSystem {

    //Member Variables

    private int currentStock;
    private static final int STARTING_INVENTORY = 25;
    private Map<String, CateringItem> inventoryMap;

    // Methods
    // 5)


    //This class will handle the money and change



    public Map<String, CateringItem> getInventoryMap() {
        return inventoryMap;
    }

    public void setInventoryMap(Map<String, CateringItem> inventoryMap) {
        this.inventoryMap = inventoryMap;
    }
}
