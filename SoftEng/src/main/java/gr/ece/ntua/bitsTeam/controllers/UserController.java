package gr.ece.ntua.bitsTeam.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
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

	@Autowired
	private UserService userService;

	@Autowired
	private SecurityService securityService;

	@Autowired
	private UserValidator userValidator;

	
	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String registration(Model model) {
		model.addAttribute("parentForm", new Parent());
		model.addAttribute("organizerForm", new Organizer());

		return "registration";
	}

	
	@RequestMapping(value = "/users/parents/registration1", method = RequestMethod.POST)
	public String registrationParent(@ModelAttribute("parentForm") Parent parent, BindingResult bindingResult,
			HttpServletRequest request, Model model) {
		userValidator.validate(parent, bindingResult);

		if (bindingResult.hasErrors()) {
			return "registration";
		}

		userService.save(parent, "ROLE_PARENT");

		securityService.autologin(parent.getEmail(), parent.getPassword());

		return "redirect:/";
	}

	
	@RequestMapping(value = "users/organizers/registration1", method = RequestMethod.POST)
	public String registrationOrganizer(@ModelAttribute("organizerForm") Organizer organizer,
			BindingResult bindingResult, HttpServletRequest request, Model model) {
		userValidator.validate(organizer, bindingResult);

		if (bindingResult.hasErrors()) {
			return "registration";
		}

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
           
        return "index";
       
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
   
    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){    
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "index";
    }
 
}