package com.demo.ftr.DTO;

import java.time.LocalDate;

import com.demo.ftr.Entity.VehicleEntity;

public class VehicleDTO {
	
	private String vehicleNumber;
	private String vehicleName;
	private double maxLiftingCapacity;
	private LocalDate retireDate;
	private String vehicleStatus;
	private String country;
	private String harborLocation;
	public  String getVehicleNumber() {
		return vehicleNumber;
	}
	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	public String getVehicleName() {
		return vehicleName;
	}
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	public double getMaxLiftingCapacity() {
		return maxLiftingCapacity;
	}
	public void setMaxLiftingCapacity(double maxLiftingCapacity) {
		this.maxLiftingCapacity = maxLiftingCapacity;
	}
	public LocalDate getRetireDate() {
		return retireDate;
	}
	public void setRetireDate(LocalDate retireDate) {
		this.retireDate = retireDate;
	}
	public String getVehicleStatus() {
		return vehicleStatus;
	}
	public void setVehicleStatus(String vehicleStatus) {
		this.vehicleStatus = vehicleStatus;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getHarborLocation() {
		return harborLocation;
	}
	public void setHarborLocation(String harborLocation) {
		this.harborLocation = harborLocation;
	}
	public VehicleDTO(String vehicleNumber, String vehicleName, double maxLiftingCapacity, LocalDate retireDate,
			String vehicleStatus, String country, String harborLocation) {
		super();
		this.vehicleNumber = vehicleNumber;
		this.vehicleName = vehicleName;
		this.maxLiftingCapacity = maxLiftingCapacity;
		this.retireDate = retireDate;
		this.vehicleStatus = vehicleStatus;
		this.country = country;
		this.harborLocation = harborLocation;
	}
	public VehicleDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "VehicleDTO [vehicleNumber=" + vehicleNumber + ", vehicleName=" + vehicleName + ", maxLiftingCapacity="
				+ maxLiftingCapacity + ", retireDate=" + retireDate + ", vehicleStatus=" + vehicleStatus + ", country="
				+ country + ", harborLocation=" + harborLocation + "]";
	}
	
	public static VehicleEntity converttoEntity(VehicleDTO dto) {
		VehicleEntity ent = new VehicleEntity();
		ent.setCountry(dto.getCountry());
		ent.setHarborLocation(dto.getHarborLocation());
		ent.setMaxLiftingCapacity(dto.getMaxLiftingCapacity());
		ent.setRetireDate(dto.getRetireDate());
		ent.setVehicleName(dto.getVehicleName());
		ent.setVehicleNumber(dto.getVehicleNumber());
		ent.setVehicleStatus(dto.getVehicleStatus());
		
		return ent;
		
		
	}

}
