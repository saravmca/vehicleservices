package com.vehicleservices.spring.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.vehicleservices.spring.exception.ErrorResponse;


public class ResponseHelper {
	
	@Autowired
	private ErrorResponse errorResponse;
	
	public  ResponseEntity<Object> sendErrorResponse(String errorMessage ) {
		  errorResponse.setErrorMessage(errorMessage);
		  errorResponse.setErrorCode(HttpStatus.BAD_REQUEST.value());
		  return new ResponseEntity<Object>(errorResponse,HttpStatus.BAD_REQUEST); 
	}
	
	
	public  ResponseEntity<Object> sendupdatedResponse(Object obj ) {
		return new ResponseEntity<Object>(obj,HttpStatus.ACCEPTED);
	}
	
	public  ResponseEntity<Object> sendCreatedResponse(Object obj ) {
		return new ResponseEntity<Object>(obj,HttpStatus.CREATED);
	}
	public  ResponseEntity<Object> sendDeletedResponse(String message ) {
		return new ResponseEntity<Object>(message,HttpStatus.ACCEPTED);
	}
}
