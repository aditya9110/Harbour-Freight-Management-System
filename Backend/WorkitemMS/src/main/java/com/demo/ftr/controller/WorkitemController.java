package com.demo.ftr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.ftr.dto.TerminalsDTO;
import com.demo.ftr.dto.VehicleDTO;
import com.demo.ftr.dto.VehicleWorkitemDTO;
import com.demo.ftr.dto.WorkitemDTO;
import com.demo.ftr.dto.WorkitemDriverVehicleDTO;
import com.demo.ftr.exception.InvalidDetailsException;
import com.demo.ftr.service.TerminalCircuitBreakerService;
import com.demo.ftr.service.VehicleCircuitBreakerService;
import com.demo.ftr.service.WorkitemService;

@RestController
@RequestMapping(value = "/ftr/workItems")
public class WorkitemController {

	@Autowired
	WorkitemService workitemService;
	
	@Autowired
	TerminalCircuitBreakerService tService;
	
	@Autowired
	VehicleCircuitBreakerService vService;
	
	@PostMapping
	public ResponseEntity<WorkitemDTO> createWorkItem(@RequestBody WorkitemDTO newWorkitem){
		
		WorkitemDTO workitemDTO = workitemService.createWorkitem(newWorkitem);
		return new ResponseEntity<>(workitemDTO, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{fromCountry}")
	public ResponseEntity<String[]> fetchAvailableHarborLocations(@PathVariable String fromCountry)
			throws InvalidDetailsException{
		
		String[] availableHarbor = workitemService.fetchAvailableHarborLocations(fromCountry);
		return new ResponseEntity<>(availableHarbor, HttpStatus.OK);
	}
	
	@PutMapping(value = "/{workitemId}")
	public ResponseEntity<String> updateWorkItem(@PathVariable String workitemId,@RequestBody WorkitemDTO workitemDTO)
			throws InvalidDetailsException{
		
		String message= workitemService.updateWorkitemId(workitemId, workitemDTO);
		
		return new ResponseEntity<>(message, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<WorkitemDTO>> fetchWorkItemDetails(){
		
		List<WorkitemDTO> workitemList = workitemService.fetchWorkItemDetails();
		return new ResponseEntity<>(workitemList, HttpStatus.OK);
	}
	
	@GetMapping(value = "/managed-user/{userId}")
	public ResponseEntity<List<VehicleWorkitemDTO>> trackWorkItemByUser(@PathVariable Long userId)
			throws InvalidDetailsException{
		
		List<String> workItemId=workitemService.getWorkIdByUid(userId);
		List<VehicleWorkitemDTO> vehicleWorkitemDTOList=workitemService.trackWorkItem(workItemId);
		
		return new ResponseEntity<>(vehicleWorkitemDTOList, HttpStatus.OK);
	}
	
	//need vehicle MS
	@PostMapping(value = "/managed-vehicle/{workItemId}")
	public ResponseEntity<String> allocateVehicle(@PathVariable String workItemId)throws InvalidDetailsException {
		String tId=	workitemService.getTerminalId(workItemId);
		TerminalsDTO terminalDTO = tService.fetchTerminalByTerminalId(tId);
		
		List<VehicleDTO> vDto=vService.fetchAvailableVehicles();
		
		String vId = workitemService.allocateVehicle(vDto,terminalDTO,workItemId);
		VehicleDTO dto =new VehicleDTO();
		dto.setVehicleStatus("InProgress");
		vService.updateVehicleStatus(vId, dto);
		return new ResponseEntity<>("Workitem is allocated with Vehicle successfully.", HttpStatus.OK);
	}
	
	@GetMapping(value = "/managed-status/{workItemId}")
	public ResponseEntity<WorkitemDriverVehicleDTO> fetchWorkItemStatus(@PathVariable String workItemId)  
			throws InvalidDetailsException{
		WorkitemDriverVehicleDTO workitemDriverVehicleDTO = workitemService.fetchWorkItemStatus(workItemId);
		return new ResponseEntity<>(workitemDriverVehicleDTO, HttpStatus.OK);
	}
	
	//need terminalms and vehicle Ms
	@PutMapping(value = "/managed-update/{workItemId}")
	public ResponseEntity<String> updateWorkItemStatus(@PathVariable String workItemId)
			throws InvalidDetailsException{
		String message;
		if(workitemService.updateWorkItemStatus(workItemId)) {
			
			String vId = workitemService.getVehicleId(workItemId);
			VehicleDTO dto =new VehicleDTO();
			dto.setVehicleStatus("Active");
			vService.updateVehicleStatus(vId, dto);
			
			String tId = workitemService.getTerminalId(workItemId);
			int qty=Integer.valueOf(workitemService.getWorkItemById(workItemId).getQuantity().split(" ")[0]);
			Integer newCapacity = (int) (tService.fetchTerminalByTerminalId(tId).getAvailableCapacity()+qty);
			tService.updateCapacity(tId,newCapacity);
			
			message="Work item status has updated successfully.";
		}
		else {
			message="Work item status has not been updated.";
		}
		return new ResponseEntity<>(message, HttpStatus.OK);
	}
	
	@GetMapping(value = "/managed-vehicle/{vehicleNumber}")
	public ResponseEntity<VehicleWorkitemDTO> fetchWorkItemDetailsByVehicleNumber(@PathVariable String vehicleNumber)
			throws InvalidDetailsException{
		VehicleWorkitemDTO vehicleWorkitemDTO = workitemService.fetchWorkItemDetailsByVehicleNumber(vehicleNumber);
		return new ResponseEntity<>(vehicleWorkitemDTO, HttpStatus.OK);
	}
	
	@PostMapping(value = "/managed-terminal/{workItemId}")
	public ResponseEntity<String> assignTerminalforWorKitem(@PathVariable String workItemId)throws InvalidDetailsException {
		
		String workitemType = workitemService.getWorkItemById(workItemId).getItemType();
		int qty=Integer.valueOf(workitemService.getWorkItemById(workItemId).getQuantity().split(" ")[0]);
		
		List<TerminalsDTO> terminalsDTO = tService.fetchTerminalByItemType(workitemType);
		
		String tid = workitemService.assignTerminalForWorkitem(workItemId,terminalsDTO, qty);
		
		tService.updateCapacity(tid.split(",")[0],Integer.valueOf(tid.split(",")[1]));
		
		return new ResponseEntity<>("Workitem is allocated with Terminal Successfully", HttpStatus.OK);
	}
}
