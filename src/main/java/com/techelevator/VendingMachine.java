package com.techelevator;

public class VendingMachine extends Transactions implements Accountable {

	private int productAmount;
	
	public VendingMachine(int productAmount, int balance) {
		super(balance);
		this.productAmount = productAmount;
	}
	
	@Override
    public int transferTo(Transactions destination, int transferAmount) {
    	destination.feedMoney(transferAmount);
    	this.withdrawChange(transferAmount);
    	return getBalance();
    }
	
	public int stockInventory(int productToStock) {
		productAmount += productToStock;
		return productAmount;
	}
	
	public int dispense(int productsToDispense) {
		productAmount -= productsToDispense;
		return productAmount;
	}

	public int getProductAmount() {
		return productAmount;
	}

	public void setProductAmount(int productAmount) {
		this.productAmount = 5;
	}

	@Override
	public int getBalance() {
		return 0;
	}
	
}
