package gr.ece.ntua.bitsTeam.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PaymentController {

	@RequestMapping(value = "/payment", method = RequestMethod.GET)
	public String promptPayment(Model model) {
		return "payment_panel";
	}
	
}
