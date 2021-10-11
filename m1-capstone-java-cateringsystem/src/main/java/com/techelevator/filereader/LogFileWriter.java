package com.techelevator.filereader;

import com.techelevator.items.CateringItem;
import com.techelevator.view.CartItem;
import com.techelevator.view.MoneyHandler;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.io.FileWriter;

/*
    This class should contain any and all details of access to the log file
 */
public class LogFileWriter {

   public LogFileWriter() {
   }

   public void logAction(String action, double logCalculation, double balance){ //Pass through the class CartItem

      File newFile = new File("log.txt");

      try (FileWriter log = new FileWriter(newFile, true)) {
         log.write(this.getDateTime()); //this will write out the current date and time AM/PM
         log.write( action + " $" + logCalculation + " $" + balance + "\n");
      } catch (NullPointerException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   public String getDateTime() {
      Date date = new Date();
      SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a ");
      return dateFormat.format(date);
   }

}

