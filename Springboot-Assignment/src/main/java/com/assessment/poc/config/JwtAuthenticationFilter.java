package com.assessment.poc.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.assessment.poc.helper.JwtUtil;
import com.assessment.poc.services.CustomUserDetailsService;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter{
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private CustomUserDetailsService customUserDetailsService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		/*---1. Get Token----*/
		String  requestToken = request.getHeader("Authorization");
		System.err.println("Request Token----> "+requestToken);
		String username=null;
		String token = null;
		if(requestToken!=null && requestToken.startsWith("Bearer"))
		{
			token = requestToken.substring(7);
			try {
			username = this.jwtUtil.getUsernameFromToken(token);
			}catch (IllegalArgumentException e) {
				System.out.println("Unable to get JWT Token");
			}catch (ExpiredJwtException e) {
				System.out.println("JWT Token Has been Expired");
			}catch (MalformedJwtException e) {
				System.out.println("Invalid JWT");
			}
		}else {
			System.err.println("JWT Token doesn't begin with Bearer");
		}
		
		/*Once we get Token, Now Validate*/
		if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null)
		{
			UserDetails userDetails = this.customUserDetailsService.loadUserByUsername(username);
			if(this.jwtUtil.validateToken(token, userDetails))
			{
				/* Working fine, Do Authentication here */
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails,null, userDetails.getAuthorities());
				usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			}
			else
			{
				System.out.println("Invalid JWT Token");
			}
		}
				
		filterChain.doFilter(request, response);
	}
	

}
