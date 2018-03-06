package gr.ece.ntua.bitsTeam.controllers;

import java.util.Locale;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import gr.ece.ntua.bitsTeam.login.SecurityService;
import gr.ece.ntua.bitsTeam.model.Organizer;
import gr.ece.ntua.bitsTeam.model.Parent;
import gr.ece.ntua.bitsTeam.model.PasswordResetToken;
import gr.ece.ntua.bitsTeam.model.User;
import gr.ece.ntua.bitsTeam.model.jparepos.PasswordTokenRepository;
import gr.ece.ntua.bitsTeam.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private SecurityService securityUserService;
	
	@Autowired
	private PasswordTokenRepository passwordTokenRepository;
	
	@Autowired
	private MessageSource messages;
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private Environment env;
	
	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String registration(Model model) {
		model.addAttribute("parentForm", new Parent());
		model.addAttribute("organizerForm", new Organizer());

		return "registration";
	}

	

	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(@RequestParam(value = "success",required = false) String param, Model model, String error, String logout) {
		/*
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");
 
        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");
        */
           
        return "index";
       
    }
   
   
   
    @RequestMapping(value = "/login_failure", method = RequestMethod.GET)
    public String login(Model model, Authentication authentication) {  
        if (authentication == null)
            return "login_failure";
       
        boolean isParent = authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_PARENT"));
        boolean isOrganizer = authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ORGANIZER"));
        if (isParent || isOrganizer)
            return "redirect:/index";
 
        return "login_failure";
       
    }
   
    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){    
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/index";
    }
    
    
    
    @RequestMapping(value = "/user/resetPassword", method = RequestMethod.GET)
    public String showChangePasswordPage(Model model) {
    		model.addAttribute("emailForm", new User());
    		return "reset_password_request";
    }
    
 
    @RequestMapping(value = "/user/changePassword", method = RequestMethod.POST)
    public String resetPassword(@ModelAttribute User user, HttpServletRequest request, RedirectAttributes redirectAttributes) {
        final User currUser = userService.findByEmail(user.getEmail());
        if (currUser != null) {
            final String token = UUID.randomUUID().toString();
            userService.createPasswordResetTokenForUser(currUser, token);
            mailSender.send(constructResetTokenEmail(getAppUrl(request), request.getLocale(), token, currUser));
            redirectAttributes.addAttribute("success", "true");
        } else {
        	redirectAttributes.addAttribute("failure", "true");
        }

        return "redirect:/user/resetPassword";
    }

    
    @RequestMapping(value = "/user/changePassword", method = RequestMethod.GET)
    public String showChangePasswordPage(Model model, @RequestParam("id") long id, @RequestParam("token") String token) {
        final String result = securityUserService.validatePasswordResetToken(id, token);
        if (result == null) {
        	model.addAttribute("passwordForm", new User());
            return "reset_password";
           
        }
        return "redirect:/error";
    }
    
    
    
    @RequestMapping(value = "/user/updatePassword", method = RequestMethod.POST)
    public String changePassword(@ModelAttribute User user, Model model, @RequestParam("id") long id, @RequestParam("token") String token, RedirectAttributes redirectAttributes) {
    	final String result = securityUserService.validatePasswordResetToken(id, token);
    	if (result == null) {
    		PasswordResetToken passToken = passwordTokenRepository.findByToken(token);
            User currUser = passToken.getUser();
            if (!user.getPassword().equals(user.getPasswordConfirm())) {
            	redirectAttributes.addAttribute("failure", "true");
            	return "redirect:/user/changePassword?id=" + id + "&token=" + token;
            } else {
            	userService.changeUserPassword(currUser, user.getPassword());
            	return "redirect:/index";		
            	} 
    	} else {
        	return "redirect:/error";
        }       
    }
    
    
    // ------------- utility methods --------------- //
    
    
    private SimpleMailMessage constructResetTokenEmail(final String contextPath, final Locale locale, final String token, final User user) {
        final String url = contextPath + "/user/changePassword?id=" + user.getUserId() + "&token=" + token;
        final String message = "Please change your password by clicking the following link";
        return constructEmail("Reset Password", message + " \r\n" + url, user);
    }

    private SimpleMailMessage constructEmail(String subject, String body, User user) {
        final SimpleMailMessage email = new SimpleMailMessage();
        email.setSubject(subject);
        email.setText(body);
        email.setTo(user.getEmail());
        email.setFrom(env.getProperty("support.email"));
        return email;
    }
    
    private String getAppUrl(HttpServletRequest request) {
        return "https://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
    }
 
}