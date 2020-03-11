package com.nileshrane.systemapi.controller;

import java.util.Date;

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
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nileshrane.systemapi.model.PersonalDetails;
import com.nileshrane.systemapi.model.ProfileDetails;
import com.nileshrane.systemapi.service.ProfileService;

@RestController
@RequestMapping(name = "/profile", path = "/profile", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class ProfileController {
	
	@Autowired
	ProfileService profileService;
	
	@PostMapping("/addProfile")
	public ResponseEntity addProfile(
			@RequestHeader(name = "userAdmin") String userAdmin, 
			@RequestHeader(name = "userId") String userId,
			@RequestHeader(name= "dateTime" , required = false) Date dateTime,
			@RequestBody ProfileDetails request)
	{
		
		boolean result = false;
		result = profileService.addProfile(request);
		if (!result) {
			return new ResponseEntity("Record already exist",HttpStatus.UNPROCESSABLE_ENTITY);
		}
		 return new ResponseEntity("Record added successfully",HttpStatus.CREATED);
	}
	
	@PutMapping("/{profile_id}")
	public ResponseEntity updateProfile(
			@PathVariable("profile_id") long profileId,
			@RequestHeader(name = "userAdmin") String userAdmin, 
			@RequestHeader(name = "userId") String userId,
			@RequestHeader(name= "dateTime" , required = false) Date dateTime,
			@RequestBody ProfileDetails request)	
	{
		boolean result = false;
		result = profileService.updateProfile(profileId , request);
		if (!result) {
			return new ResponseEntity("NO record available to update",HttpStatus.NOT_FOUND);
		}
		 return new ResponseEntity("Record updated successfully",HttpStatus.OK);
		
	}
	
	@GetMapping("/{profile_id}")
	public ResponseEntity<ProfileDetails> readProfile(@PathVariable("profile_id") long profileId) {
		ProfileDetails profileDetails =  profileService.readProfile(profileId);
		if(null == profileDetails) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<ProfileDetails>(profileDetails, HttpStatus.OK);
	}
	
	@PostMapping("/query")
	public ResponseEntity<ProfileDetails> queryProfile(@RequestBody PersonalDetails personalDetails){
		return readProfile(1);
	}
	
	@DeleteMapping("/{profile_id}")
	public ResponseEntity<ProfileDetails> deleteProfile(@PathVariable("profile_id") long profileId){
		profileService.deleteProfile(profileId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
