package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.Scanner;
import com.techelevator.VendingMachine;

public class Menu extends VendingMachine {
<<<<<<< HEAD
	
	

	public Menu(int productAmount, double balance) {
		super(productAmount, balance);
		
=======

	public Menu(int productAmount, int balance) {
		super(productAmount, balance);
		// TODO Auto-generated constructor stub
>>>>>>> 35bbb40107e4c21360c0a025843f4a48e86bac01
	}

	public void printBanner() {
	System.out.println("***************");
	System.out.println("VENDO-MATIC 800");
	System.out.println("***************");
	System.out.println();

	}

	@SuppressWarnings("resource")
	public void selectionMaker() throws FileNotFoundException {
		System.out.print("Please make a selection >>> ");
		System.out.println("(1) Display Vending Machine Items > ");
		System.out.println("(2) Purchase > ");
		System.out.println("(3) Exit > ");
		
		Scanner userInput = new Scanner(System.in);
		if (userInput.equals("1")) printStock();
		if (userInput.equals("2")) purchaseMenu();
		if (userInput.equals("3")) System.exit(1);
		if (userInput.equals("4")) generateSalesReport();

	}

	@SuppressWarnings("resource")
	public void printStock() throws FileNotFoundException { // display each item with # remaining
		File stock = new File("vendingmachine.csv");
		Scanner fileScanner = new Scanner(stock);
		while (fileScanner.hasNextLine()) {
			String line = fileScanner.nextLine();
			System.out.println(line + "..fill this!!!.." + " remaining"); // add the number of available items for each product
		}
	}

	@SuppressWarnings("resource")
	public void purchaseMenu() throws FileNotFoundException {
		System.out.println("(1) Feed Money > ");
		System.out.println("(2) Select Product > ");
		System.out.println("(3) Finish Transaction > ");
		System.out.println("Current Money Provided: $" + getBalance());
		
		Scanner userInput = new Scanner(System.in);
		if (userInput.equals("1")) feedMoney(balance);// add feed money functionality
		if (userInput.equals("2")) printStock(); // add purchase functionality 
		if (userInput.equals("3")) dispenseChange(balance); selectionMaker(); // close out
		
	}
	
	@SuppressWarnings("resource")
	public void addMoney() throws FileNotFoundException {
		
		
		Scanner userInput = new Scanner(System.in);
		if (userInput.equals("1")); // add feed money functionality
		if (userInput.equals("2")) printStock(); // add purchase functionality 
		if (userInput.equals("3")); // close out
		
	}
	
	
	public void generateSalesReport() throws FileNotFoundException {
		Date currentDate = new Date(0);
		String dateString = currentDate.toString();
		File salesReport = new File(dateString);
		PrintWriter printWriter = new PrintWriter(salesReport);
		// add log data
	}
	
	
	
	
	
	
	
	

	
}
