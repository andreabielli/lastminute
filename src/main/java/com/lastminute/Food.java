package com.lastminute;

import java.math.BigDecimal;

public class Food extends GenericGoodImpl {

	private Integer salesTax=Integer.valueOf(0);
	
	public Food(String name,BigDecimal price,boolean imported) {
		super(name,price,imported);
		
 }
	
	public Integer getSalesTax() {
		return salesTax;
	}
		
	

}
