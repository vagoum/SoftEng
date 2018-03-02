package gr.ece.ntua.bitsTeam.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import gr.ece.ntua.bitsTeam.login.SecurityService;
import gr.ece.ntua.bitsTeam.login.UserValidator;
import gr.ece.ntua.bitsTeam.model.Organizer;
import gr.ece.ntua.bitsTeam.model.Parent;
import gr.ece.ntua.bitsTeam.service.UserService;

@Controller
public class UserController {



	
	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String registration(Model model) {
		model.addAttribute("parentForm", new Parent());
		model.addAttribute("organizerForm", new Organizer());

		return "registration";
	}

	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(@RequestParam(value = "success",required = false) String param, Model model, String error, String logout) {
		if (error != null)
			model.addAttribute("error", "Your username and password is invalid.");

		if (logout != null)
			model.addAttribute("message", "You have been logged out successfully.");
			
		return "redirect:/";
		
	}
	
	
	@RequestMapping(value = "/login_failure", method = RequestMethod.GET)
	public String login(Model model, Authentication authentication) {	
		if (authentication == null)
			return "login_failure";
		
		boolean isParent = authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_PARENT"));
		boolean isOrganizer = authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ORGANIZER"));
		if (isParent || isOrganizer)
			return "index";

		return "login_failure";
		
	}

}