# primenumbers
service for calculating prime numbers

About
-----
* This rest service is intended to return all prime numbers between 1 and a number the user specifies.
* It uses two different algorithms to calculate prime numbers:
	1. Via looping to the square root of the number being requested (this is multi threaded)
	2. Via a mathematical algorithm called the Sieve of Eratosthenes (https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes).

Although the looping algorithm is multi-threaded, it can be seen to be the less performant of the two algorithms used.

Technologies Used
-----------------
* Java 8
* Dropwizard (jersey, guice, jetty)
* junit & jacoco (for testing and test coverage)
* maven for build

Build & Deploy
---------------
* To build: mvn clean install
* To view test coverage after build: target/site/index.html
* To start the server: run the main class in com.jad.taylor.primenumbers.restservice.service.PrimeNumberService
* This code was written in eclipse and the committed code includes the .project file, so this code can be easily imported into eclipse

Usage
-----
Example requests:
To access through a browser and request prime numbers between 1 and 1000:
* http://localhost:8080/service/primenumbers/seive/1000 (Seive algorithm)
or
* http://localhost:8080/service/primenumbers/loop/1000 (Looping algorithm)

Security/Stability of the service
---------------------------------
* All invalid requests to the service return status code 200 and a standard message
* The service will never return a stacktrace to the end user
* The service was capped at returning requests up to 5000000 numbers, to ensure that no excessive requests could be made.
