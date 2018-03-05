package gr.ece.ntua.bitsTeam.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "location_table")
public class Location {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String address = "";

	private String city = "";

	private String postalCode = "";

	private Double longtitude = 23.728063;

	// @Column(name = "longtitude", insertable = true, updatable = true,
	// nullable = false, length = 255)
	// @ColumnDefault("37.981091")
	private Double latitude = 37.981091;

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
		if (longtitude == null)
			longtitude = 23.728063;
		else {
			this.longtitude = longtitude;
		}
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		if (latitude == null) {
			latitude = 37.981091;
		} else {
			this.latitude = latitude;
		}
	}

	@Override
	public String toString() {
		return "Location [id=" + id + ", address=" + address + ", city=" + city + ", postalCode=" + postalCode
				+ ", longtitude=" + longtitude + ", latitude=" + latitude + "]";
	}
}