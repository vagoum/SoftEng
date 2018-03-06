package gr.ece.ntua.bitsTeam.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import gr.ece.ntua.bitsTeam.jsonClasses.PointsWrapper;
import gr.ece.ntua.bitsTeam.service.PaymentService;

@RestController
public class PaymentControllerRest {

	@Autowired
	private PaymentService paymentService;
	
	@RequestMapping(value = "/users/payment", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String payment_control(@RequestBody PointsWrapper points) {
		String status;
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();	
		String email = auth.getName();

		status = paymentService.executePayment(email, points.getPoints());
		return status;
	}

}
