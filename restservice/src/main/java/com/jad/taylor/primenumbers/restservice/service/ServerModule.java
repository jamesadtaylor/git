package com.jad.taylor.primenumbers.restservice.service;

import com.google.inject.Binder; 
import com.google.inject.Module; 
import com.google.inject.Provides;
import com.jad.taylor.primenumbers.restservice.manager.PrimeNumberManager;

import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServerModule implements Module { 
	private static Logger log = LoggerFactory.getLogger(ServerModule.class);

	@Override
   public void configure(Binder binder) {
   }

   @Provides
   @Named("primeNumberManager")
   public PrimeNumberManager providePrimeNumberManager(ServerConfiguration serverConfiguration) {
	   log.info("getting primeNumberManager");
	   return serverConfiguration.getPrimeNumberManager();
   }
}