package gr.ece.ntua.bitsTeam.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Future;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
@Table(name = "activity_details")
public class ActivityDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer activityDetailsId;

	private String name = "";

	private String type;

	
	private String activityDescription;
	
	
	private Integer cost;

	private Integer ticketNumber;

	@OneToOne(cascade = CascadeType.ALL)
	private Photo thumbNail;
	
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "PST")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	// @Future(message = "Activity day must be in the future.")
	private Date date;

	private String ageRange;

	private String description;

	private String address;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "activityDetailsId")
	private List<Photo> photos = new ArrayList<>();
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Location location;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getCost() {
		return cost;
	}

	public void setCost(Integer cost) {
		this.cost = cost;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getAgeRange() {
		return ageRange;
	}

	public void setAgeRange(String ageRange) {
		this.ageRange = ageRange;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Integer getTicketNumber() {
		return ticketNumber;
	}

	public void setTicketNumber(Integer ticketNumber) {
		this.ticketNumber = ticketNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Photo> getPhotos() {
		return photos;
	}

	public void setPhotos(List<Photo> photos) {
		this.photos = photos;
	}

	@Override
	public String toString() {
		return "ActivityDetails [id=" + activityDetailsId + ", name=" + name + ", type=" + type + ", cost=" + cost + ", ticketNumber="
				+ ticketNumber + ", date=" + date + ", ageRange=" + ageRange + ", description=" + description
				+ ", address=" + address + ", photos=" + photos + ", location=" + location + "]";
	}

	public Photo getThumbNail() {
		return thumbNail;
	}

	public void setThumbNail(Photo thumbNail) {
		this.thumbNail = thumbNail;
	}

	public String getActivityDescription() {
		return activityDescription;
	}

	public void setActivityDescription(String activityDescription) {
		this.activityDescription = activityDescription;
	}

}
