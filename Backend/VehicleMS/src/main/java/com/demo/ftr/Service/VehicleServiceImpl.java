package com.demo.ftr.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.ftr.DTO.VehicleDTO;
import com.demo.ftr.Entity.VehicleEntity;
import com.demo.ftr.Repository.VehicleRepository;
import com.demo.ftr.exception.VehicleNotfound;

@Service
@Transactional
public class VehicleServiceImpl implements VehicleService {

	@Autowired
	private VehicleRepository vehicleRepo;

	@Autowired
	public VehicleServiceImpl(VehicleRepository vehicleRepo) {
		super();
		this.vehicleRepo = vehicleRepo;
	}

// INSERT NEW VEHICLE
	@Override
	public String insertNewVehicle(VehicleDTO vehicleDto) throws VehicleNotfound {
		Optional<VehicleEntity> o = vehicleRepo.findByVehicleNumber(vehicleDto.getVehicleNumber());
		if (o.isPresent()) {
			throw new VehicleNotfound("Invalid Data");
		}
		vehicleRepo.saveAndFlush(VehicleDTO.converttoEntity(vehicleDto));

		return "Vehicle details are inserted successfully with vehicle number: " + vehicleDto.getVehicleNumber();

	}

	// FETCH ALL VEHICLES
	@Override
	public List<VehicleDTO> fetchAvailableVehicles() throws VehicleNotfound {
		List<VehicleDTO> lst = new ArrayList<>();
		List<VehicleEntity> o = vehicleRepo.findAll();
		if (o.isEmpty()) {
			throw new VehicleNotfound("Invalid Data");
		} else {
			o.forEach(v -> {
				VehicleDTO dt = v.converttodto(v);
				lst.add(dt);
			});
			return lst;

		}

	}

// FETCH DETAILS BY VEHICLE NAME

	@Override
	public List<VehicleDTO> fetchVehicleDetailsByVehicleName(String vehicleName) throws VehicleNotfound {
		List<VehicleEntity> o = vehicleRepo.findByVehicleName(vehicleName);
		List<VehicleDTO> lst = new ArrayList<>();
		if (o.isEmpty()) {
			throw new VehicleNotfound("Invalid Data");
		} else {
			o.forEach(v -> {
				VehicleDTO dt = v.converttodto(v);
				lst.add(dt);
			});
			return lst;

		}

	}

	// FETCH DETAILS BY VEHICLE NUMBER

	@Override
	public VehicleDTO fetchVehicleDetailsByVehicleNumber(String vehicleNumber) throws VehicleNotfound {
		Optional<VehicleEntity> o = vehicleRepo.findByVehicleNumber(vehicleNumber);
		if (o.isPresent()) {
			return VehicleEntity.converttodto(o.get());
		} else {
			throw new VehicleNotfound("Invalid Data");
		}
	}

	//// UPDATE VEHICLE STATUS

	@Override
	public String updateVehicleStatus(String vehicleNum, VehicleDTO dto) throws VehicleNotfound {
		Optional<VehicleEntity> o = vehicleRepo.findByVehicleNumber(vehicleNum);
		if (o.isEmpty()) {
			throw new VehicleNotfound("Invalid Data");
		} else {
			VehicleEntity b = o.get();
			b.setVehicleStatus(dto.getVehicleStatus());

		}

		return "Status of vehicleNumber : " + vehicleNum + " updated successfully ";

	}

	// DELETE VEHICLE

	@Override
	public String removeVehicle(String vehicleNum) throws VehicleNotfound {
		Optional<VehicleEntity> o = vehicleRepo.findByVehicleNumber(vehicleNum);
		if (o.isEmpty()) {
			throw new VehicleNotfound("Invalid Data");
		}
		vehicleRepo.removeVehicle(vehicleNum);

		return "Vehicle details are deleted successfully";

	}

}
