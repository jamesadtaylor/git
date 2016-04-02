package com.jad.taylor.primenumbers.restservice.manager;

import java.util.Arrays;

public enum AlgorithmType {

	SEIVE, LOOP;
	
	public static boolean isInEnum(String value) {
	    return Arrays.stream(AlgorithmType.class.getEnumConstants()).anyMatch(e -> e.name().equals(value));
	  }
}
