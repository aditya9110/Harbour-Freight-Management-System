package com.demo.ftr.Entity;

import java.time.LocalDate;
///import java.persistence.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.demo.ftr.DTO.VehicleDTO;

//import org.springframework.lang.NonNull;

@Entity
@Table(name="ftr_vehicles")
public class VehicleEntity {
	
	@Id
	@Column(columnDefinition="varChar(20)")
	private String vehicleNumber;
	@Column
	private String vehicleName;
	@Column
	private double maxLiftingCapacity;
	@Column
	private LocalDate retireDate;
	@Column
	private String vehicleStatus;
	@Column
	private String country;
	@Column
	private String harborLocation;
	
	
	public String getVehicleNumber() {
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
	public VehicleEntity(String vehicleNumber, String vehicleName, double maxLiftingCapacity, LocalDate retireDate,
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
	@Override
	public String toString() {
		return "VehicleEntity [vehicleNumber=" + vehicleNumber + ", vehicleName=" + vehicleName
				+ ", maxLiftingCapacity=" + maxLiftingCapacity + ", retireDate=" + retireDate + ", vehicleStatus="
				+ vehicleStatus + ", country=" + country + ", harborLocation=" + harborLocation + "]";
	}
	public VehicleEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public static  VehicleDTO converttodto(VehicleEntity vehEnt) {
		VehicleDTO Vehdto = new VehicleDTO();
		Vehdto.setCountry(vehEnt.getCountry());
		Vehdto.setHarborLocation(vehEnt.getHarborLocation());
		Vehdto.setMaxLiftingCapacity(vehEnt.getMaxLiftingCapacity());
		Vehdto.setRetireDate(vehEnt.getRetireDate());
		Vehdto.setVehicleName(vehEnt.getVehicleName());
		Vehdto.setVehicleNumber(vehEnt.getVehicleNumber());
		Vehdto.setVehicleStatus(vehEnt.getVehicleStatus());
		return Vehdto;
	}
	
	
	

}
