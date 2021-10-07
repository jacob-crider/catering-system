package com.techelevator.view;

import java.io.File;
import java.io.FileWriter;
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
        System.out.println("Please select one of the options:");
		String userChoice = in.nextLine();
		return userChoice;

		//Instantiate the options and assign into a variable
	}

	//Need user input to choose from main menu (this class has main method to execute)
	//Need user input to choose 1-3
//	String userInput = in.nextLine();


}
