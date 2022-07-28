package com.demo.ftr.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ftr_workitems")
public class Workitem {

	@Id
	@Column(columnDefinition = "varchar(20)")
	private String workitemId;

	private Long userId;
	private String itemName;
	private String itemType;
	private String itemDescription;
	private String messageToRecipient;
	private String quantity;

	private String sourceCountry;
	private String destinationCountry;
	private String originHarborLocation;
	private String selectedHarborLocation;

	private Date shippingDate;
	private Integer amount;

	@OneToOne(mappedBy = "workitemId")
	private VehicleWorkitem vehicleWorkitem;

	public String getWorkitemId() {
		return workitemId;
	}

	public void setWorkitemId(String workitemId) {
		this.workitemId = workitemId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public String getMessageToRecipient() {
		return messageToRecipient;
	}

	public void setMessageToRecipient(String messageToRecipient) {
		this.messageToRecipient = messageToRecipient;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getSourceCountry() {
		return sourceCountry;
	}

	public void setSourceCountry(String sourceCountry) {
		this.sourceCountry = sourceCountry;
	}

	public String getDestinationCountry() {
		return destinationCountry;
	}

	public void setDestinationCountry(String destinationCountry) {
		this.destinationCountry = destinationCountry;
	}

	public String getOriginHarborLocation() {
		return originHarborLocation;
	}

	public void setOriginHarborLocation(String originHarborLocation) {
		this.originHarborLocation = originHarborLocation;
	}

	public String getSelectedHarborLocation() {
		return selectedHarborLocation;
	}

	public void setSelectedHarborLocation(String selectedHarborLocation) {
		this.selectedHarborLocation = selectedHarborLocation;
	}

	public Date getShippingDate() {
		return shippingDate;
	}

	public void setShippingDate(Date shippingDate) {
		this.shippingDate = shippingDate;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public VehicleWorkitem getVehicleWorkitem() {
		return vehicleWorkitem;
	}

	public void setVehicleWorkitem(VehicleWorkitem vehicleWorkitem) {
		this.vehicleWorkitem = vehicleWorkitem;
	}

}
