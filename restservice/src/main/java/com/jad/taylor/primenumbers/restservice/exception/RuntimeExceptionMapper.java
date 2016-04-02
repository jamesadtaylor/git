package com.jad.taylor.primenumbers.restservice.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * <p>
 * Provider to provide the following to Jersey framework:
 * </p>
 * <ul>
 * <li>Provision of general runtime exception to response mapping</li>
 * </ul>
 */
@Provider
public class RuntimeExceptionMapper implements ExceptionMapper<RuntimeException> {
	private static Logger log = LoggerFactory.getLogger(RuntimeExceptionMapper.class);
	private static String responseText = " The URL you have requested could not be processed. If the problem persists, please contact the site administrator.";

	@Override
	public Response toResponse(RuntimeException exception) {
		log.error(exception.getMessage(), exception);
		Response defaultResponse = Response.status(Status.OK).entity(responseText).build();
		return defaultResponse;
	}

}