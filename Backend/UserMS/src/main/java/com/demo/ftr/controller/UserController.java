package com.demo.ftr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.ftr.dto.LoginDTO;
import com.demo.ftr.dto.UserLoginDTO;
import com.demo.ftr.dto.UserProfileDTO;
import com.demo.ftr.exception.UserNotFoundException;
import com.demo.ftr.service.UserService;

@RestController
@RequestMapping(value = "/ftr/userProfile")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping
	public ResponseEntity<UserProfileDTO> createUser(@RequestBody UserProfileDTO dto){
		
		UserProfileDTO userProfileDTO = userService.createUser(dto);
		return new ResponseEntity<>(userProfileDTO,HttpStatus.OK);
	}
	
	@GetMapping(value = "/{userId}")
	public ResponseEntity<UserProfileDTO> getUser(@PathVariable Integer userId) throws UserNotFoundException{
	
		UserProfileDTO userProfileDTO = userService.getUser(userId);
		
		return new ResponseEntity<>(userProfileDTO,HttpStatus.OK);
	}
	
	@PutMapping(value = "/{userId}")
	public ResponseEntity<String> updateUser(@PathVariable Integer userId, @RequestBody UserProfileDTO userDto)throws UserNotFoundException{
		
		String message=userService.updateUser(userId, userDto);
		
		return new ResponseEntity<>(message,HttpStatus.OK);
	}
	
	//This method is used to delete the user information if there is no pending workitem
	@DeleteMapping(value = "/{userId}")
	public ResponseEntity<String> deleteUser(@PathVariable Integer userId) throws UserNotFoundException{
		
		String message=userService.deleteUser(userId);
		
		return new ResponseEntity<>(message,HttpStatus.OK);
	}
	
	@PostMapping(value = "/login")
	public ResponseEntity<UserLoginDTO> login(@RequestBody LoginDTO logindto) throws UserNotFoundException{
		
		UserLoginDTO message=userService.login(logindto);
		
		return new ResponseEntity<>(message,HttpStatus.OK);
	}
}
