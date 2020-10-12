package com.techelevator;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class VendingMachineTests {
	
	VendingMachine vendingMachines = new VendingMachine(null, 0);
	

	@Test
	public void check_that_balance_is_zero() throws IOException {
		VendingMachine dispensesChange = new VendingMachine(null, 0);
		BigDecimal output = dispensesChange.dispenseChange(new BigDecimal(10.00));
		Assert.assertEquals(new BigDecimal(0), output);
	}

	@Test
	public void check_get_item() throws IOException {
	
	File dataFile = new File("vendingmachine.csv");
	
	try(Scanner dataInput = new Scanner(dataFile)) {
		List<Inventory> items = new ArrayList<Inventory>();
		while(dataInput.hasNextLine()) {
			String line = dataInput.nextLine();
			String[] separateLine = line.split("\\|");
			String slotLocation = separateLine[0]; 
			String productName = separateLine[1];
			String productType = separateLine[3];
			BigDecimal price = new BigDecimal(separateLine[2]); 
			Inventory item = new Inventory(slotLocation, productName, productType, price);
			items.add(item);
		
		VendingMachine gettingItem = new VendingMachine(items, 0);
		Inventory output = gettingItem.getItem(separateLine[0]);
		Assert.assertEquals(item, output);
			}
		}
	}
}
