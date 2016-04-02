package com.jad.taylor.primenumbers.restservice.generator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PrimeNumberGeneratorViaSeive implements PrimeNumberGenerator {

	@Override
	public List<Integer> getPrimeNumbers(int value) {
		// initially assume all integers are prime
		List<NumberWrapper> isPrime = new ArrayList<>();
		isPrime.add(new NumberWrapper(0, false));
		isPrime.add(new NumberWrapper(1, false));

		for (int i = 2; i <= value; i++) {
			isPrime.add(new NumberWrapper(i, true));
		}

		// mark non-primes <= N using Sieve of Eratosthenes
		for (int i = 2; i * i <= value; i++) {
			// if i is prime, then mark multiples of i as nonprime
			// suffices to consider mutiples i, i+1, ..., N/i
			if (isPrime.get(i).isPrime()) {
				for (int j = i; i * j <= value; j++) {
					isPrime.get(i * j).setPrime(false);
				}
			}
		}
		return isPrime.stream().filter((x) -> x.isPrime()).mapToInt((x) -> x.getNumber()).boxed()
				.collect(Collectors.toList());
	}

}
