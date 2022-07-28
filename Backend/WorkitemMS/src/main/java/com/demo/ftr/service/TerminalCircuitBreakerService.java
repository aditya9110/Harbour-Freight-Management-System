package com.demo.ftr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.demo.ftr.controller.TerminalFeign;
import com.demo.ftr.dto.TerminalsDTO;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class TerminalCircuitBreakerService {

	@Autowired
	TerminalFeign terminalFeign;

	@CircuitBreaker(name = "terminalService")
	public List<TerminalsDTO> fetchTerminalByItemType(String itemType) {
		return terminalFeign.fetchTerminalByItemType(itemType);
	}
	
	@CircuitBreaker(name = "terminalService")
	public String updateCapacity(String terminalId,Integer newCapacity) {
		
		return terminalFeign.updateCapacity(terminalId, newCapacity);
	};
	
	@CircuitBreaker(name = "terminalService")
	public TerminalsDTO fetchTerminalByTerminalId(@PathVariable String terminalId) {
		
		return terminalFeign.fetchTerminalByTerminalId(terminalId);
	}
}
