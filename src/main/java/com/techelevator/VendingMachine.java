package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class VendingMachine {

	
	protected BigDecimal balance;
	List<Inventory> vendingItems;
	
	public VendingMachine(List<Inventory> items, double balance) {
		this.vendingItems = items;
		this.balance = new BigDecimal(balance);
	}

	public void printStock() {
		for(Inventory item: this.vendingItems) {
			System.out.println(item);
		}
	}
	
	@SuppressWarnings("static-access")
	public BigDecimal dispenseChange(BigDecimal change) throws IOException {
		int quarters = 0;
		int dimes = 0;
		int nickels = 0;
		
		while(change.compareTo(new BigDecimal(Double.toString(0.25))) >= 0) {
			quarters++;
			change = change.subtract(new BigDecimal(Double.toString(0.25)));
		}
		while(change.compareTo(new BigDecimal(Double.toString(0.10))) >= 0) {
			dimes++;
			change = change.subtract(new BigDecimal(Double.toString(0.10)));
		}
		while(change.compareTo(new BigDecimal(Double.toString(0.05))) >= 0) {
			nickels++;
			change = change.subtract(new BigDecimal(Double.toString(0.05)));
		}
		
		System.out.println("Your change is " + quarters + " quarters, " + dimes + " dimes, and " + nickels + " nickels \n");
		
		String timeStamp = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss aa").format(Calendar.getInstance().getTime());
		File myFile = new File("Log.txt");
		
       try(PrintWriter myPrintWriter = new PrintWriter(new FileWriter(myFile, true))) {
    	myPrintWriter.println(timeStamp + " GIVE CHANGE: $" + balance + " " + balance.subtract(balance));   
       }
	
       balance = balance.subtract(balance);
       
		return balance;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public Inventory getItem(String slotLocation) {
		for (Inventory item : this.vendingItems) {
			if (item.getSlotLocation().equals(slotLocation)) {
				return item;
			}
		}
		return null;
	}
}
