package com.techelevator;

public class VendingMachine {

	
	private int productAmount;
	
	
	public VendingMachine(int productAmount) {
		this.productAmount = productAmount;
	}
	
	public int stockInventory(int productToStock) {
		productAmount += productToStock;
		return productAmount;
	}

	public int getProductAmount() {
		return productAmount;
	}

	public void setProductAmount(int productAmount) {
		this.productAmount = 5;
	}
	
	
}
