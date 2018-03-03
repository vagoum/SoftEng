package gr.ece.ntua.bitsTeam.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.geo.Point;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "location_table")
public class Location {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	
	private String address;
	
	private String city;
	
	
	private String postalCode;
	
	private Double longtitude;
	
	private Double latitude;

	public String getAddress() {
		return address;
	}

	
	public void setAddress(String address) {
		this.address = address;
	}

	@JsonIgnore
	public String getCity() {
		return city;
	}

	
	public void setCity(String city) {
		this.city = city;
	}

	public String getPostalCode() {
		return postalCode;
	}
	@JsonIgnore
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public Double getLongtitude() {
		return longtitude;
	}

	public void setLongtitude(Double longtitude) {
		this.longtitude = longtitude;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	
	@Override
	public String toString() {
		return "Location [id=" + id + ", address=" + address + ", city=" + city + ", postalCode=" + postalCode
				+ ", longtitude=" + longtitude + ", latitude=" + latitude + "]";
	}

}
