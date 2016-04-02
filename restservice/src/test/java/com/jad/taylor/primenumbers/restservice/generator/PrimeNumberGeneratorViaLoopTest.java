package com.jad.taylor.primenumbers.restservice.generator;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import com.jad.taylor.primenumbers.restservice.generator.PrimeNumberGeneratorViaLoop;

public class PrimeNumberGeneratorViaLoopTest extends PrimeNumberTest {
	
	@Before
	public void setup(){
		generator = new PrimeNumberGeneratorViaLoop();
	}
	@Test
	public void testIsPrimePredicate(){
		//boundary cases
		assertTrue(!((PrimeNumberGeneratorViaLoop)generator).isPrime(0).isPrime());
		assertTrue(!((PrimeNumberGeneratorViaLoop)generator).isPrime(1).isPrime());
		//normal cases
		assertTrue(((PrimeNumberGeneratorViaLoop)generator).isPrime(2).isPrime());
		assertTrue(((PrimeNumberGeneratorViaLoop)generator).isPrime(3).isPrime());				
	}
	
	@Test
	public void testGetPrimeNumbersTo10(){
		//boundary cases
		compareValuesUpTo(0);
		compareValuesUpTo(1);
		
		//normal cases
		compareValuesUpTo(2);
		compareValuesUpTo(10);
		compareValuesUpTo(100);
		compareValuesUpTo(300);
	}

	@Test
	public void testPredictae(){
		assertFalse(((PrimeNumberGeneratorViaLoop)generator).isNumberPrime().test(new NumberWrapper(1, false)));
		assertTrue(((PrimeNumberGeneratorViaLoop)generator).isNumberPrime().test(new NumberWrapper(1, true)));

	}
	
	

}
