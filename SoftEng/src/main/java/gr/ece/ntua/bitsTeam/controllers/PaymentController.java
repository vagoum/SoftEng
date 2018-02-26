package gr.ece.ntua.bitsTeam.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import gr.ece.ntua.bitsTeam.model.Parent;
import gr.ece.ntua.bitsTeam.model.Payment;
import gr.ece.ntua.bitsTeam.model.jparepos.ParentRepository;


public class PaymentController {
	
	@Autowired
	private ParentRepository parentRepository;
	
	@RequestMapping(value = "/users/payment", method = RequestMethod.POST)
	public String executePayment(@ModelAttribute("paymentInfo") Payment payment, Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String currEmail;
		Integer oldBalance;
		if (auth != null) {
			currEmail = auth.getName();
			Parent parent = parentRepository.findByEmail(currEmail);
			payment.setParent(parent);
			payment.setTimestamp(new Date());
			// update parent's balance by adding the recently bought activity points
			oldBalance = parent.getBalance();
			parent.setBalance(oldBalance + payment.getActivityPoints());
			parentRepository.save(parent);
			
		} 
		else {
			System.out.print("Error: user is not currently logged in");
		}
				
		return "redirect:/users/profile";
	}
	
	@RequestMapping(value = "/users/payment", method = RequestMethod.GET)
	public String promptPayment(Model model) {
		return "payment_panel";
	}
}
