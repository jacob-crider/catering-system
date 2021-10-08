package com.techelevator.filereader;

import com.techelevator.items.CateringItem;
import com.techelevator.view.Menu;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/*
    This class should contain any and all details of access to the inventory file
 */
public class InventoryFileReader {

    //This class will read the csv file

    private String inventoryFileName;

    //We want to add a max value (25) of each item


    //Constructor
//    public InventoryFileReader(String inventoryFileName) throws FileNotFoundException {
//        this.inventoryFileName = inventoryFileName;
    //Passing the csv file and assigning it into variable "fileName"
    //Then passing "fileName" as a new file called "file"
    public Map<String, CateringItem> itemsInInventory() {

        String fileName = "cateringsystem.csv";
        File file = new File(fileName);
        //Create an array of items from the file
        List<CateringItem> itemList = new ArrayList<CateringItem>();
        //Put list of items into a key, value paired Map with itemCode, priceOfItem
        Map<String, CateringItem> inventory = new LinkedHashMap<String, CateringItem>();

        try (Scanner fileScanner = new Scanner(file)) {
            while (fileScanner.hasNextLine()) {
                //We are splitting the items in the file by the pike-delimiter
                String[] itemDetails = fileScanner.nextLine().split("\\|");
                //We are creating a new item to add to array
                CateringItem items = new CateringItem(itemDetails[0], itemDetails[1], itemDetails[2],
                        Double.parseDouble(itemDetails[3]));
                //We are adding the items into our array
                itemList.add(items);
            }

            for (CateringItem items : itemList) {
                inventory.put(items.getItemCode(), items);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return inventory;
    }
}
//To have a max inventory of 25, create a static class for the inventory
//To say SOLD OUT we need to do System.out.println("SOLD OUT")