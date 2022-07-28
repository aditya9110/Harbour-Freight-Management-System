package com.terminalMS.DTO;

import com.terminalMS.Entity.FtrTerminalsEntity;

public class FtrTerminalsDTO {

	private String terminalId;
	private String terminalName;
	private String country;
	private String itemType;
	private String terminalDescription;
	private long capacity;
	private long availableCapacity;
	private String status;
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

	public void setAvailableCapacity(Integer availableCapacity) {
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

	public FtrTerminalsDTO(String terminalId, String terminalName, String country, String itemType,
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

	public FtrTerminalsDTO() {
		super();

	}

	public static FtrTerminalsEntity convertToEntity(FtrTerminalsDTO ftrdto) {
		FtrTerminalsEntity ftren = new FtrTerminalsEntity();
		ftren.setTerminalId(ftrdto.getTerminalId());
		ftren.setTerminalName(ftrdto.getTerminalName());
		ftren.setCountry(ftrdto.getCountry());
		ftren.setItemType(ftrdto.getItemType());
		ftren.setTerminalDescription(ftrdto.getTerminalDescription());
		ftren.setCapacity(ftrdto.getCapacity());
		ftren.setAvailableCapacity(ftrdto.getAvailableCapacity());
		ftren.setStatus(ftrdto.getStatus());
		ftren.setHarborLocation(ftrdto.getHarborLocation());
		return ftren;
	}

	@Override
	public String toString() {
		return "FtrTerminalsDTO [terminalId=" + terminalId + ", terminalName=" + terminalName + ", country=" + country
				+ ", itemType=" + itemType + ", terminalDescription=" + terminalDescription + ", capacity=" + capacity
				+ ", availableCapacity=" + availableCapacity + ", status=" + status + ", harborLocation="
				+ harborLocation + "]";
	}

}
