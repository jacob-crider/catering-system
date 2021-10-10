package com.techelevator.view;

import com.techelevator.items.CateringItem;

import java.util.Map;
import java.util.Scanner;

/*
 * This is the only class that should have any usage of System.out or System.in
 *
 * Usage of System.in or System.out should not appear ANYWHERE else in your code outside of this class.
 *
 * Work to get input from the user or display output to the user should be done in this class, however, it
 * should include no "work" that is the job of the catering system.
 */
public class Menu {

	private static final Scanner in = new Scanner(System.in);

	public void showWelcomeMessage() {
		System.out.println("*************************");
		System.out.println("**     Weyland Corp.   **");
		System.out.println("**      Catering       **");
		System.out.println("*************************");
		System.out.println();
	}

	//Should display main menu as System.out.println()
	//(1) Display Catering Items
	//(2) Order
    //(3) Quit

	public String mainMenu() {
		System.out.println();
		System.out.println("(1) Display Catering Item");
		System.out.println("(2) Order");
		System.out.println("(3) Quit");
		System.out.println();
        System.out.println("Please select one of these options: ");
		String userChoice = in.nextLine();
		return userChoice;

		//Instantiate the options and assign into a variable
	}

	public void printCateringItems(Map<String, CateringItem> inventoryItems) {
		for (Map.Entry<String, CateringItem> items : inventoryItems.entrySet()) {
			System.out.println(items.getKey() + " " + items.getValue().getPriceOfItem());
		}
	}

	public String orderMenu(double bal) {
		System.out.println();
		System.out.println("(1) Add Money");
		System.out.println("(2) Select Product");
		System.out.println("(3) Complete Transaction");
		System.out.println("Current Amount Balance: $" + bal);
		System.out.println();
		System.out.println("Please select one of these options: ");
		String userChoiceTwo = in.nextLine();
		return userChoiceTwo;
	}

	public int addUserMoney() {
		System.out.println("Please enter money to be added in whole dollar amounts: $");
		int userChoiceTwo = in.nextInt();
		in.nextLine();
		return userChoiceTwo;
	}

	public int getQuantity() {
		System.out.print("Enter quantity: ");
		int quantity = in.nextInt();
		in.nextLine();
		return quantity;
	}

	public String getProduct() {
		System.out.print("Product code: ");
		String productCode = in.nextLine();
		return productCode;
	}

	public void printReport(ShoppingCart cart) {
		for (CartItem item : cart.getItems()) {
			System.out.printf("%3d %-10s %-10s $%5.2f $%5.2f\n",
					item.getItemQuantity(),
					item.getItem().getItemType(),
					item.getItem().getNameOfItem(),
					item.getItem().getPriceOfItem(),
					item.getSubtotal());
		}
		System.out.println("\nTotal: $" + cart.getGrandTotal());
	}

	public void printChange(MoneyHandler moneyHandler) {
		System.out.println("Change: $" + moneyHandler.getBalance());
		System.out.println("\n\t" + moneyHandler.getTwenties() + " twenties");
		System.out.println("\t" + moneyHandler.getTens() + " tens");
		System.out.println("\t" + moneyHandler.getFives() + " fives");
		System.out.println("\t" + moneyHandler.getOnes() + " ones");
		System.out.println("\t" + moneyHandler.getQuarters() + " quarters");
		System.out.println("\t" + moneyHandler.getDimes() + " dimes");
		System.out.println("\t" + moneyHandler.getNickels() + " nickels");
	}

	public void printMessage(String message) {
		System.out.println(message);
	}
}
