package com.demo.ftr.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.ftr.dto.TerminalsDTO;
import com.demo.ftr.dto.VehicleDTO;
import com.demo.ftr.dto.VehicleWorkitemDTO;
import com.demo.ftr.dto.WorkitemDTO;
import com.demo.ftr.dto.WorkitemDriverVehicleDTO;
import com.demo.ftr.entity.VehicleWorkitem;
import com.demo.ftr.entity.Workitem;
import com.demo.ftr.entity.WorkitemTerminal;
import com.demo.ftr.exception.InvalidDetailsException;
import com.demo.ftr.repositry.HarborRepositry;
import com.demo.ftr.repositry.VehicleWorkitemRepositry;
import com.demo.ftr.repositry.WorkitemRepositry;
import com.demo.ftr.repositry.WorkitemTerminalRepositry;

@Service
@Transactional
public class WorkitemService {
	
	@Autowired
	private WorkitemRepositry workitemRepositry;
	@Autowired
	private HarborRepositry harborRepositry;
	@Autowired
	private VehicleWorkitemRepositry vehicleWorkitemRepositry;
	@Autowired
	private WorkitemTerminalRepositry wTerminalRepositry;
	
	private Workitem workitem = new Workitem();
	
	
	private String genWorkitemId() {
		String lastId = workitemRepositry.getLastRecord();
		return "J"+(Integer.valueOf(lastId.substring(1))+1);

	}
	
	private Integer calculateAmount(String type,String quntity) {
		final Map<String, Integer> basePriceMap = new HashMap<String, Integer>();
		
		int qty=Integer.valueOf(quntity.split(" ")[0]);
		basePriceMap.put("Computer Hardware", 15999);
		basePriceMap.put("Oil Container", (int) 22.54);
		basePriceMap.put("Wood", 130000);
		basePriceMap.put("Motorcycles", 6336);
		basePriceMap.put("Electonics", 13490);
		
		return basePriceMap.get(type)*qty;
	}
	
	private List<WorkitemDTO> workitemListtoworkitemDTO(List<Workitem> workitemList) {

		List<WorkitemDTO> list = new ArrayList<WorkitemDTO>();
		for (Workitem i : workitemList) {
			WorkitemDTO dto = new WorkitemDTO();
			
			dto.setWorkitemId(i.getWorkitemId());
			dto.setUserId(i.getUserId());
			dto.setItemName(i.getItemName());
			dto.setItemType(i.getItemType());
			dto.setItemDescription(i.getItemDescription());
			dto.setMessageToRecipient(i.getMessageToRecipient());
			dto.setQuantity(i.getQuantity());
			dto.setSourceCountry(i.getSourceCountry());
			dto.setDestinationCountry(i.getDestinationCountry());
			dto.setOriginHarborLocation(i.getOriginHarborLocation());
			dto.setSelectedHarborLocation(i.getSelectedHarborLocation());
			dto.setShippingDate(i.getShippingDate());
			dto.setAmount(i.getAmount());
			list.add(dto);

		}

		return list;
	}
	
	private VehicleWorkitemDTO vehicleWorkitemtoDTO(VehicleWorkitem vehicleWorkitem) {

			VehicleWorkitemDTO dto = new VehicleWorkitemDTO();
			
			dto.setVehicleNumber(vehicleWorkitem.getVehicleNumber());
			dto.setWorkitemId(vehicleWorkitem.getWorkitemId().getWorkitemId());
			dto.setAssignedWorkitemStatus(vehicleWorkitem.getAssignedWorkitemStatus());

		return dto;
	}
	
	public WorkitemDTO createWorkitem(WorkitemDTO workitemDto){
		
		workitem.setWorkitemId(genWorkitemId());
		workitem.setUserId(workitemDto.getUserId());
		workitem.setItemName(workitemDto.getItemName());
		workitem.setItemType(workitemDto.getItemType());
		workitem.setItemDescription(workitemDto.getItemDescription());
		workitem.setMessageToRecipient(workitemDto.getMessageToRecipient());
		workitem.setQuantity(workitemDto.getQuantity());
		workitem.setSourceCountry(workitemDto.getSourceCountry());
		workitem.setDestinationCountry(workitemDto.getDestinationCountry());
		workitem.setOriginHarborLocation(workitemDto.getOriginHarborLocation());
		workitem.setSelectedHarborLocation(workitemDto.getSelectedHarborLocation());
		workitem.setShippingDate(workitemDto.getShippingDate());
		workitem.setAmount(calculateAmount(workitemDto.getItemType(),workitemDto.getQuantity()));
		workitemRepositry.save(workitem);
		
		workitemDto.setWorkitemId(workitem.getWorkitemId());
		workitemDto.setAmount(calculateAmount(workitemDto.getItemType(),workitemDto.getQuantity()));
		
		return workitemDto;
	}
	
