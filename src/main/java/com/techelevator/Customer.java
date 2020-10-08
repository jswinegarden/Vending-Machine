package com.techelevator;

public class Customer extends Transactions implements Accountable {

	public Customer(int balance) {
		super(balance);
	}

	@Override
	public int getBalance() {
		return 0;
	}

	@Override
    public int transferTo(Transactions destination, int transferAmount) {
    	destination.feedMoney(transferAmount);
    	this.withdrawChange(transferAmount);
    	return getBalance();
    }
}
