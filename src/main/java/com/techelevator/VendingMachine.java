package com.techelevator;

import java.util.Scanner;

public class VendingMachine {

	private int productAmount;
	protected double balance;
	
	public VendingMachine(int productAmount, double balance) {
		this.productAmount = productAmount;
		this.balance = balance;
	}
	
	public int stockInventory(int productToStock) {
		productAmount += productToStock;
		return productAmount;
	}
	
	public int dispenseProduct(int productsToDispense) {
		productAmount -= productsToDispense;
		return productAmount;
	}
	
	public double feedMoney(double amountToDeposit) {
		System.out.println("How much would you like to add?");
		System.out.println("Eligible increments are $1.00, $2.00, $5.00, and $10.00");
		Scanner userInput = new Scanner(System.in);
		if(userInput.equals("1.00")) {
			amountToDeposit += 1.00;
		}
		if(userInput.equals("2.00")) {
			amountToDeposit += 2.00;
		}
		if(userInput.equals("5.00")) {
			amountToDeposit += 5.00;
		}
		if(userInput.equals("10.00")) {
			amountToDeposit += 10.00;
		}
        balance += amountToDeposit;
        
        System.out.println("Your balance is $" + balance);
        
        return balance;
    }
	
	public double updateVMBalance(double price) {
		balance -= price;
		return balance;
	}
	
	public double dispenseChange(double change) {
		int quarters = 0;
		int dimes = 0;
		int nickels = 0;
		int pennies = 0;
		
		balance -= change;
		
		while(change >= 0.25) {
			quarters++;
			change -= 0.25;
		}
		while(change >= 0.10) {
			dimes++;
			change -= 0.10;
		}
		while(change >= 0.05) {
			nickels++;
			change -= 0.05;
		}
		while(change >= 0.01) {
			pennies++;
			change -= 0.01;
		}
		return balance;
	}

	public int getProductAmount() {
		return productAmount;
	}

	public void setProductAmount(int productAmount) {
		this.productAmount = 5;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
}