	public String[] fetchAvailableHarborLocations(String fromCountry) throws InvalidDetailsException {
		Optional<String> optional = harborRepositry.findByCountry(fromCountry);
		String availableHarbor = optional.orElseThrow(() -> new InvalidDetailsException("Invalid Data"));
		return availableHarbor.split(", ");
	}
	
	public String updateWorkitemId(String workitemId, WorkitemDTO workitemDTO) throws InvalidDetailsException {
		Optional<Workitem> optional=workitemRepositry.findById(workitemId);
		Workitem workitem = optional.orElseThrow(() -> new InvalidDetailsException("Invalid Data"));
		workitem.setSelectedHarborLocation(workitemDTO.getSelectedHarborLocation());
		workitem.setShippingDate(workitemDTO.getShippingDate());
		return "Harbor location and shipping date got updated successfully.";
	}
	
	public List<WorkitemDTO> fetchWorkItemDetails(){
		return workitemListtoworkitemDTO(workitemRepositry.findAll());
	}
	
	public List<String> getWorkIdByUid(Long userId) throws InvalidDetailsException{
		Optional< List<String>> optional = workitemRepositry.getWorkitemIdByUserId(userId);
		List<String> workItemId=optional.orElseThrow(() -> new InvalidDetailsException("User Id Not Found"));
		return workItemId;
	}
	
	public List<VehicleWorkitemDTO> trackWorkItem(List<String> workItemId) throws InvalidDetailsException{
		List<VehicleWorkitemDTO> list = new ArrayList<VehicleWorkitemDTO>();
		
		for (String i : workItemId) {
			Optional<VehicleWorkitem> optional = vehicleWorkitemRepositry.findByWorkitemId(i);
			VehicleWorkitem vehicleWorkitem = optional.orElseThrow(() -> new InvalidDetailsException("Work Item Not Found"));
			
			list.add(vehicleWorkitemtoDTO(vehicleWorkitem));
		}
		return list;
	}
	
	public WorkitemDriverVehicleDTO fetchWorkItemStatus(String workItemId)  throws InvalidDetailsException{
		Optional<VehicleWorkitem> optional = vehicleWorkitemRepositry.findByWorkitemId(workItemId);
		VehicleWorkitem vehicleWorkitem = optional.orElseThrow(() -> new InvalidDetailsException("Work Item Not Found"));
		workitem = vehicleWorkitem.getWorkitemId();
		
		WorkitemDTO wDto= new WorkitemDTO();
		
		wDto.setWorkitemId(workitem.getWorkitemId());
		wDto.setUserId(workitem.getUserId());
		wDto.setItemName(workitem.getItemName());
		wDto.setItemType(workitem.getItemType());
		wDto.setItemDescription(workitem.getItemDescription());
		wDto.setMessageToRecipient(workitem.getMessageToRecipient());
		wDto.setQuantity(workitem.getQuantity());
		wDto.setSourceCountry(workitem.getSourceCountry());
		wDto.setDestinationCountry(workitem.getDestinationCountry());
		wDto.setOriginHarborLocation(workitem.getOriginHarborLocation());
		wDto.setSelectedHarborLocation(workitem.getSelectedHarborLocation());
		wDto.setShippingDate(workitem.getShippingDate());
		wDto.setAmount(workitem.getAmount());
		
		WorkitemDriverVehicleDTO dto = new WorkitemDriverVehicleDTO();
		
		dto.setAssignedWorkitemStatus(vehicleWorkitem.getAssignedWorkitemStatus());
		dto.setVehicleNumber(vehicleWorkitem.getVehicleNumber());
		dto.setDriverId(vehicleWorkitem.getDriverId());
		dto.setWorkitemDTO(wDto);
		
		return dto;
		
	}
	public boolean updateWorkItemStatus(String workitemId) throws InvalidDetailsException{
		Optional<Workitem> optional = workitemRepositry.findById(workitemId);
		Workitem workitem = optional.orElseThrow(() -> new InvalidDetailsException("Invalid Data"));
		
		Date todayDate = new Date();
		
		if(workitem.getShippingDate().compareTo(todayDate)<=0) {
			workitem.getVehicleWorkitem().setAssignedWorkitemStatus("Completed");
			return true;
		}
		return false;
		
	}
	
