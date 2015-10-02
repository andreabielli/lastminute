package com.lastminute;

import java.math.BigDecimal;

public class Medical extends GenericGoodImpl {

	private Integer salesTax=Integer.valueOf(0);

	
	public Medical(String name,BigDecimal price,boolean imported) {
		super(name,price,imported);
	}
		
	public Integer getSalesTax() {
		return salesTax;
	}
	

}
