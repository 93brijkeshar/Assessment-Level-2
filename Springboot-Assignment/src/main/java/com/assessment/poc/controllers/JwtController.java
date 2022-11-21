package com.assessment.poc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.assessment.poc.helper.JwtUtil;
import com.assessment.poc.model.JwtRequest;
import com.assessment.poc.model.JwtResponse;
import com.assessment.poc.services.CustomUserDetailsService;

@RestController
@CrossOrigin(origins = "*")
public class JwtController {
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@PostMapping("/token")
	public ResponseEntity<?> generateToken(@RequestBody JwtRequest request)throws Exception{
		System.out.println(request);
		try {
			this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
			
		}catch (UsernameNotFoundException e) {
			e.printStackTrace();
			throw new Exception("Bad Crenditials");
		}catch (BadCredentialsException e) {
			e.printStackTrace();
			throw new Exception("Bad Crenditials");
		}
		UserDetails userDetails = this.customUserDetailsService.loadUserByUsername(request.getUsername());
		String token = this.jwtUtil.generateToken(userDetails);
		System.out.println("jwt-->"+token);
		
		return ResponseEntity.ok(new JwtResponse(token));
	}

}
