package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Scanner;

public class VendingMachine {

	
	protected BigDecimal balance;
	List<Inventory> vendingItems;
	
	public VendingMachine(List<Inventory> items, double balance) {
		this.vendingItems = items;
		this.balance = new BigDecimal(balance);
	}
		
	public BigDecimal feedMoney() {
		System.out.println("How much would you like to add?");
		System.out.println("Eligible increments are $1.00, $2.00, $5.00, and $10.00");
		
		Scanner scanner = new Scanner(System.in);
		String userInput = scanner.nextLine();
		if(userInput.equals("1.00") || userInput.equals("1")) {
			balance = balance.add(new BigDecimal(1.00));
		}
		if(userInput.equals("2.00") || userInput.equals("2")) {
			balance = balance.add(new BigDecimal(2.00));
		}
		if(userInput.equals("5.00") || userInput.equals("5")) {
			balance = balance.add(new BigDecimal(5.00));
		}
		if(userInput.equals("10.00") || userInput.equals("10")) {
			balance = balance.add(new BigDecimal(10.00));
		}
        
      //  logData();
        
        System.out.println("Your balance is $" + balance);
        
        return balance;
      
    }
	
	public void printStock() {
		for(Inventory item: this.vendingItems) {
			System.out.println(item);
		}
	}
	
	public BigDecimal dispenseChange(BigDecimal change) {
		int quarters = 0;
		int dimes = 0;
		int nickels = 0;
		int pennies = 0;
		
		balance = balance.subtract(change);
		
		while(change.compareTo(new BigDecimal(0.25)) >= 0.25) {
			quarters++;
			change = change.subtract(new BigDecimal(0.25));
		}
		while(change.compareTo(new BigDecimal(0.10)) >= 0.10) {
			dimes++;
			change = change.subtract(new BigDecimal(0.10));
		}
		while(change.compareTo(new BigDecimal(0.05)) >= 0.05) {
			nickels++;
			change = change.subtract(new BigDecimal(0.05));
		}
		while(change.compareTo(new BigDecimal(0.01)) >= 0.01) {
			pennies++;
			change = change.subtract(new BigDecimal(0.01));
		}
		
		System.out.println("Your change is " + quarters + " quarters, " + dimes + " dimes, " + nickels + " nickels, and " + pennies + " pennies");
		
		return balance;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	
	public void logData() throws IOException {
		Date currentDate = new Date(0);
		String dateString = currentDate.toString();
		File myFile = new File("Log.txt");
		
		try (FileWriter myFileWriter = new FileWriter(myFile.getAbsolutePath(), false)) {
			PrintWriter myPrintWriter = new PrintWriter(myFileWriter);
			myPrintWriter.println(dateString + "...action..." + "...amount..." + getBalance());
		}
		
	}

	public Inventory getItem(String slotLocation)
	{
		for (Inventory item : this.vendingItems)
		{
			//System.out.println("Comparing " + slotLocation + " to " + item.getSlotLocation());
			if (item.getSlotLocation().equals(slotLocation))
			{
				return item;
			}
		}
		return null;
	}
}
