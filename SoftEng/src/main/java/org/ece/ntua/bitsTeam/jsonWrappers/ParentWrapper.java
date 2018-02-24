package org.ece.ntua.bitsTeam.jsonWrappers;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ParentWrapper{


	@JsonProperty("firstName")
	private String firstName;
	@JsonProperty("lastName")
	private String lastName;
	@JsonProperty("phone")
	private String phone;
	@JsonProperty("email")
	private String email;
	@JsonProperty("password")
	private String password;

	@JsonProperty("address")
	private String address;
	@JsonProperty("latitude")
	private String latitude;
	@JsonProperty("longtitude")
	private String longtitude;
	


	@JsonProperty("firstName")
	public String getFirstName() {
		return firstName;
	}

	@JsonProperty("firstName")
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@JsonProperty("lastName")
	public String getLastName() {
		return lastName;
	}

	@JsonProperty("lastName")
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@JsonProperty("phone")
	public String getPhone() {
		return phone;
	}

	@JsonProperty("phone")
	public void setPhone(String phone) {
		this.phone = phone;
	}

	@JsonProperty("email")
	public String getEmail() {
		return email;
	}

	@JsonProperty("email")
	public void setEmail(String email) {
		this.email = email;
	}

	@JsonProperty("password")
	public String getPassword() {
		return password;
	}

	@JsonProperty("password")
	public void setPassword(String password) {
		this.password = password;
	}

	@JsonProperty("address")
	public String getAddress() {
		return address;
	}

	@JsonProperty("address")
	public void setAddress(String address) {
		this.address = address;
	}

	@JsonProperty("latitude")
	public String getLatitude() {
		return latitude;
	}

	@JsonProperty("latitude")
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	@JsonProperty("longtitude")
	public String getLongtitude() {
		return longtitude;
	}

	@JsonProperty("longtitude")
	public void setLongtitude(String longtitude) {
		this.longtitude = longtitude;
	}


	
	@Override
	public String toString() {
		return "ParentWrapper [firstName=" + firstName + ", lastName=" + lastName + ", phone=" + phone + ", email="
				+ email + ", password=" + password + ", address=" + address + ", latitude=" + latitude + ", longtitude="
				+ longtitude + "]";
	}

}

