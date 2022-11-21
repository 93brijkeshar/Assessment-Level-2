package com.assessment.poc.controllers;

import java.util.List;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assessment.poc.entities.UserRegistration;
import com.assessment.poc.repositories.UserRegistrationRepo;
import com.assessment.poc.services.UserRegistrationService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1")

public class UserRegistrationController {
	
	@Autowired
	private UserRegistrationService userRegistrationService;
	private UserRegistrationController userServiceMark;
	
	@Autowired
	UserRegistrationRepo userRegistrationRepo;
	
	
	/*---------User Registration API------------*/
	
	@PostMapping("/registerUser")
	public  ResponseEntity<UserRegistration> registerUser(@RequestBody UserRegistration userRegistration){
		
		UserRegistration registerUser = this.userRegistrationService.registerUser(userRegistration);
		if(registerUser!=null) {
			System.out.println("**----------Registered User Details------------**");
			System.out.println("User username:- " +userRegistration.getUsername());
			System.out.println("User Password:- " +userRegistration.getPassword());
		}else {
			System.out.println("---------Nothing Find--------------");
		}
		return new ResponseEntity<>(registerUser, HttpStatus.CREATED);
	}
	
	
	/*---------Get User List API------------*/
	
	@GetMapping("/allUser")
	public ResponseEntity<List<UserRegistration>> getAllRegistredUser(){
		return ResponseEntity.ok(this.userRegistrationService.getAllRegistredUser());
	}
	
	/*--------------------Get User delete API------ */
	@DeleteMapping("/delete/{userid}")
	public ResponseEntity<String> delete(@PathVariable("id") Long id){
		//User user = userServiceMark.findByUserId(id);
		UserRegistration userRegis = userRegistrationRepo.getUserRegistrationDetailById(id);
		userRegistrationRepo.delete(userRegis);
		return ResponseEntity.ok().body("Success");	
	
	}
	
	private void delete(UserRegistrationController userServiceMark2) {
		// TODO Auto-generated method stub
		
	}


	@PostMapping("/update")
	public ResponseEntity<UserRegistration> update(@RequestBody UserRegistration userRegistration){
		
		  UserRegistration UserRegistrationSave = userRegistrationRepo.save(userRegistration);
		return ResponseEntity.ok().body(UserRegistrationSave);	
    }


	private User save(User user) {
		// TODO Auto-generated method stub
		return null;
	} 
}
