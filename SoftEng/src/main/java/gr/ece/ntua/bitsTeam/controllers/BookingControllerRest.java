package gr.ece.ntua.bitsTeam.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import gr.ece.ntua.bitsTeam.jsonClasses.BookActivityWrapper;

@RestController
public class BookingControllerRest {

	// TO DO

	@RequestMapping(value = "/book_activity", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String register(@RequestBody BookActivityWrapper bookActivityWrapper) {
		
		// call at transactional
		// call_transaction();

		return "success";

	}

}
