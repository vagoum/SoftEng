package gr.ece.ntua.bitsTeam.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import gr.ece.ntua.bitsTeam.jsonClasses.BookActivityWrapper;
import gr.ece.ntua.bitsTeam.service.BookingService;

@RestController
public class BookingControllerRest {

	@Autowired
	private BookingService bookingService;

	@RequestMapping(value = "/book_activity", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String booking_control(@RequestBody BookActivityWrapper bookActivityWrapper) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();	
		String email = auth.getName();
		String status;
		
		
		Long activityId = bookActivityWrapper.getActivityId();
		Integer ticketsBought = bookActivityWrapper.getTicketsBought();
		
		// transactional method call
		status = bookingService.book(email, activityId, ticketsBought);
		return status;
		

	}

}
