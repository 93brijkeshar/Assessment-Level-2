package com.assessment.poc.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assessment.poc.entities.UserRegistration;
import com.assessment.poc.repositories.UserRegistrationRepo;
import com.assessment.poc.services.UserRegistrationService;


@Service
public class UserRegistrationServiceImpl implements UserRegistrationService{
	
	
	@Autowired
	private UserRegistrationRepo userRegistrationRepo;

	@Override
	public UserRegistration registerUser(UserRegistration userRegistration) {
		
		return this.userRegistrationRepo.save(userRegistration);
	}

	@Override
	public List<UserRegistration> getAllRegistredUser() {
		return this.userRegistrationRepo.findAll();
	}

}
