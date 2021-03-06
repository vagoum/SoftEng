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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Activity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long activityId;
	
	@ManyToOne
    @JoinColumn(name = "organizerId")
	private Organizer organizer;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "activityId")
	private List<Booking> bookings = new ArrayList<>();
	
	private String name = "";

	private String category = "";

	private String activityDescription;
	
	private Integer cost;
	
	private Integer ticketNumber;

	@OneToOne(cascade = CascadeType.ALL)
	private Photo thumbNail;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy", timezone = "PST")
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	// @Future(message = "Activity day must be in the future.")
	private Date date;

	private Integer ticketsLeft;

	private String time;
	
	private Integer ageMin;
	
	private Integer ageMax;
	
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "activityDetailsId")
	private List<Photo> photos = new ArrayList<>();
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Location location;
	
	@JsonIgnore
	private Boolean elapsed;
	
	public Long getActivityId() {
		return activityId;
	}

	public void setActivityId(Long activityId) {
		this.activityId = activityId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getActivityDescription() {
		return activityDescription;
	}

	public void setActivityDescription(String activityDescription) {
		this.activityDescription = activityDescription;
	}

	
	public Integer getCost() {
		return cost;
	}

	
	public void setCost(Integer cost) {
		this.cost = cost;
	}

	@JsonIgnore
	public Integer getTicketNumber() {
		return ticketNumber;
	}

	@JsonProperty
	public void setTicketNumber(Integer ticketNumber) {
		this.ticketNumber = ticketNumber;
		this.setTicketsLeft(ticketNumber);
	}

	public Photo getThumbNail() {
		return thumbNail;
	}

	public void setThumbNail(Photo thumbNail) {
		this.thumbNail = thumbNail;
	}

	public Date getDate() {
		return date;
	}

	@JsonIgnore
	public void setDate(Date date) {
		this.date = date;
	}


	public Integer getAgeMin() {
		return ageMin;
	}
	
	
	public void setAgeMin(Integer ageMin) {
		this.ageMin = ageMin;
	}

	public Integer getAgeMax() {
		return ageMax;
	}

	
	public void setAgeMax(Integer ageMax) {
		this.ageMax = ageMax;
	}

	public List<Photo> getPhotos() {
		return photos;
	}

	@JsonIgnore
	public void setPhotos(List<Photo> photos) {
		this.photos = photos;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	
	public List<Booking> getBookings() {
		return bookings;
	}
	
	@JsonIgnore
	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}

	public Boolean getElapsed() {
		return elapsed;
	}

	
	@JsonIgnore
	public void setElapsed(Boolean elapsed) {
		this.elapsed = elapsed;
	}
	
	public Organizer getOrganizer() {
		return organizer;
	}

	
	@JsonIgnore
	public void setOrganizer(Organizer organizer) {
		this.organizer = organizer;
	}

	public String getCategory() {
		return category;
	}

	
	public void setCategory(String category) {
		this.category = category;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Integer getTicketsLeft() {
		return ticketsLeft;
	}

	public void setTicketsLeft(Integer ticketsLeft) {
		this.ticketsLeft = ticketsLeft;
	}

}
