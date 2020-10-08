package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Menu {

	public void printBanner() {
	System.out.println("***************");
	System.out.println("VENDO-MATIC 800");
	System.out.println("***************");
	System.out.println();

	}

	public void selectionMaker() throws FileNotFoundException {
		System.out.print("Please make a selection >>> ");
		System.out.println("(1) Display Vending Machine Items");
		System.out.println("(2) Purchase");
		System.out.println("(3) Finish Transaction");
		
		Scanner userInput = new Scanner(System.in);
		if (userInput.equals("1")) printStock();
		//if (userInput.equals("2"))
		//if (userInput.equals("3"))

	}

	@SuppressWarnings("resource")
	public void printStock() throws FileNotFoundException { // display each item with # remaining
		File stock = new File("vendingmachine.csv");
		Scanner fileScanner = new Scanner(stock);
		while (fileScanner.hasNextLine()) {
			String line = fileScanner.nextLine();
			System.out.println(line);
		}
	}


	
	

	
	
	
	
	
	
	
	

	
}
