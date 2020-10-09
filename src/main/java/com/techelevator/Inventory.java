package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
	
	
	public static void main(String[] args) {
		
		
		ArrayList<String> arrayList = new ArrayList<>();
		File dataFile = new File("vendingmachine.csv");
		try(Scanner dataInput = new Scanner(dataFile)) {
			while(dataInput.hasNextLine()) {
				arrayList.add(dataInput.nextLine());
				}
//			StringBuilder strbul = new StringBuilder();
//			for(String str : arrayList) {
//				strbul.append(str);
//				strbul.append(",");
//			}
//			String str = strbul.toString();
//			
//			System.out.println(str);
			
//			for(int i = 0; i < arrayList.size(); i++) {
//				String itemList = toString(arrayList[i]);
//			}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
		} 
		
		List<String[]> listOfArrays = new ArrayList<>();
		for(String i : arrayList) {
			listOfArrays.add(i.split("\\|"));
			
			System.out.println(i);
		}
	}
}
