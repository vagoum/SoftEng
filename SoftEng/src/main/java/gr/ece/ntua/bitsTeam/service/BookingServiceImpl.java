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
	public String book(String email, Long activityId, Integer ticketsBought, Booking booking) {
		Parent parent = parentRepository.findByEmail(email);
		Activity activity = activityRepository.findOne(activityId);
		Integer totalCost = activity.getCost() * ticketsBought;
		Integer balance = parent.getBalance();
		if (activity.getTicketsLeft() >= ticketsBought) {

			if (totalCost <= balance) {
				booking.setActivity(activity);
				booking.setParent(parent);
				booking.setTimestamp(new Date());
				booking.setTicketsBought(ticketsBought);
				activity.setTicketsLeft(activity.getTicketsLeft() - ticketsBought);
				activity.getBookings().add(booking);

				bookingRepository.save(booking);
				parent.setBalance(balance - totalCost);
				parentRepository.save(parent);
				activityRepository.save(activity);
				return "success";
			}
			else {
				return "not enough points";
			}
		}
		return "no tickets left";
	}
}
/*
		if (totalCost <= balance) {
			booking.setActivity(activity);
			booking.setParent(parent);
			booking.setTicketsBought(ticketsBought);
			booking.setTimestamp(new Date());

			bookingRepository.save(booking);
			parent.setBalance(balance - totalCost);
			parentRepository.save(parent);
			return "success";
		} else {
			return "no tickets left";
		}
	}
	*/

