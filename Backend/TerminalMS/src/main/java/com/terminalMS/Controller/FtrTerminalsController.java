package com.terminalMS.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.terminalMS.DTO.FtrTerminalsDTO;
import com.terminalMS.Exception.TerminalNotFound;
import com.terminalMS.Service.FtrTerminalsService;

@RestController
@RequestMapping("/ftr/terminals")
public class FtrTerminalsController {

	@Autowired
	private FtrTerminalsService terminalService;

	@GetMapping("/insert")
	public void insert() {

		terminalService.insert();

	}

	@PostMapping()
	public ResponseEntity<FtrTerminalsDTO> insertNewTerminal(@RequestBody FtrTerminalsDTO tdto) throws Exception {
		FtrTerminalsDTO tdto1 = terminalService.insertNewTerminal(tdto);
		return new ResponseEntity<>(tdto1, HttpStatus.OK);
	}

	@GetMapping("/list")
	public ResponseEntity<List<FtrTerminalsDTO>> fetchFTRTerminals() throws TerminalNotFound {
		List<FtrTerminalsDTO> tdto = terminalService.fetchFTRTerminals();
		return new ResponseEntity<>(tdto, HttpStatus.ACCEPTED);
	}

	@GetMapping(value = "/fetchTerminalByItemType/{itemType}")
	public ResponseEntity<List<FtrTerminalsDTO>> fetchTerminalByItemType(@PathVariable String itemType)
			throws TerminalNotFound {
		List<FtrTerminalsDTO> trDto = terminalService.fetchFTRTerminalByItemType(itemType);
		System.out.println(trDto);
		return new ResponseEntity<List<FtrTerminalsDTO>>(trDto, HttpStatus.ACCEPTED);
	}

	@GetMapping("/fetchTerminalByTerminalId/{terminalId}")
	public ResponseEntity<FtrTerminalsDTO> fetchTerminalByTerminalId(@PathVariable String terminalId)
			throws TerminalNotFound {
		FtrTerminalsDTO ftrdto = terminalService.fetchterminalByTerminalId(terminalId);
		return new ResponseEntity<FtrTerminalsDTO>(ftrdto, HttpStatus.ACCEPTED);
	}

	@PutMapping(value = "/{terminalId}/{newCapacity}")
	public ResponseEntity<String> updateTerminal(@PathVariable("terminalId") String terminalId,
			@PathVariable("newCapacity") Integer newCapacity) {
		String message = terminalService.updateTerminal(terminalId, newCapacity);
		return new ResponseEntity<String>(message, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/{terminalId}")
	public ResponseEntity<String> removeTerminal(@PathVariable String terminalId) {
		String message = terminalService.deleteById(terminalId);
		return new ResponseEntity<String>(message, HttpStatus.ACCEPTED);
	}

}
