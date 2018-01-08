package gr.ece.ntua.bitsTeam.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class Activity {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@Fetch(FetchMode.SELECT)
    @JoinTable(name="ACTIVITY_BOOKING_ASSOC", 
                joinColumns={@JoinColumn(name="ACTIVITY_ID")}, 
                inverseJoinColumns={@JoinColumn(name="BOOKING_ID")})
	private List<Booking> bookings = new ArrayList<>();
	
	@OneToOne(fetch = FetchType.EAGER)
	private ActivityDetails activityDetails;

	private Boolean elapsed;
	
	
	public List<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}

	public ActivityDetails getActivityDetails() {
		return activityDetails;
	}

	public void setActivityDetails(ActivityDetails activityDetails) {
		this.activityDetails = activityDetails;
	}

	public Boolean getElapsed() {
		return elapsed;
	}

	public void setElapsed(Boolean elapsed) {
		this.elapsed = elapsed;
	}
}
