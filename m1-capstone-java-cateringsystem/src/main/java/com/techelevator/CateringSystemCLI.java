package com.techelevator;

import com.techelevator.filereader.InventoryFileReader;
import com.techelevator.items.CateringItem;
import com.techelevator.view.CartItem;
import com.techelevator.view.Menu;
import com.techelevator.view.MoneyHandler;
import com.techelevator.view.ShoppingCart;

import java.util.Map;

/*
 * This class should control the workflow of the application, but not do any other work
 * 
 * The menu class should communicate with the user, but do no other work
 * 
 * This class should control the logical workflow of the application, but it should do no other
 * work.  It should communicate with the user (System.in and System.out) using the Menu class and ask
 * the CateringSystem class to do any work and pass the results between those 2 classes.
 */
public class CateringSystemCLI {

	/*
	 * The menu class is instantiated in the main() method at the bottom of this file.
	 * It is the only class instantiated in the starter code.
	 * You will need to instantiate all other classes using the new keyword before you can use them.
	 *
	 * Remember every class and data structure is a data types and can be passed as arguments to methods or constructors.
	 */
	private Menu menu;
	private CateringSystem cateringSystem = new CateringSystem();
	private InventoryFileReader fileReader = new InventoryFileReader(); // instantiated fileReader
	private CateringItem cateringItem = new CateringItem();
	private MoneyHandler moneyHandler = new MoneyHandler();
	private ShoppingCart cart = new ShoppingCart();


	public CateringSystemCLI(Menu menu) {
		this.menu = menu;
	}

	/*
	 * Your application starts here
	 */
	public void run() {

		menu.showWelcomeMessage();


		while (true) {
			/*
			Display the Starting Menu and get the users choice.
			Remember all uses of System.out and System.in should be in the menu
			
			IF the User Choice is Display Vending Machine Items, 
				THEN display vending machine items
			ELSE IF the User's Choice is Purchase,
				THEN go to the purchase menu
			*/

			// fileReader.itemsInInventory is calling our method which contains the Map of key/values pairs we created
			cateringSystem.setInventoryMap(fileReader.itemsInInventory());

			String userChoice = menu.mainMenu();
//			String userChoiceTwo = menu.addUserMoney();

			if(userChoice.equals("1")){
				menu.printCateringItems(cateringSystem.getInventoryMap());
			}
			else if(userChoice.equals("2")) {
				orderingMenu();
			}
			else if (userChoice.equals("3")) {
				//Quit
				break;
			}
		}
	}

	// pass moneyHandler in menu.orderMenu() on 80
	public void orderingMenu() {
		while (true) {
			String userChoiceTwo = menu.orderMenu(moneyHandler.getBalance());
			if (userChoiceTwo.equals("1")) {
				int amt = menu.addUserMoney();
				moneyHandler.addMoney(amt);
			}
			else if (userChoiceTwo.equals("2")) {
				// SELECT PRODUCT
				String code = menu.getProduct();
				int qty = menu.getQuantity();

				CateringItem prod = get_product(code, cateringSystem.getInventoryMap());
				System.out.println("Begin: " + prod.getQuantity());
				if (prod == null) {
					menu.printMessage("The product code doesn't exist.");
				}
				else if (prod.is_out_of_stock()) {
					menu.printMessage("Sorry, the product is out of stock.");
				}
				else if (qty > prod.getQuantity()) {
					menu.printMessage("Insufficient stock");
				}
				else {
					double subtotal = cart.addItem(prod, qty);
					moneyHandler.deductMoney(subtotal);
					prod.bought(qty);
					System.out.println("End: " + prod.getQuantity());
				}
			}
			else if (userChoiceTwo.equals("3")) {
				// COMPLETE TRANSACTION
				menu.printReport(cart);
//				updateStocks();
				moneyHandler.getChange();
				menu.printChange(moneyHandler);
				moneyHandler.reset_balance();

				break;
			}
		}
	}

	private void updateStocks() {
		for (CartItem item : cart.getItems()) {
			CateringItem prod = get_product(item.getItem().getItemCode(), cateringSystem.getInventoryMap());
			prod.bought(item.getItem().getQuantity());
		}
	}

	private CateringItem get_product(String code, Map<String, CateringItem> inventoryItems) {
		for (Map.Entry<String, CateringItem> items : inventoryItems.entrySet()) {
			if (code.equalsIgnoreCase(items.getKey()))
				return items.getValue();
		}
		return null;
	}


	/*
	 * This starts the application, but you shouldn't need to change it.
	 */
	public static void main(String[] args) {
		Menu menu = new Menu();
		CateringSystemCLI cli = new CateringSystemCLI(menu);
		cli.run();
	}
}
