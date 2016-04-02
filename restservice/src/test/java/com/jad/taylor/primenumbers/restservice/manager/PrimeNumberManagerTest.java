package com.jad.taylor.primenumbers.restservice.manager;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class PrimeNumberManagerTest {

	private PrimeNumberManager manager = new PrimeNumberManager();
	
	@Test
	public void testBothAlgorithmsReturnTheSameList(){
		assertThat(manager.getPrimes(0, AlgorithmType.LOOP), is(manager.getPrimes(0, AlgorithmType.SEIVE)));
		assertThat(manager.getPrimes(1, AlgorithmType.LOOP), is(manager.getPrimes(1, AlgorithmType.SEIVE)));
		assertThat(manager.getPrimes(2, AlgorithmType.LOOP), is(manager.getPrimes(2, AlgorithmType.SEIVE)));

		assertThat(manager.getPrimes(100, AlgorithmType.LOOP), is(manager.getPrimes(100, AlgorithmType.SEIVE)));
		assertThat(manager.getPrimes(5000, AlgorithmType.LOOP), is(manager.getPrimes(5000, AlgorithmType.SEIVE)));
		assertThat(manager.getPrimes(10000, AlgorithmType.LOOP), is(manager.getPrimes(10000, AlgorithmType.SEIVE)));
		
	}
	
	
}
