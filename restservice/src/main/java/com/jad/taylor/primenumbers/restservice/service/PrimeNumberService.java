package com.jad.taylor.primenumbers.restservice.service;

import com.hubspot.dropwizard.guice.GuiceBundle;
import com.jad.taylor.primenumbers.restservice.exception.RuntimeExceptionMapper;

import io.dropwizard.Application; 
import io.dropwizard.setup.Bootstrap; 
import io.dropwizard.setup.Environment;

public class PrimeNumberService extends Application<ServerConfiguration> {
 
    public static void main(String[] args) throws Exception {
        new PrimeNumberService().run(new String[] { "server" });
    }
 
    @Override
    public void initialize(Bootstrap<ServerConfiguration> bootstrap) {
    	 GuiceBundle<ServerConfiguration> guiceBundle =       
    			 GuiceBundle.<ServerConfiguration>newBuilder()
    		      .addModule(new ServerModule())
    		      .setConfigClass(ServerConfiguration.class)
    		      .enableAutoConfig(getClass().getPackage().getName())
    		      .build();
    		      bootstrap.addBundle(guiceBundle);   
    }
 
    @Override
    public void run(ServerConfiguration configuration, Environment environment) throws Exception {
    	 environment.jersey().register(RuntimeExceptionMapper.class);
    }
 
}