package com.vehicleservices.spring.exception;

public class VehicleNotFoundException extends  Exception{
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String errorMessage;

	public VehicleNotFoundException(String errorMessage) {
		super();
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	 
	
}
