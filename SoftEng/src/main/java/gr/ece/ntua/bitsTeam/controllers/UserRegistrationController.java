package gr.ece.ntua.bitsTeam.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import gr.ece.ntua.bitsTeam.model.User;

@Controller
public class UserRegistrationController {


	
	
	@RequestMapping(value="/registration", method = RequestMethod.GET)
	public String activityForm(Model model) {
		model.addAttribute("user", new User());
		return "registration";
	}

	
}