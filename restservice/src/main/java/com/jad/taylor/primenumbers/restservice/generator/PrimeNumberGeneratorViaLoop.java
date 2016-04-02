package com.jad.taylor.primenumbers.restservice.generator;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

import javax.xml.ws.WebServiceException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PrimeNumberGeneratorViaLoop implements PrimeNumberGenerator {

	private static Logger log = LoggerFactory.getLogger(PrimeNumberGeneratorViaLoop.class);

	@Override
	public List<Integer> getPrimeNumbers(int value) {
		List<Integer> primes = new ArrayList<>();
		ExecutorService executor = null;
		try {
			executor = Executors.newWorkStealingPool(3);

			List<Callable<NumberWrapper>> callables = new ArrayList<>();
			for (int i = 2; i <= value; i++) {
				callables.add(task(i));
			}

			primes = executor.invokeAll(callables).stream().map(future -> {
				try {
					return future.get();
				} catch (Exception e) {
					log.warn(e.getMessage(), e);
					throw new IllegalStateException(e);
				}
			}).filter(isNumberPrime()).mapToInt(p -> p.getNumber()).boxed().sorted().collect(Collectors.toList());
		} catch (IllegalStateException | InterruptedException e) {
			log.warn(e.getMessage(), e);
			throw new WebServiceException(e.getMessage(), e);
		} finally {
			if (executor != null) {
				executor.shutdown();
			}
		}

		return primes;

	}

	NumberWrapper isPrime(int x) {
		NumberWrapper number = null;
		if (x < 2) {
			number = new NumberWrapper(x, false);
		} else {
			number = new NumberWrapper(x, LongStream.rangeClosed(2, (long) (Math.sqrt(x))).allMatch(n -> x % n != 0));
		}
		return number;
	}

	Predicate<NumberWrapper> isNumberPrime() {
		return p -> p.isPrime();
	}

	private Callable<NumberWrapper> task(int x) {
		return () -> {
			return isPrime(x);
		};
	}

}
