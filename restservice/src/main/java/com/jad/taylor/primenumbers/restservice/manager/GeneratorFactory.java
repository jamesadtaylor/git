package com.jad.taylor.primenumbers.restservice.manager;

import com.jad.taylor.primenumbers.restservice.generator.PrimeNumberGeneratorViaLoop;
import com.jad.taylor.primenumbers.restservice.generator.PrimeNumberGenerator;
import com.jad.taylor.primenumbers.restservice.generator.PrimeNumberGeneratorViaSeive;

public class GeneratorFactory {

	public static PrimeNumberGenerator getInstance(AlgorithmType type) {
		PrimeNumberGenerator generator = null;
		
		switch (type) {
		case LOOP:
			generator = new PrimeNumberGeneratorViaLoop();
			break;
		case SEIVE:
			generator = new PrimeNumberGeneratorViaSeive();
			break;
		default:
			break;
		}
		return generator;
	}

}
