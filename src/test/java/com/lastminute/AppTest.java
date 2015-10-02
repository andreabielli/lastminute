package com.lastminute;

import java.math.BigDecimal;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
    	/****OUTPUT1****/
    	
    	//Creazione oggetti Input1
        Books book = new Books("book", new BigDecimal("12.49").setScale(2,BigDecimal.ROUND_HALF_UP), false);
        assertNotNull(book);
        GenericGoodImpl good= new GenericGoodImpl("music CD", new BigDecimal("14.99").setScale(2,BigDecimal.ROUND_HALF_UP), false);
        assertNotNull(good);
        Food food= new Food("chocolate bar", new BigDecimal("0.85"), false);
        assertNotNull(food);
                
        
        //Stampa Output 1
        System.out.println("Output 1\n");
        
        System.out.println("1 "+book.getName()+":"+book.getPrice());
        assertEquals(12.49, book.getPrice().doubleValue());
        
        System.out.println("1 "+good.getName()+":"+good.getPrice());
        assertEquals(16.49, good.getPrice().doubleValue());
        
        System.out.println("1 "+food.getName()+":"+food.getPrice());
        assertEquals(0.85, food.getPrice().doubleValue());
        
        BigDecimal totTax =book.getTotalTax().add(good.getTotalTax()).setScale(2, BigDecimal.ROUND_HALF_UP).add(food.getTotalTax().setScale(2, BigDecimal.ROUND_HALF_UP));
        System.out.println("Sales Taxes "+totTax);
        assertEquals(1.5, totTax.doubleValue());
        
        BigDecimal total=book.getPrice().add(good.getPrice()).setScale(2, BigDecimal.ROUND_HALF_UP).add(food.getPrice()).setScale(2, BigDecimal.ROUND_HALF_UP);
        System.out.println("Total "+total);
        assertEquals(29.83, total.doubleValue());
        
        good= new GenericGoodImpl("bottle of perfume", new BigDecimal("47.50").setScale(2, BigDecimal.ROUND_HALF_UP), true);
        assertNotNull(good);
        food= new Food("box of chocolates", new BigDecimal("10").setScale(2, BigDecimal.ROUND_HALF_UP), true);
        assertNotNull(food);
        
        /****OUTPUT2****/
        
        System.out.println("\nOutput 2\n");
        System.out.println("1 "+food.getName()+":"+food.getPrice());
        assertEquals(10.5, food.getPrice().doubleValue());
        
        System.out.println("1 "+good.getName()+":"+good.getPrice());
        assertEquals(54.65, good.getPrice().doubleValue());
        
        totTax =good.getTotalTax().add(food.getTotalTax()).setScale(2, BigDecimal.ROUND_HALF_UP);
        System.out.println("Sales Taxes "+totTax);
        assertEquals(7.65, totTax.doubleValue());
        
        total=good.getPrice().add(food.getPrice()).setScale(2, BigDecimal.ROUND_HALF_UP);
        System.out.println("Total "+total);
        assertEquals(65.15, total.doubleValue());
        
        good= new GenericGoodImpl("imported bottle of perfume", new BigDecimal("27.99").setScale(2, BigDecimal.ROUND_HALF_UP), true);
        assertNotNull(good);
        GenericGoodImpl good2= new GenericGoodImpl("bottle of perfume", new BigDecimal("18.99").setScale(2, BigDecimal.ROUND_HALF_UP), false);
        assertNotNull(good2);        
        Medical medical= new Medical("packet of headache pills", new BigDecimal("9.75").setScale(2, BigDecimal.ROUND_HALF_UP), false);
        assertNotNull(medical);
        food= new Food("imported box of chocolates", new BigDecimal("11.25").setScale(2, BigDecimal.ROUND_HALF_UP), true);
        assertNotNull(food);
        
        /****OUTPUT3****/
        
        System.out.println("\nOutput 3\n");
        System.out.println("1 "+good.getName()+":"+good.getPrice());
        assertEquals(32.19, good.getPrice().doubleValue());
        
        System.out.println("1 "+good2.getName()+":"+good2.getPrice());
        assertEquals(20.89, good2.getPrice().doubleValue());
        
        System.out.println("1 "+medical.getName()+":"+medical.getPrice());
        assertEquals(9.75, medical.getPrice().doubleValue());
        
        System.out.println("1 "+food.getName()+":"+food.getPrice());
        assertEquals(11.85, food.getPrice().doubleValue());
        
        totTax =good.getTotalTax().add(good2.getTotalTax()).setScale(2, BigDecimal.ROUND_HALF_UP).add(medical.getTotalTax()).setScale(2, BigDecimal.ROUND_HALF_UP).add(food.getTotalTax()).setScale(2, BigDecimal.ROUND_HALF_UP);
        System.out.println("Sales Taxes "+totTax);
        assertEquals(6.70, totTax.doubleValue());
        
        total=good.getPrice().add(good2.getPrice()).setScale(2, BigDecimal.ROUND_HALF_UP).add(medical.getPrice()).setScale(2, BigDecimal.ROUND_HALF_UP).add(food.getPrice()).setScale(2, BigDecimal.ROUND_HALF_UP);
        System.out.println("Total "+total);
        assertEquals(74.68, total.doubleValue());
        
    	
    }
}
