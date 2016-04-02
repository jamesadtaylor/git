package com.jad.taylor.primenumbers.restservice.service;

import com.jad.taylor.primenumbers.restservice.manager.PrimeNumberManager;
import io.dropwizard.Configuration;
 
public class ServerConfiguration extends Configuration {
 	   public PrimeNumberManager getPrimeNumberManager() {
	      return new PrimeNumberManager();
	   }
}
