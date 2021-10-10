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

   private CartItem cartLog;
   private MoneyHandler money = new MoneyHandler();

   public LogFileWriter() {
   }

   public void addMoneyLog() throws IOException {

      File newFile = new File("log.txt");

      try (FileWriter log = new FileWriter(newFile)) {
         log.write(this.getDateTime()); //this will write out the current date and time AM/PM
         log.write("" + "ADD MONEY: $" + cartLog.getSubtotal() + " $" + money.getBalance());
      } catch (NullPointerException e) {
         e.printStackTrace();
      }

   }

   public String getDateTime() {
      Date date = new Date();
      SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss a");
      return dateFormat.format(date);
   }

   public CartItem getCartLog() {
      return cartLog;
   }

   public MoneyHandler getMoney() {
      return money;
   }
}

