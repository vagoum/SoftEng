package gr.ece.ntua.bitsTeam.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
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
import gr.ece.ntua.bitsTeam.model.Role;
import gr.ece.ntua.bitsTeam.model.User;
import gr.ece.ntua.bitsTeam.model.jparepos.UserRepository;
import gr.ece.ntua.bitsTeam.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private SecurityService securityService;

	@Autowired
	private UserValidator userValidator;

	
	@RequestMapping(value = "/registration2", method = RequestMethod.GET)
	public String registration(Model model) {
		model.addAttribute("parentForm", new Parent());
		model.addAttribute("organizerForm", new Organizer());

		return "registration2";
	}

	
<<<<<<< HEAD
	@RequestMapping(value = "/users/parents/registration", method = RequestMethod.POST)
	public String registrationParent(@ModelAttribute("parentForm") Parent parent, BindingResult bindingResult,
			HttpServletRequest request, Model model) {
		userValidator.validate(parent, bindingResult);
=======
    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("parentForm", new Parent());
        model.addAttribute("organizerForm", new Organizer());
>>>>>>> refs/heads/spring

<<<<<<< HEAD
		if (bindingResult.hasErrors()) {
			return "registration";
		}
=======
        return "registration";
    }
>>>>>>> refs/heads/spring

<<<<<<< HEAD
		userService.save(parent, "ROLE_PARENT");
=======
    @RequestMapping(value = "/users/parents/registrati", method = RequestMethod.POST)
    public String registrationParent(@ModelAttribute("parentForm") Parent parent, BindingResult bindingResult, HttpServletRequest request,Model model) {
        userValidator.validate(parent, bindingResult);
>>>>>>> refs/heads/spring

		securityService.autologin(parent.getEmail(), parent.getPassword());

		return "redirect:/";
	}

	
	@RequestMapping(value = "users/organizers/registration", method = RequestMethod.POST)
	public String registrationOrganizer(@ModelAttribute("organizerForm") Organizer organizer,
			BindingResult bindingResult, HttpServletRequest request, Model model) {
		userValidator.validate(organizer, bindingResult);

<<<<<<< HEAD
		if (bindingResult.hasErrors()) {
			return "registration";
		}
=======
        return "redirect:/welcome";
    }
    
    
    @RequestMapping(value = "users/organizers/registrati", method = RequestMethod.POST)
    public String registrationOrganizer(@ModelAttribute("organizerForm") Organizer organizer, BindingResult bindingResult, HttpServletRequest request, Model model) {
        userValidator.validate(organizer, bindingResult);
>>>>>>> refs/heads/spring

		userService.save(organizer, "ROLE_ORGANIZER");

		securityService.autologin(organizer.getEmail(), organizer.getPassword());

		return "redirect:/";
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
