package com.techelevator;

import com.techelevator.items.CateringItem;
import com.techelevator.view.MoneyHandler;

import java.util.List;
import java.util.Map;


/*
    This class should encapsulate all the functionality of the Catering system, meaning it should
    contain all the "work"
 */
public class CateringSystem {

    //Member Variables
    private MoneyHandler moneyHandler = new MoneyHandler();
    private CateringItem cateringItem = new CateringItem();


    private int currentStock;

    private Map<String, CateringItem> inventoryMap;



    public Map<String, CateringItem> getInventoryMap() {
        return inventoryMap;
    }

    public void setInventoryMap(Map<String, CateringItem> inventoryMap) {
        this.inventoryMap = inventoryMap;
    }


}