	public VehicleWorkitemDTO fetchWorkItemDetailsByVehicleNumber(String vehicleNumber)throws InvalidDetailsException{
		Optional<VehicleWorkitem> optional = vehicleWorkitemRepositry.findById(vehicleNumber);
		VehicleWorkitem vehicleWorkitem = optional.orElseThrow(() -> new InvalidDetailsException("Work Item Not Found"));
		
		return vehicleWorkitemtoDTO(vehicleWorkitem);
	}
	
	public WorkitemDTO getWorkItemById(String workItemId)throws InvalidDetailsException {
		Optional<Workitem> optional = workitemRepositry.findById(workItemId);
		Workitem workitem = optional.orElseThrow(() -> new InvalidDetailsException("Invalid Data"));
		
		WorkitemDTO dto = new WorkitemDTO();
		
		dto.setWorkitemId(workitem.getWorkitemId());
		dto.setUserId(workitem.getUserId());
		dto.setItemName(workitem.getItemName());
		dto.setItemType(workitem.getItemType());
		dto.setItemDescription(workitem.getItemDescription());
		dto.setMessageToRecipient(workitem.getMessageToRecipient());
		dto.setQuantity(workitem.getQuantity());
		dto.setSourceCountry(workitem.getSourceCountry());
		dto.setDestinationCountry(workitem.getDestinationCountry());
		dto.setOriginHarborLocation(workitem.getOriginHarborLocation());
		dto.setSelectedHarborLocation(workitem.getSelectedHarborLocation());
		dto.setShippingDate(workitem.getShippingDate());
		dto.setAmount(workitem.getAmount());
		
		return dto;
	}
	
	public String assignTerminalForWorkitem(String workItemId,List<TerminalsDTO> terminalsDTO,int qty) {
		WorkitemTerminal workitemTerminal = new WorkitemTerminal();
		
		for(TerminalsDTO i : terminalsDTO) {
			if(i.getAvailableCapacity()> qty) {
				workitemTerminal.setTerminalId(i.getTerminalId());
				workitemTerminal.setWorkitemId(workItemId);
				wTerminalRepositry.save(workitemTerminal);
				return i.getTerminalId()+","+(i.getAvailableCapacity()-qty);
			}
		}
		
		return "";
	}
	
	public String getTerminalId(String workItemId)throws InvalidDetailsException {
		Optional<WorkitemTerminal> optional = wTerminalRepositry.findById(workItemId);
		WorkitemTerminal woTerminal = optional.orElseThrow(() -> new InvalidDetailsException("Invalid Data"));
		return woTerminal.getTerminalId();
	}
	
	public String getVehicleId(String workItemId)throws InvalidDetailsException {
		Optional<Workitem> optional = workitemRepositry.findById(workItemId);
		Workitem workitem = optional.orElseThrow(() -> new InvalidDetailsException("Invalid Data"));
		return workitem.getVehicleWorkitem().getVehicleNumber();
	}
	
	public String allocateVehicle(List<VehicleDTO> vDto,TerminalsDTO harborLocation,String workItemId)throws InvalidDetailsException {
		
		VehicleWorkitem vehicleWorkitem = new VehicleWorkitem();
		
		for(VehicleDTO i:vDto) {
			if(i.getHarborLocation().equals(harborLocation.getHarborLocation()) && i.getVehicleStatus().equals("Active")) {
				Workitem workitem = workitemRepositry.findById(workItemId).get();
				vehicleWorkitem.setWorkitemId(workitem);
				vehicleWorkitem.setDriverId("D112");
				vehicleWorkitem.setVehicleNumber(i.getVehicleNumber());
				vehicleWorkitem.setAssignedWorkitemStatus("InProgress");
				
				vehicleWorkitemRepositry.save(vehicleWorkitem);
				return i.getVehicleNumber();
			}
		}
		throw new InvalidDetailsException("Vehicle not available.");
	}
}
