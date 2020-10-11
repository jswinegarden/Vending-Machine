package com.techelevator;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class VendingMachineTests {

	@Test
	public void check_that_balance_is_zero() throws IOException {
		VendingMachine dispensesChange = new VendingMachine(null, 0);
		BigDecimal output = dispensesChange.dispenseChange(new BigDecimal(10.00));
		Assert.assertEquals(new BigDecimal(0), output);
	}

//	@Test
//	public void check_for_nickels() {
//	VendingMachine dispensesChange = new VendingMachine(null, 0);
//	int output = dispensesChange.dispenseChange();
//	Assert.assertEquals(expected, output);
//	
//	}
	
	private List<String> lstTest = new ArrayList<>(); 
			
	
	@Before
	public void init() {
		lstTest.add("Potato Crisps");
		lstTest.add("Stackers");
		lstTest.add("Grain Waves");
		lstTest.add("Cloud Popcorn");
		lstTest.add("Moonpie");
		lstTest.add("Cowtales");
		lstTest.add("Wonka Bar");
		lstTest.add("Crunchie");
		lstTest.add("Cola");
		lstTest.add("Dr. Salt");
		lstTest.add("Mountain Melter");
		lstTest.add("Heavy");
		lstTest.add("U-Chews");
		lstTest.add("Little League");
		lstTest.add("Chiclets");
		lstTest.add("Triplemint");
	}
	
	List<Inventory> objectList = new ArrayList<Inventory>();
	
	@Test
	public void check_print_stock_size() {
		Assert.assertEquals("checking size of list", 16, lstTest.size());
	}
	
//	@Test
//	public void check_print_stock_output() {
//		VendingMachine printingStock = new VendingMachine();
//		List<String> output = printingStock.printStock();
//		Assert.assert
//	}
	
	@Test
	public void check_get_item() {
		VendingMachine gettingItem = new VendingMachine(objectList, 0);
		Inventory output = gettingItem.getItem("A1");
		Assert.assertEquals("Potato Crisps", output);
	}
}
