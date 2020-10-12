package com.techelevator;

import org.junit.Test;

import org.junit.Assert;

public class InventoryTests {
	
	private Inventory objectToTest;
	
	private void helper_dispense(int input, int expectedOutput) {
		this.objectToTest = new Inventory(input);
		int actualOutput = objectToTest.dispense(input);
		Assert.assertEquals(expectedOutput, actualOutput);
	}

	@Test
	public void check_dispense_1() {
		helper_dispense(1, 4);
	}
	
	@Test
	public void check_dispense_2() {
		helper_dispense(2, 3);
	}
	
	@Test
	public void check_dispense_3() {
		helper_dispense(3, 2);
	}
	
	@Test
	public void check_dispense_4() {
		helper_dispense(4, 1);
	}
	
	@Test
	public void check_dispense_5() {
		helper_dispense(5, 0);
	}
	
	private void helper_stock(int input, int expectedOutput) {
		this.objectToTest = new Inventory(input);
		int actualOutput = objectToTest.stockInventory(input);
		Assert.assertEquals(expectedOutput, actualOutput);
	}
	
	@Test
	public void check_stock_1() {
		helper_stock(1, 5);
	}
	
	@Test
	public void check_stock_2() {
		helper_stock(2, 5);
	}
	
	@Test
	public void check_stock_3() {
		helper_stock(3, 5);
	}
	
	@Test
	public void check_stock_4() {
		helper_stock(4, 5);
	}
	
	@Test
	public void check_stock_5() {
		helper_stock(5, 5);
	}
}
