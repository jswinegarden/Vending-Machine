package com.techelevator;

public class Transactions implements Accountable {

	private int balance;
	
	
    public Transactions(int balance) {
		this.balance = balance;
	}

	public int feedMoney(int amountToDeposit) {
        balance -= amountToDeposit;
        return balance;
    }
   
    public int withdrawChange(int amountToWithdraw) {
        balance += amountToWithdraw;
        return balance;
    }
    
    public int transferTo(Transactions destinationAccount, int transferAmount) {
    	balance -= transferAmount;
    	destinationAccount.balance += transferAmount;
    	return balance;
    }
    
	public void setBalance(int balance) {
		this.balance = balance;
	}

	@Override
	public int getBalance() {
		return 0;
	}

	
}
