package com.demo.ftr.dto;

public class WorkitemDriverVehicleDTO {

	private String vehicleNumber;
	
	private String driverId;
	
	private String assignedWorkitemStatus;
	
	private WorkitemDTO workitemDTO;

	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}


	public String getDriverId() {
		return driverId;
	}

	public void setDriverId(String driverId) {
		this.driverId = driverId;
	}

	public String getAssignedWorkitemStatus() {
		return assignedWorkitemStatus;
	}

	public void setAssignedWorkitemStatus(String assignedWorkitemStatus) {
		this.assignedWorkitemStatus = assignedWorkitemStatus;
	}

	public WorkitemDTO getWorkitemDTO() {
		return workitemDTO;
	}

	public void setWorkitemDTO(WorkitemDTO workitemDTO) {
		this.workitemDTO = workitemDTO;
	}
	
	
}
