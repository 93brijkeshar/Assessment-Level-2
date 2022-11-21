package com.assessment.poc.services;

import java.util.ArrayList;
import org.springframework.security.core.userdetails.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.assessment.poc.entities.CustomUserDetails;
import com.assessment.poc.entities.UserRegistration;
import com.assessment.poc.repositories.UserRegistrationRepo;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private UserRegistrationRepo userRegistrationRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserRegistration user = this.userRegistrationRepo.findByUsername(username);
		if(user==null) {
			throw new UsernameNotFoundException("User not found");
		}else {
			return new CustomUserDetails(user);
		}
		
		
	
	}

}
