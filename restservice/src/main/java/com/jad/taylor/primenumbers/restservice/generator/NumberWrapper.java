package com.jad.taylor.primenumbers.restservice.generator;

public class NumberWrapper {
		private boolean isPrime;
		private int number;
		
		public NumberWrapper(int x, boolean allMatch) {
			 number = x;
			 isPrime = allMatch;
		}

		public boolean isPrime() {
			return isPrime;
		}

		public void setPrime(boolean isPrime) {
			this.isPrime = isPrime;
		}

		public int getNumber() {
			return number;
		}

		public void setNumber(int number) {
			this.number = number;
		}
		
	
}
