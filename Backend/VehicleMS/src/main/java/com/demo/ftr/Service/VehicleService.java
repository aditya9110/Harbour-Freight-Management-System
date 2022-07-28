package com.demo.ftr.Service;

import java.util.List;

import com.demo.ftr.DTO.VehicleDTO;
import com.demo.ftr.exception.VehicleNotfound;
import com.demo.ftr.exception.VehicleUpdateAlreadyExists;

public interface VehicleService {
	
	public String insertNewVehicle(VehicleDTO vehicleDto) throws VehicleNotfound;
	public List<VehicleDTO> fetchAvailableVehicles() throws VehicleNotfound;
	public List<VehicleDTO> fetchVehicleDetailsByVehicleName(String vehicleName) throws VehicleNotfound;
	public VehicleDTO fetchVehicleDetailsByVehicleNumber(String vehicleNumber) throws VehicleNotfound;
	public String updateVehicleStatus(String vehicleNum, VehicleDTO dto) throws VehicleNotfound;
	public String removeVehicle(String vehicleNum) throws VehicleNotfound;
	//public  VehicleDTO insertNewVehicle(String vehicleDto);

}
