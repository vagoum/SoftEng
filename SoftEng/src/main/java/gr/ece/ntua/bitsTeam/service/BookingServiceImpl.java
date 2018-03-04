package gr.ece.ntua.bitsTeam.service;

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
public class BookingServiceImpl {
	
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
		if (totalCost <= parent.getBalance()) {
			Booking new_booking = new Booking(activity, parent, ticketsBought);
			bookingRepository.save(new_booking);
			return "success";
		} else {
			return "not enough points";
		}
		
    }
}
