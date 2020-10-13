package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import com.techelevator.VendingMachine;

public class Menu extends VendingMachine {	
	

	public Menu(List<Inventory> items) {
		super(items, 0);
	}

	public void printBanner() {
	System.out.println("***************");
	System.out.println("VENDO-MATIC 800");
	System.out.println("***************");
	System.out.println();
	}

	@SuppressWarnings("resource")
	public void selectionMaker() throws IOException {
		System.out.println("Please make a selection >>> ");
		System.out.println("(1) Display Vending Machine Items > ");
		System.out.println("(2) Purchase > ");
		System.out.println("(3) Exit > ");
		
		Scanner scanner = new Scanner(System.in);
		String userInput = scanner.nextLine();
		if (userInput.equals("1")) {
			printStock();
		} else if (userInput.equals("2")) {
			purchaseMenu();
		} else if (userInput.equals("3")) {
			System.exit(1);
		} else {
			System.out.println("Please try again with a valid entry. \n");
		}

	}

	@SuppressWarnings("resource")
	public void purchaseMenu() throws IOException {
		System.out.println("(1) Feed Money > ");
		System.out.println("(2) Select Product > ");
		System.out.println("(3) Finish Transaction > ");
		System.out.println("Current Money Provided: $" + getBalance() + "\n");
		
	
		Scanner scanner = new Scanner(System.in);
		String userInput = scanner.nextLine();
		if (userInput.equals("1")) {
			feedMoney();
		} else if (userInput.equals("2")) { selectProduct(); 
		try {
			purchaseMenu();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			}
		} else if (userInput.equals("3")) {
			dispenseChange(balance); selectionMaker();
		} else {
			System.out.println("Please try again with a valid entry. \n");
			try {
				purchaseMenu();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				}
		}
		
	}
	
	public void selectProduct() throws IOException {
		printStock();
		System.out.println("Enter Slot Number > ");
		Scanner scanner = new Scanner(System.in);
		String userInput = (scanner.nextLine()).toUpperCase();
		Inventory item = getItem(userInput);
		if (item == null) {
			System.out.println("The slot number: " + userInput + " is not valid. \n");
			try {
				selectProduct();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				}
			return;
		}
		BigDecimal itemCost = item.getPrice();
		if (itemCost.compareTo(balance) > 0){
			System.out.println("You need $" + (balance.subtract(itemCost).abs()) + " more! \n");
			return;
		}
		
		if (item.getProductAmount() <= 0) {
			System.out.println("There are no more " + item.getProductName() + "! \n");
			return;
		}
		
		item.dispense(1);
		balance = balance.subtract(itemCost);
		
		System.out.println("Enjoy your " + item.getProductName() + "! It cost $" + item.getPrice());
		if (item.getProductType().equals("Chip")) System.out.println("Crunch Crunch, Yum! \n");
		if (item.getProductType().equals("Candy")) System.out.println("Munch Munch, Yum! \n");
		if (item.getProductType().equals("Drink")) System.out.println("Glug Glug, Yum! \n");
		if (item.getProductType().equals("Gum")) System.out.println("Chew Chew, Yum! \n");
		System.out.println("Your remaining balance is " + balance + "");
		
		String timeStamp = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss aa").format(Calendar.getInstance().getTime());
		File myFile = new File("Log.txt");
		
       try(PrintWriter myPrintWriter = new PrintWriter(new FileWriter(myFile, true))) {
    	myPrintWriter.println(timeStamp + " " + item.getProductName() + " " + item.getSlotLocation() + " " + balance.add(item.getPrice()) + " " + balance);   
       }
		
	}
	
	public BigDecimal feedMoney() throws IOException {
		System.out.println("How much would you like to add?");
		System.out.println("Eligible increments are $1.00, $2.00, $5.00, and $10.00");
		System.out.println("Type in \"Return\" to return to the purchase menu. \n");
		
		Scanner scanner = new Scanner(System.in);
		String userInput = scanner.nextLine();
		if(userInput.equals("1.00") || userInput.equals("1")) {
			balance = balance.add(new BigDecimal(1.00));
		} else if(userInput.equals("2.00") || userInput.equals("2")) {
			balance = balance.add(new BigDecimal(2.00));
		} else if(userInput.equals("5.00") || userInput.equals("5")) {
			balance = balance.add(new BigDecimal(5.00));
		} else if(userInput.equals("10.00") || userInput.equals("10")) {
			balance = balance.add(new BigDecimal(10.00));
		} else {
			System.out.println("Please try again with a valid entry. \n");
		}    		
		
		String timeStamp = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss aa").format(Calendar.getInstance().getTime());
		File myFile = new File("Log.txt");
		
       try(PrintWriter myPrintWriter = new PrintWriter(new FileWriter(myFile, true))) {
    	myPrintWriter.println(timeStamp + " FEED MONEY: $" + userInput + " $" + balance);   
       }
       
       try {
			purchaseMenu();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}    
        
        System.out.println("Your balance is $" + balance + "\n");
        
        return balance;
    }

	public static void main(String[] args) throws IOException {	
		System.out.println("Begin Main");
		
		File dataFile = new File("vendingmachine.csv");
		try(Scanner dataInput = new Scanner(dataFile)) {
			List<Inventory> items = new ArrayList<Inventory>();
			while(dataInput.hasNextLine()) {
				String line = dataInput.nextLine();
				String[] separateLine = line.split("\\|");
				String slotLocation = separateLine[0]; 
				String productName = separateLine[1];
				String productType = separateLine[3];
				BigDecimal price = new BigDecimal(separateLine[2]); 
				Inventory item = new Inventory(slotLocation, productName, productType, price);
				items.add(item);
				
			}
			Menu menu = new Menu(items);
			while(true) {
				menu.printBanner();
				menu.selectionMaker();
			}
	} catch(FileNotFoundException e) {
			e.printStackTrace();
		}	
		System.out.println("End Main");
	}
}
