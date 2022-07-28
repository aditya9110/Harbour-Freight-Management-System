package com.demo.ftr.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ftr_harbor")
public class Harbor {
	@Id
	@Column(columnDefinition = "varchar(20)")
	private String country;
	private String availableHarborLocations;

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getAvailableHarborLocations() {
		return availableHarborLocations;
	}

	public void setAvailableHarborLocations(String availableHarborLocations) {
		this.availableHarborLocations = availableHarborLocations;
	}

}
