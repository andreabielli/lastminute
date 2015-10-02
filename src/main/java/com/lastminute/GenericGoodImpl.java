package com.lastminute;

import java.math.BigDecimal;

public class GenericGoodImpl implements GenericGood {

	//Sale tax
	private Integer salesTax=Integer.valueOf(10);
	//Import tax
	private static final Integer importTax=Integer.valueOf(5);
	private String name;
	private BigDecimal price;
	private boolean imported;
	
	public GenericGoodImpl(String name, BigDecimal price, boolean imported) {
		
		this.name=name;
		this.price=price;
		this.imported=imported;

	}
	
	/* (non-Javadoc)
	 * @see com.lastminute.GenericGood#getName()
	 */
	public String getName() {
		return name;
	}	

	/* (non-Javadoc)
	 * @see com.lastminute.GenericGood#getPrice()
	 */
	public BigDecimal getPrice() {
		
		//prezzo base
		BigDecimal finalPrice=this.price;
		
		if(this.getSalesTax()!=null){
					
			//tassa da aggiungere al prezzo
			BigDecimal realTax= new BigDecimal((finalPrice.doubleValue()*(this.getSalesTax()+((imported) ? importTax:0)))/100).setScale(2,BigDecimal.ROUND_HALF_UP);			
			int roundTax=(int) (realTax.doubleValue()*100);
			
			//Arrotondo al 0.05 più vicino
			while(roundTax%5!=0)
			{
								
				roundTax+=1;
				
			}
			//il prezzo base più la tassa
			finalPrice=finalPrice.add(new BigDecimal((double)roundTax/100).setScale(2, BigDecimal.ROUND_HALF_UP));
						
			
		}		
		
		
		return finalPrice;
		
	}
	
	public BigDecimal getTotalTax(){
		
		//La tassa è data dalla differenza tra il prezzo tassato meno il prezzo base 
		return getPrice().subtract(this.price).setScale(2, BigDecimal.ROUND_HALF_UP);
	}
	public Integer getSalesTax() {
		return salesTax;
	}
	
}
