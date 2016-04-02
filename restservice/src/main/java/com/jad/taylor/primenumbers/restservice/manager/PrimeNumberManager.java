package com.jad.taylor.primenumbers.restservice.manager;

import java.util.Collection;

import com.jad.taylor.primenumbers.restservice.generator.PrimeNumberGenerator;

public class PrimeNumberManager {

	public Collection<Integer> getPrimes(int number, AlgorithmType algoType) {
		PrimeNumberGenerator generator = GeneratorFactory.getInstance(algoType);
		return generator.getPrimeNumbers(number);
	}

}
