package com.demo.ftr.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.ftr.DTO.VehicleDTO;
import com.demo.ftr.Service.VehicleService;
import com.demo.ftr.exception.VehicleNotfound;

@RestController
@RequestMapping(value = "/ftr/vehicles")
public class VehicleController {

	@Autowired
	VehicleService vehicleser;

	@PostMapping()
	public ResponseEntity<String> insertNewVehicle(@RequestBody VehicleDTO vehicleDto) throws VehicleNotfound {
		String variable3 = vehicleser.insertNewVehicle(vehicleDto);
		ResponseEntity<String> ent = new ResponseEntity<>(variable3, HttpStatus.ACCEPTED);
		return ent;

	}

	@GetMapping()
	public ResponseEntity<List<VehicleDTO>> fetchAvailableVehicles() throws VehicleNotfound {
		List<VehicleDTO> variable5 = vehicleser.fetchAvailableVehicles();
		String msg = "Invalid";

		ResponseEntity<List<VehicleDTO>> ent = new ResponseEntity<>(variable5, HttpStatus.ACCEPTED);
		return ent;
	}

	@PutMapping(value = "/{vehicleNumber}")
	public ResponseEntity<String> updateVehicleStatus(@PathVariable String vehicleNumber, @RequestBody VehicleDTO dto)
			throws VehicleNotfound {
		String variable4 = vehicleser.updateVehicleStatus(vehicleNumber, dto);
		ResponseEntity<String> ent = new ResponseEntity<>(variable4, HttpStatus.ACCEPTED);
		return ent;

	}

	@GetMapping(value = "/managedname/{vehicleName}")
	public ResponseEntity<List<VehicleDTO>> fetchVehicleDetailsByVehicleName(@PathVariable String vehicleName

	) throws VehicleNotfound {
		List<VehicleDTO> variable2 = vehicleser.fetchVehicleDetailsByVehicleName(vehicleName);
		String msg = "Invalid";

		ResponseEntity<List<VehicleDTO>> ent = new ResponseEntity<>(variable2, HttpStatus.ACCEPTED);
		return ent;

	}

	@GetMapping(value = "/{vehicleNumber}")
	public ResponseEntity<VehicleDTO> fetchVehicleDetailsByVehicleNumber(@PathVariable String vehicleNumber

	) throws VehicleNotfound {
		VehicleDTO variable = vehicleser.fetchVehicleDetailsByVehicleNumber(vehicleNumber);
		String msg = "Invalid";

		ResponseEntity<VehicleDTO> ent = new ResponseEntity<>(variable, HttpStatus.ACCEPTED);
		return ent;

	}

	@DeleteMapping(value = "/{vehicleNumber}")
	public ResponseEntity<String> removeVehicle(@PathVariable String vehicleNumber) throws VehicleNotfound {
		String variable5 = vehicleser.removeVehicle(vehicleNumber);

		ResponseEntity<String> ent = new ResponseEntity<>(variable5, HttpStatus.ACCEPTED);
		return ent;

	}

}
