package gr.ece.ntua.bitsTeam.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import gr.ece.ntua.bitsTeam.jsonClasses.BookActivityWrapper;
import gr.ece.ntua.bitsTeam.model.Booking;
import gr.ece.ntua.bitsTeam.service.BookingService;
import gr.ece.ntua.bitsTeam.utils.mail.MailSender;

@RestController
public class BookingControllerRest {

	@Autowired
	private BookingService bookingService;

	private MailSender mailSender;

	@RequestMapping(value = "/book_activity", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String booking_control(@RequestBody BookActivityWrapper bookActivityWrapper) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();	
		String email = auth.getName();
		String status;
		mailSender = new MailSender();
		
		Long activityId = bookActivityWrapper.getActivityId();
		Integer ticketsBought = bookActivityWrapper.getTicketsBought();
		
		// transactional method call
		Booking newBooking = new Booking();
		status = bookingService.book(email, activityId, ticketsBought, newBooking);
		if (status == "success")
			mailSender.sendBookingEmail(newBooking);
		return status;

	}

}
