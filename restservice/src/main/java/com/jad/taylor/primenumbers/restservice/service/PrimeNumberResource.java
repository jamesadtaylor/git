package com.jad.taylor.primenumbers.restservice.service;

import java.util.Collection;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.ws.WebServiceException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.codahale.metrics.annotation.Timed;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.jad.taylor.primenumbers.restservice.manager.AlgorithmType;
import com.jad.taylor.primenumbers.restservice.manager.PrimeNumberManager;

@Path("/service")
public class PrimeNumberResource {

	private static final int MAX_VALUE = 5000000;
	private static Logger log = LoggerFactory.getLogger(PrimeNumberResource.class);
	private PrimeNumberManager primeNumberManager;

	@Inject
	public PrimeNumberResource(@Named("primeNumberManager") PrimeNumberManager pnManager) {
		primeNumberManager = pnManager;
	}

	@GET
	@Produces(value = MediaType.APPLICATION_JSON)
	@Timed
	@Path("/primenumbers/{method}/{number}")
	public Collection<Integer> getNumbers(@PathParam("method") String method, @PathParam("number") int number) {
		if (number >= MAX_VALUE) {
			log.warn("choosen value " + number + " is larger than max value " + MAX_VALUE);
			throw new WebServiceException("choosen value " + number + " is larger than max value " + MAX_VALUE);
		}
		AlgorithmType type = getAlgorithmType(method.toUpperCase());
		return primeNumberManager.getPrimes(number, type);
	}

	private AlgorithmType getAlgorithmType(String method) {
		AlgorithmType algoType;
		if (AlgorithmType.isInEnum(method)) {
			algoType = AlgorithmType.valueOf(method);
		} else {
			log.warn("Invalid algorithm type " + method + " has been choosen");
			throw new WebServiceException("Invalid algorithm type " + method + "has been choosen");
		}
		return algoType;
	}

}
