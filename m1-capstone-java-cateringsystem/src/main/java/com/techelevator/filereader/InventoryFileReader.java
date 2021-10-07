package com.techelevator.filereader;

import com.techelevator.items.CateringItem;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
    This class should contain any and all details of access to the inventory file
 */
public class InventoryFileReader {

    //This class will read the csv file

    private String inventoryFileName;

    //We want to add a max value (25) of each item
    private static final int STARTING_INVENTORY = 25;

    //Constructor
    public InventoryFileReader(String inventoryFileName) throws FileNotFoundException {
        this.inventoryFileName = inventoryFileName;
        //Passing the csv file and assigning it into variable "fileName"
        //Then passing "fileName" as a new file called "file"
        String fileName = "catersystem.csv";
        File file = new File(fileName);
        //Create an array of items from the file
        List<CateringItem> itemList = new ArrayList<CateringItem>();

        try (Scanner fileScanner = new Scanner(file)) {
            while (fileScanner.hasNextLine()) {
                //We are splitting the items in the file by the pike-delimiter
                String[] itemDetails = fileScanner.nextLine().split("\\|");
                //We are creating a new item to add to array
                CateringItem items = new CateringItem(itemDetails[0], itemDetails[1], itemDetails [2],
                        Double.parseDouble(itemDetails[3]));
                //We are adding the items into our array
                itemList.add(items);
            }
        }


    }
}
//To have a max inventory of 25, create a static class for the inventory
//To say SOLD OUT we need to do System.out.println("SOLD OUT")