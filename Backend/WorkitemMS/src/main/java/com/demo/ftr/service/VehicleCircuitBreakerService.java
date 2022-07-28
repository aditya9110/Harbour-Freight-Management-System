package com.demo.ftr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.ftr.controller.VehicleFeign;
import com.demo.ftr.dto.VehicleDTO;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class VehicleCircuitBreakerService {

	@Autowired
	VehicleFeign vehicleFeign;

	@CircuitBreaker(name = "vehicleService")
	public List<VehicleDTO> fetchAvailableVehicles() {
		return vehicleFeign.fetchAvailableVehicles();
	}
	
	@CircuitBreaker(name = "vehicleService")
	public String updateVehicleStatus(String vehicleNumber, VehicleDTO dto) {
		
		return vehicleFeign.updateVehicleStatus(vehicleNumber, dto);
	}
	
}
