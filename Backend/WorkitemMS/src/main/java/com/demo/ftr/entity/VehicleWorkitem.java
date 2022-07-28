package com.demo.ftr.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ftr_vehicle_workitem")
public class VehicleWorkitem {

	@Id
	@Column(columnDefinition = "varchar(20)")
	private String vehicleNumber;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "workitemId")
	private Workitem workitemId;

	private String driverId;
	private String assignedWorkitemStatus;

	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	public Workitem getWorkitemId() {
		return workitemId;
	}

	public void setWorkitemId(Workitem workitemId) {
		this.workitemId = workitemId;
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

}
