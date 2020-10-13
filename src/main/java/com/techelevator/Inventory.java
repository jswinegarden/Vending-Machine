package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Inventory {
	

	private String slotLocation;
	private String productName;
	private String productType;
	private BigDecimal price;
	private int productAmount = 5;
	
	public Inventory(String slotLocation, String productName, String productType, BigDecimal price) {
		this.slotLocation = slotLocation;
		this.productName = productName;
		this.productType = productType;
		this.price = price;
	}	

	public Inventory(int input) {}

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

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public int stockInventory(int productToStock) {
		productToStock = 5 - productAmount;
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

	  @Override
	public String toString() { 
			return slotLocation.toString() + " " +
			productName.toString() + " " +
			productType.toString() + " " +
			price + " " +
			productAmount;
	}
}
	
