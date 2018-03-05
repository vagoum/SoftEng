package gr.ece.ntua.bitsTeam.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gr.ece.ntua.bitsTeam.model.Activity;
import gr.ece.ntua.bitsTeam.model.Booking;
import gr.ece.ntua.bitsTeam.model.Parent;
import gr.ece.ntua.bitsTeam.model.jparepos.ActivityRepository;
import gr.ece.ntua.bitsTeam.model.jparepos.BookingRepository;
import gr.ece.ntua.bitsTeam.model.jparepos.ParentRepository;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	private ParentRepository parentRepository;

	@Autowired
	private ActivityRepository activityRepository;

	@Autowired
	private BookingRepository bookingRepository;

	@Transactional
	public String book(String email, Long activityId, Integer ticketsBought) {
		Parent parent = parentRepository.findByEmail(email);
		Activity activity = activityRepository.findOne(activityId);
		Integer totalCost = activity.getCost() * ticketsBought;
		Integer balance = parent.getBalance();
		if (activity.getTicketsLeft() >= ticketsBought) {
			activity.setTicketsLeft(activity.getTicketsLeft() - ticketsBought);
			activityRepository.save(activity);
		} else {
			return "no tickets left";
		}
		
		if (totalCost <= balance) {
			Booking newBooking = new Booking(activity, parent, ticketsBought, new Date());
			
			bookingRepository.save(newBooking);
			parent.setBalance(balance - totalCost);
			parentRepository.save(parent);
			return "success";
		} else {
			return "not enough points";
		}

	}
}
