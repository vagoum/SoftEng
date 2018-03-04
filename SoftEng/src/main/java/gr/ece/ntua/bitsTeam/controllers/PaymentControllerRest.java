package gr.ece.ntua.bitsTeam.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import gr.ece.ntua.bitsTeam.service.PaymentService;

@RestController
public class PaymentControllerRest {

	@Autowired
	private PaymentService paymentService;
	
	@RequestMapping(value = "/users/payment", method = RequestMethod.POST)
	public String payment_control(@RequestParam ("points") Integer activityPoints, Model model) {
		String status;
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();	
		String email = auth.getName();

		status = paymentService.executePayment(email, activityPoints);
		return status;
	}
	

}
