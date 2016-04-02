package com.jad.taylor.primenumbers.restservice.manager;


import org.junit.Assert;
import org.junit.Test;

import com.jad.taylor.primenumbers.restservice.generator.PrimeNumberGeneratorViaLoop;
import com.jad.taylor.primenumbers.restservice.generator.PrimeNumberGeneratorViaSeive;

public class GeneratorFactoryTest {
	
	@Test
	public void getAlgorithms(){
		Assert.assertTrue(GeneratorFactory.getInstance(AlgorithmType.LOOP) instanceof PrimeNumberGeneratorViaLoop);
		Assert.assertTrue(GeneratorFactory.getInstance(AlgorithmType.SEIVE) instanceof PrimeNumberGeneratorViaSeive);

	}

}
