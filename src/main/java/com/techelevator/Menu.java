package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import com.techelevator.VendingMachine;

public class Menu extends VendingMachine {	
	
	//public static void main(String[] args) {

	public Menu(List<Inventory> items) {
		super(items, 0);
	}

	//public Menu(int productAmount, int balance) {
		//super(productAmount, balance);
		// TODO Auto-generated constructor stub
	//}

	public void printBanner() {
	System.out.println("***************");
	System.out.println("VENDO-MATIC 800");
	System.out.println("***************");
	System.out.println();

	}

	@SuppressWarnings("resource")
	public void selectionMaker() throws FileNotFoundException {
		System.out.println("Please make a selection >>> ");
		System.out.println("(1) Display Vending Machine Items > ");
		System.out.println("(2) Purchase > ");
		System.out.println("(3) Exit > ");
		
		Scanner scanner = new Scanner(System.in);
		String userInput = scanner.nextLine();
		if (userInput.equals("1")) printStock();
		if (userInput.equals("2")) purchaseMenu();
		if (userInput.equals("3")) System.exit(1);
		if (userInput.equals("4")) generateSalesReport();

	}
		//@SuppressWarnings("resource")
		//public void printStock() {
			// display each item with # remaining
			
		
	
		// display each item with # remaining
//	@SuppressWarnings("resource")
//	public void printStock() throws FileNotFoundException { // display each item with # remaining
//		File stock = new File("vendingmachine.csv");
//		Scanner fileScanner = new Scanner(stock);
//		while (fileScanner.hasNextLine()) {
//			String line = fileScanner.nextLine();
//			System.out.println(line + getProductAmount() + " remaining"); 
//		}
//	}

	@SuppressWarnings("resource")
	public void purchaseMenu() throws FileNotFoundException {
		System.out.println("(1) Feed Money > ");
		System.out.println("(2) Select Product > ");
		System.out.println("(3) Finish Transaction > ");
		System.out.println("Current Money Provided: $" + getBalance());
		
	
		Scanner scanner = new Scanner(System.in);
		String userInput = scanner.nextLine();
		if (userInput.equals("1")) feedMoney();// add feed money functionality
		if (userInput.equals("2")) selectProduct(); // add purchase functionality 
		if (userInput.equals("3")) dispenseChange(balance); selectionMaker(); // close out
		
	}
	
	public void selectProduct()
	{
		printStock();
		System.out.println("Enter Slot Number > ");
		Scanner scanner = new Scanner(System.in);
		String userInput = scanner.nextLine();
		Inventory item = getItem(userInput);
		if (item == null)
		{
			System.out.println("The slot number: " + userInput + " is not valid.");
			return;
		}
		
		BigDecimal itemCost = item.getPrice();
		if (itemCost.compareTo(balance) > 0)
		{
			System.out.println("You need $" + (balance.subtract(itemCost).abs()) + " more!");
			return;
		}
		
		if (item.getProductAmount() <= 0)
		{
			System.out.println("There are no more " + item.getProductName() + "!");
			return;
		}
		
		item.dispense(1);
		balance.subtract(itemCost);
		
//		System.out.println("Enjoy your " + item.getProductType() + "produt !");
		if (item.getProductType().equals("Chips")) System.out.println("Crunch Crunch, Yum!");
		if (item.getProductType().equals("Candy")) System.out.println("Munch Munch, Yum!");
		if (item.getProductType().equals("Drink")) System.out.println("Glug Glug, Yum!");
		if (item.getProductType().equals("Gum")) System.out.println("Chew Chew, Yum!");
		System.out.println("Your remaining balance is " + balance + "");
	}
	
//	@SuppressWarnings("resource")
//	public void addMoney() throws FileNotFoundException {
//		
//		
//		Scanner userInput = new Scanner(System.in);
//		if (userInput.equals("1")); // add feed money functionality
//		if (userInput.equals("2")) printStock(); // add purchase functionality 
//		if (userInput.equals("3")); // close out
//		
//	}
	
	
	public void generateSalesReport() throws FileNotFoundException {
		Date currentDate = new Date(0);
		String dateString = currentDate.toString();
		File salesReport = new File(dateString);
		PrintWriter printWriter = new PrintWriter(salesReport);
		// add log data
	}
	

	public static void main(String[] args) {	
		System.out.println("Begin Main");
		
	
		
		File dataFile = new File("vendingmachine.csv");
		try(Scanner dataInput = new Scanner(dataFile)) {
			List<Inventory> items = new ArrayList<Inventory>();
			while(dataInput.hasNextLine()) {
				String line = dataInput.nextLine();
				String[] separateLine = line.split("\\|");
				//System.out.println(line);
				String slotLocation = separateLine[0]; 
				String productName = separateLine[1];
				String productType = separateLine[3];
				BigDecimal price = new BigDecimal(separateLine[2]); 
				Inventory item = new Inventory(slotLocation, productName, productType, price);
				items.add(item);
				
			}
			Menu menu = new Menu(items);
			while(true)
			{
				menu.printBanner();
				menu.selectionMaker();
			}
	} catch(FileNotFoundException e) {
			e.printStackTrace();
			
			
		}	
System.out.println("End Main");
}
	
}
