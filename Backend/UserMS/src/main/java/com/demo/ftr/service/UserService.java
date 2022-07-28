package com.demo.ftr.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.ftr.dto.LoginDTO;
import com.demo.ftr.dto.UserLoginDTO;
import com.demo.ftr.dto.UserProfileDTO;
import com.demo.ftr.entity.User;
import com.demo.ftr.exception.UserNotFoundException;
import com.demo.ftr.repositry.UserRepositry;

@Service
@Transactional
public class UserService {
	
	@Autowired
	private UserRepositry userRepositry;
	
	private User user = new User();
	
	private UserProfileDTO userProfileToDTO(User userProfile) {

		UserProfileDTO dto = new UserProfileDTO();
		dto.setUserId(userProfile.getUserId());
		dto.setFirstName(userProfile.getFirstName());
		dto.setLastName(userProfile.getLastName());
		dto.setEmailId(userProfile.getEmailId());
		dto.setMobileNumber(userProfile.getMobileNumber());
		dto.setPassword(userProfile.getPassword());
		dto.setNationality(userProfile.getNationality());
		dto.setPassportNumber(userProfile.getPassportNumber());
		dto.setPermanentAddress(userProfile.getPermanentAddress());
		dto.setOfficeAddress(userProfile.getOfficeAddress());
		dto.setPersonalIdentificationNumber(userProfile.getPersonalIdentificationNumber());

	return dto;
	}
	
	private User userProfileDTOToentity(UserProfileDTO userProfileDTO) {

		user.setFirstName(userProfileDTO.getFirstName());
		user.setLastName(userProfileDTO.getLastName());
		user.setEmailId(userProfileDTO.getEmailId());
		user.setMobileNumber(userProfileDTO.getMobileNumber());
		user.setPassword(userProfileDTO.getPassword());
		user.setNationality(userProfileDTO.getNationality());
		user.setPassportNumber(userProfileDTO.getPassportNumber());
		user.setPermanentAddress(userProfileDTO.getPermanentAddress());
		user.setOfficeAddress(userProfileDTO.getOfficeAddress());
		user.setPersonalIdentificationNumber(userProfileDTO.getPersonalIdentificationNumber());
		user.setUserType(false);

	return user;
	}
	
	public UserProfileDTO createUser(UserProfileDTO dto){
		user=userProfileDTOToentity(dto);
		userRepositry.save(user);
		dto.setUserId(user.getUserId());
		return dto;
	}
	
	public UserProfileDTO getUser(Integer userId) throws UserNotFoundException{
	
	Optional<User> optional = userRepositry.findById(userId);
	User user = optional.orElseThrow(() -> new UserNotFoundException("User details not found"));
	return userProfileToDTO(user);
	}
	
	public String updateUser(Integer userId,UserProfileDTO userDto)throws UserNotFoundException{
		Optional<User> optional = userRepositry.findById(userId);
		User user = optional.orElseThrow(() -> new UserNotFoundException("User details not found"));
		
		user.setMobileNumber(userDto.getMobileNumber());
		user.setPermanentAddress(userDto.getPermanentAddress());
		user.setOfficeAddress(userDto.getOfficeAddress());
		
		return "Mobilenumber, permanentAddress and OfficeAddress details are updated successfully for UserId:"+userId+".";
	}
	
	public String deleteUser(Integer userId)throws UserNotFoundException {
		userRepositry.findById(userId).orElseThrow(() -> new UserNotFoundException("User details not found"));
		userRepositry.deleteById(userId);
		
		return "User "+userId+" details are removed successfully";
	}
	
	public UserLoginDTO login(LoginDTO logindto)throws UserNotFoundException {
		Optional<User> optional = userRepositry.findByEmailId(logindto.getEmail());
		
		if (optional.isPresent() && optional.get().getEmailId().equals(logindto.getEmail()) && optional.get().getPassword().equals(logindto.getPassword())) {
			UserLoginDTO uDto = new UserLoginDTO();
			uDto.setUserId(optional.get().getUserId());
			uDto.setUserType(optional.get().isUserType());
			return uDto;
		}
		
		else 
			throw new UserNotFoundException("Invalid Credentials!");
		
	}

}
