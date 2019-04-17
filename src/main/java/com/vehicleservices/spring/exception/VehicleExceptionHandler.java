package com.vehicleservices.spring.exception;


import java.io.PrintWriter;
import java.io.StringWriter;

import org.apache.log4j.Logger;
import org.hibernate.exception.DataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class VehicleExceptionHandler {
		
		@Autowired
		ErrorResponse errorResponse;
		private static Logger logger = Logger.getLogger(VehicleExceptionHandler.class);
	 	@ExceptionHandler({VehicleTypeNotFoundException.class})
	    public ResponseEntity<ErrorResponse> handleTypeNotException(Exception ex) {
	 		errorResponse.setErrorCode(HttpStatus.PRECONDITION_FAILED.value());
	        errorResponse.setErrorMessage(ex.getMessage());
	        logger.info("VehicleExceptionHandler.handleTypeNotException()" +ex);
	        return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.OK);
	    }
	 	@ExceptionHandler({VehicleNotFoundException.class})
	    public ResponseEntity<ErrorResponse> handleVehicleIdNotFoundException(Exception ex) {
	 		errorResponse.setErrorCode(HttpStatus.PRECONDITION_FAILED.value());
	        errorResponse.setErrorMessage(ex.getMessage());
	        logger.info("VehicleExceptionHandler.handleVehicleIdNotFoundException()" +ex);
	        return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.OK);
	    }
	 	
	 	@ExceptionHandler({ValidationException.class})
	    public ResponseEntity<ErrorResponse> handleValidateException(Exception ex) {
	 		errorResponse.setErrorCode(HttpStatus.PRECONDITION_FAILED.value());
	        errorResponse.setErrorMessage(ex.getMessage());
	        logger.info("VehicleExceptionHandler.handleValidateException" +ex);
	        return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.OK);
	    }
	 	@ExceptionHandler({DataException.class})
	    public ResponseEntity<ErrorResponse> dataAccessException(Exception ex) {
	 		errorResponse.setErrorCode(HttpStatus.PRECONDITION_FAILED.value());
	        errorResponse.setErrorMessage(ex.getMessage());
	        logger.info("VehicleExceptionHandler.dataAccessException" +ex);
	        return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.OK);
	    }
	 	@ExceptionHandler({Exception.class})
	    public ResponseEntity<ErrorResponse> handleException(Exception ex) {
	 		errorResponse.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
	        errorResponse.setErrorMessage((null!=ex.getMessage()?ex.getMessage():"Error occured"));
	        ex.printStackTrace();
	        StringWriter stack = new StringWriter();
	        ex.printStackTrace(new PrintWriter(stack));
	        logger.info("VehicleExceptionHandler.handleException" +stack.toString());
	        return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.OK);
	    }
}
