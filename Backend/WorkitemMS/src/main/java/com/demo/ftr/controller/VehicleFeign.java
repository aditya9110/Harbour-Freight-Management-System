package com.demo.ftr.controller;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.demo.ftr.dto.VehicleDTO;

@FeignClient(name = "VehicleMS")
public interface VehicleFeign {
	
	@GetMapping(value = "/ftr/vehicles")
	List<VehicleDTO> fetchAvailableVehicles();
	
	@PutMapping(value = "/ftr/vehicles/{vehicleNumber}")
	String updateVehicleStatus(@PathVariable String vehicleNumber, @RequestBody VehicleDTO dto);
	
}
