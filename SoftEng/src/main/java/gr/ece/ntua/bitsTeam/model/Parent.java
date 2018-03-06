package gr.ece.ntua.bitsTeam.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;


@Entity
@DiscriminatorValue("parent")
public class Parent extends User {
	
	@OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Booking> bookings = new ArrayList<>();
	
	@OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
	private List<Payment> payments = new ArrayList<>();
	
	public List<Payment> getPayments() {
		return payments;
	}

	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}

	private Integer balance = 0;
	
	private Integer pointsToReward = 0;
	
	
	public Integer getBalance() {
		return balance;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}


	public List<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}

	@Override
	public String toString() {
		return "Parent [bookings=" + bookings + "]";
	}

	public Integer getPointsToReward() {
		return pointsToReward;
	}

	public void setPointsToReward(Integer pointsToReward) {
		this.pointsToReward = pointsToReward;
	}


}
