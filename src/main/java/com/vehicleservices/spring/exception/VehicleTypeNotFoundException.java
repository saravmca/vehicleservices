package com.vehicleservices.spring.exception;

public class VehicleTypeNotFoundException extends Exception{
	 private static final long serialVersionUID = 1L;
	    private String errorMessage;
	 
	    public VehicleTypeNotFoundException() {
	        super();
	    }
	 
	    public VehicleTypeNotFoundException(String errorMessage) {
	        super(errorMessage);
	        this.errorMessage = errorMessage;
	    }
	 
	    public String getErrorMessage() {
	        return errorMessage;
	    }
}
