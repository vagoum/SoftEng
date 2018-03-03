package gr.ece.ntua.bitsTeam.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import gr.ece.ntua.bitsTeam.jsonClasses.EmailActionWrapper;
import gr.ece.ntua.bitsTeam.model.Organizer;
import gr.ece.ntua.bitsTeam.model.User;
import gr.ece.ntua.bitsTeam.model.jparepos.UserRepository;

@RestController
public class AdminControllerRest {

	@Autowired
	private UserRepository<User> userRepository;

	@RequestMapping(value = "/admin/manageUsers", method = RequestMethod.POST)
	public String manageUsers(@RequestBody EmailActionWrapper demo)
			throws Exception {

		String action = demo.getAction();
		String email = demo.getEmail();

		System.out.println(action);
		System.out.println(email);

		User user = userRepository.findByEmail(email);
		if (user != null)
			switch (action) {
			case "block":
				user.setBlocked(true);
				userRepository.save(user);
				break;
			case "reset":
				user.setResetPassword(true);
				userRepository.save(user);
				break;
			case "verify":
				Organizer organizer = (Organizer) user;
				organizer.setVerified(true);
				userRepository.save(organizer);
				break;
			case "delete":
				userRepository.delete(user);
				break;
			default:
				break;
			}

		return "success";
	}

}
