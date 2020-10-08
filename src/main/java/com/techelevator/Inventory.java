package com.techelevator;

public class Inventory {

	private String slotLocation;
	private String productName;
	private String productType;
	private double price;
	
	public Inventory(String slotLocation, String productName, String productType, double price) {
		this.slotLocation = slotLocation;
		this.productName = productName;
		this.productType = productType;
		this.price = price;
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
	
	
}
