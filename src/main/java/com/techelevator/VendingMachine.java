package com.techelevator;

public class VendingMachine {

	private String slotLocation;
	private String productName;
	private String productType;
	private int productAmount;
	private double price;
	
	public VendingMachine(String slotLocation, String productName, String productType, int productAmount, double price) {
		this.slotLocation = slotLocation;
		this.productName = productName;
		this.productType = productType;
		this.price = price;
		this.productAmount = productAmount;
	}
	
	public int stockInventory(int productToStock) {
		productAmount += productToStock;
		return productAmount;
	}

	public String getSlotLocation() {
		return slotLocation;
	}

	public void setSlotLocation(String slotLocation) {
		this.slotLocation = slotLocation;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getProductAmount() {
		return productAmount;
	}

	public void setProductAmount(int productAmount) {
		this.productAmount = 5;
	}
	
	
}
