package com.assessment.poc.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@ToString
public class UserRegistration {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	private String username;
	private String userEmail;
	private String password;
	private String country;
	private String state;
	private String distt;
	private String pinCode;
	private Long adahaarNumber;
	private String panNumber;
	private String city;
	private String mobileNumber;
	private String userType;
	private boolean enabled;
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getDistt() {
		return distt;
	}
	public void setDistt(String distt) {
		this.distt = distt;
	}
	public String getPinCode() {
		return pinCode;
	}
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	public Long getAdahaarNumber() {
		return adahaarNumber;
	}
	public void setAdahaarNumber(Long adahaarNumber) {
		this.adahaarNumber = adahaarNumber;
	}
	public String getPanNumber() {
		return panNumber;
	}
	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public UserRegistration(Long userId, String username, String userEmail, String password, String country,
			String state, String distt, String pinCode, Long adahaarNumber, String panNumber, String city,
			String mobileNumber, String userType, boolean enabled) {
		super();
		this.userId = userId;
		this.username = username;
		this.userEmail = userEmail;
		this.password = password;
		this.country = country;
		this.state = state;
		this.distt = distt;
		this.pinCode = pinCode;
		this.adahaarNumber = adahaarNumber;
		this.panNumber = panNumber;
		this.city = city;
		this.mobileNumber = mobileNumber;
		this.userType = userType;
		this.enabled = enabled;
	}
	public UserRegistration() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "UserRegistration [userId=" + userId + ", username=" + username + ", userEmail=" + userEmail
				+ ", password=" + password + ", country=" + country + ", state=" + state + ", distt=" + distt
				+ ", pinCode=" + pinCode + ", adahaarNumber=" + adahaarNumber + ", panNumber=" + panNumber + ", city="
				+ city + ", mobileNumber=" + mobileNumber + ", userType=" + userType + ", enabled=" + enabled + "]";
	}
	

}
