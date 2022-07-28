package com.terminalMS.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.terminalMS.DTO.FtrTerminalsDTO;

@Entity
@Table(name = "ftr_terminals")
public class FtrTerminalsEntity {
	@Id
	@Column(columnDefinition = "varchar(20)")
	private String terminalId;
	@Column(nullable = false)
	private String terminalName;
	@Column(nullable = false)
	private String country;
	@Column(nullable = false)
	private String itemType;
	@Column(nullable = false)
	private String terminalDescription;
	@Column(nullable = false)
	private long capacity;
	@Column(nullable = false)
	private long availableCapacity;
	@Column(nullable = false)
	private String status;
	@Column(nullable = false)
	private String harborLocation;

	public String getTerminalId() {
		return terminalId;
	}

	public void setTerminalId(String terminalId) {
		this.terminalId = terminalId;
	}

	public String getTerminalName() {
		return terminalName;
	}

	public void setTerminalName(String terminalName) {
		this.terminalName = terminalName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public String getTerminalDescription() {
		return terminalDescription;
	}

	public void setTerminalDescription(String terminalDescription) {
		this.terminalDescription = terminalDescription;
	}

	public long getCapacity() {
		return capacity;
	}

	public void setCapacity(long capacity) {
		this.capacity = capacity;
	}

	public long getAvailableCapacity() {
		return availableCapacity;
	}

	public void setAvailableCapacity(long availableCapacity) {
		this.availableCapacity = availableCapacity;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getHarborLocation() {
		return harborLocation;
	}

	public void setHarborLocation(String harborLocation) {
		this.harborLocation = harborLocation;
	}

	public FtrTerminalsEntity() {
	}

	public FtrTerminalsEntity(String terminalId, String terminalName, String country, String itemType,
			String terminalDescription, long capacity, long availableCapacity, String status, String harborLocation) {
		super();
		this.terminalId = terminalId;
		this.terminalName = terminalName;
		this.country = country;
		this.itemType = itemType;
		this.terminalDescription = terminalDescription;
		this.capacity = capacity;
		this.availableCapacity = availableCapacity;
		this.status = status;
		this.harborLocation = harborLocation;
	}

	public FtrTerminalsDTO convertToDto(FtrTerminalsEntity ften) {
		FtrTerminalsDTO ftdto = new FtrTerminalsDTO();
		ftdto.setTerminalId(ften.getTerminalId());
		ftdto.setTerminalName(ften.getTerminalName());
		ftdto.setCountry(ften.getCountry());
		ftdto.setItemType(ften.getItemType());
		ftdto.setTerminalDescription(ften.getTerminalDescription());
		ftdto.setCapacity(ften.getCapacity());
		ftdto.setAvailableCapacity(ften.getAvailableCapacity());
		ftdto.setStatus(ften.getStatus());
		ftdto.setHarborLocation(ften.getHarborLocation());
		return ftdto;
	}

}
