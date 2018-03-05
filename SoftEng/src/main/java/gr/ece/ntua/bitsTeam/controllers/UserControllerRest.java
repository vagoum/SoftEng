package gr.ece.ntua.bitsTeam.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import gr.ece.ntua.bitsTeam.login.SecurityService;
import gr.ece.ntua.bitsTeam.model.Location;
import gr.ece.ntua.bitsTeam.model.Organizer;
import gr.ece.ntua.bitsTeam.model.Parent;
import gr.ece.ntua.bitsTeam.service.UserService;

@RestController
public class UserControllerRest {
	@Autowired
	private UserService userService;

	@Autowired
	private SecurityService securityService;

	@RequestMapping(value = "/parent_registration", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String register(@RequestBody Parent parent) {

		boolean exists = userService.findByEmail(parent.getEmail()) != null;

		if (!exists) {

			userService.save(parent, "ROLE_PARENT");
			//checkLocation(parent.getLocation());
			securityService.autologin(parent.getEmail(), parent.getPasswordConfirm());

			return "success";
		}
		return "mail_used";

	}

	@RequestMapping(value = "/organizer_registration", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String register(@RequestBody Organizer organizer) {

		boolean exists = userService.findByEmail(organizer.getEmail()) != null;

		if (!exists) {

			userService.save(organizer, "ROLE_ORGANIZER");

			securityService.autologin(organizer.getEmail(), organizer.getPasswordConfirm());

			return "success";
		}
		return "mail_used";
	}
	

}