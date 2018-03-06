package gr.ece.ntua.bitsTeam.service;

import gr.ece.ntua.bitsTeam.model.Booking;

public interface BookingService {

	public String book(String email, Long activityId, Integer ticketsBought, Booking booking);

}
