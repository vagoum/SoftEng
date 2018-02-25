package gr.ece.ntua.bitsTeam.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue("parent")
public class Parent extends User {
	
	@OneToOne(fetch = FetchType.EAGER)
	private Location location;
	

	@OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
	private List<Booking> bookings = new ArrayList<>();
	
	private Integer pointBalance;
	
	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public List<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}

	@Override
	public String toString() {
		return "Parent [location=" + location + ", bookings=" + bookings + "]";
	}

	public Integer getPointBalance() {
		return pointBalance;
	}

	public void setPointBalance(Integer pointBalance) {
		this.pointBalance = pointBalance;
	}

}
