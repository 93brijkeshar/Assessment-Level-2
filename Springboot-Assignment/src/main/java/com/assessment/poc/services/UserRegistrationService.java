package com.assessment.poc.services;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.assessment.poc.entities.UserRegistration;


public interface UserRegistrationService {
	
	public UserRegistration registerUser(UserRegistration userRegistration);
	public List<UserRegistration> getAllRegistredUser();
	
	
}
