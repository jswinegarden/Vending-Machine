package com.techelevator;


import java.text.SimpleDateFormat;
import java.util.Date;

public class AuditLog {

	public void date() {
	
		Date date = new Date() ;
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm") ;
		dateFormat.format(date);
		System.out.println(dateFormat.format(date));
	}
}
