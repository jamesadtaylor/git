package com.jad.taylor.primenumbers.restservice.service;

import javax.xml.ws.WebServiceException;

import org.junit.Before;
import org.junit.Test;

import com.jad.taylor.primenumbers.restservice.manager.PrimeNumberManager;

public class PrimeNumberResourceTest {

	private PrimeNumberResource primeNumberResource;
	
	@Before
	public void setup(){
		primeNumberResource = new PrimeNumberResource(new PrimeNumberManager());
	}
	
	@Test(expected = WebServiceException.class) 
	public void testRequestWithIncorrectAlgorithmType(){
		primeNumberResource.getNumbers("BadName", 100);
	}
	
	@Test(expected = WebServiceException.class) 
	public void testRequestWithAValueThatIsTooLarge(){
		primeNumberResource.getNumbers("loop", 100000000);
	}
}
