package com.demo.ftr.controller;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import com.demo.ftr.dto.TerminalsDTO;

@FeignClient(name = "TerminalMS")

public interface TerminalFeign {
	
	@GetMapping(value = "/ftr/terminals/fetchTerminalByItemType/{itemType}")
	List<TerminalsDTO> fetchTerminalByItemType(@PathVariable String itemType);
	
	@PutMapping(value = "/ftr/terminals/{terminalId}/{newCapacity}")
	String updateCapacity(@PathVariable String terminalId,@PathVariable Integer newCapacity);
	
	@GetMapping(value = "/ftr/terminals/fetchTerminalByTerminalId/{terminalId}")
	TerminalsDTO fetchTerminalByTerminalId(@PathVariable String terminalId);
}
