package com.jad.taylor.primenumbers.restservice.generator;

import org.junit.Before;
import org.junit.Test;

public class PrimeNumberGeneratorViaSeiveTest extends PrimeNumberTest {
	
	@Before
	public void setup(){
		generator = new PrimeNumberGeneratorViaSeive();
	}
	
	
	@Test
	public void testGetPrimeNumbers(){
		//boundary cases
		compareValuesUpTo(0);
		compareValuesUpTo(1);
		
		//normal cases
		compareValuesUpTo(2);
		compareValuesUpTo(10);
		compareValuesUpTo(100);
		compareValuesUpTo(300);
	}

	
	
	

}
