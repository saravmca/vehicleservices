package com.vehicleservices.spring.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.vehicleservices.spring.model.Vehicle;
import com.vehicleservices.spring.model.VehicleDetails;
@Component
public class VehicleServiceValidation implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		
		return VehicleDetails.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		Vehicle vehicle = (Vehicle) target;
		if(vehicle.getModel() == null  )
			errors.reject(vehicle.getModel(), "Model Value should Not be empty");
		else if(vehicle.getVehicleTypeId() == null || vehicle.getVehicleTypeId() == "")	
			errors.reject(vehicle.getVehicleTypeId(), "Vehicle Type ID Value is Empty");
		errors.addAllErrors(errors);
	}

}
