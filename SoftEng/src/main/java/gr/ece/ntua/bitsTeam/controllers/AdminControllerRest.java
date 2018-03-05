package gr.ece.ntua.bitsTeam.controllers;

import java.util.Locale;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import gr.ece.ntua.bitsTeam.jsonClasses.EmailActionWrapper;
import gr.ece.ntua.bitsTeam.model.Organizer;
import gr.ece.ntua.bitsTeam.model.User;
import gr.ece.ntua.bitsTeam.model.jparepos.UserRepository;
import gr.ece.ntua.bitsTeam.service.UserService;

@RestController
public class AdminControllerRest {

	@Autowired
    UserService userService;
	
	@Autowired
	private UserRepository<User> userRepository;
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private Environment env;

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
				user.setBlocked(!user.getBlocked());
				userRepository.save(user);
				break;
			case "reset":
				user.setResetPassword(true);
				userRepository.save(user);
				resetPassword(user);
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
	
	private void resetPassword(User user) {
		final User currUser = userService.findByEmail(user.getEmail());
        if (currUser != null) {
            final String token = UUID.randomUUID().toString();
            userService.createPasswordResetTokenForUser(currUser, token);
            String url = "http://localhost:8888";
            mailSender.send(constructResetTokenEmail(url, Locale.getDefault(), token, currUser));
        }

    }
	
	 private SimpleMailMessage constructResetTokenEmail(String contextPath, final Locale locale, final String token, final User user) {
	        final String url = contextPath + "/user/changePassword?id=" + user.getUserId() + "&token=" + token;
	        final String message = "Administrator of KidA has requested a password reset.\n Please reset your password by clicking the following link:";
	        return constructEmail("Administrator request - reset password", message + " \r\n" + url, user);
	    }

	    private SimpleMailMessage constructEmail(String subject, String body, User user) {
	        final SimpleMailMessage email = new SimpleMailMessage();
	        email.setSubject(subject);
	        email.setText(body);
	        email.setTo(user.getEmail());
	        email.setFrom(env.getProperty("support.email"));
	        return email;
	    }
}
