package com.vehicleservices.spring.service;
/**
 * @Author Saravanan
 */
import java.util.List;

import com.vehicleservices.spring.model.RefVehicleTypes;
import com.vehicleservices.spring.model.Vehicle;


public interface VehicleService {
	
	Vehicle save(Vehicle vehicle) ;
	void saveOrUpdate(Vehicle vehicle);
	List<Vehicle> getVehicleList();
	Vehicle GetVehicle(int id);
	int deleteVehicleById(int id);
	int deleteLastVehicle();
	RefVehicleTypes getRefVehicleTypeById(String vehicleTypeId);
	
}
