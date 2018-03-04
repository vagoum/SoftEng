package gr.ece.ntua.bitsTeam.controllers;

import java.util.ArrayList;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import gr.ece.ntua.bitsTeam.model.Activity;
import gr.ece.ntua.bitsTeam.model.Location;
import gr.ece.ntua.bitsTeam.model.User;
import gr.ece.ntua.bitsTeam.model.jparepos.ActivityRepository;
import gr.ece.ntua.bitsTeam.model.jparepos.UserRepository;

@Controller
public class IndexController {

    @Autowired
    private ActivityRepository activityRepository;
    
    @Autowired
    private UserRepository userRepository;
    
    @GetMapping("/index")
    public String index(Locale locale, Model model) {
    	
    	Object o = (Object) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	
    	// anonymous
    	if (o instanceof String) {
    		model.addAttribute("longtitude", 23.728063);
    		model.addAttribute("latitude", 37.981091);
    	}
    	else if (o instanceof org.springframework.security.core.userdetails.User) {
    		org.springframework.security.core.userdetails.User u = (org.springframework.security.core.userdetails.User) o;
    		User user = userRepository.findByEmail(u.getUsername());
    		Location loc = user.getLocation();
    		model.addAttribute("longtitude", loc.getLongtitude());
    		model.addAttribute("latitude", loc.getLatitude());
    	}
    	
    	ArrayList<Activity> detailsList = (ArrayList<Activity>) activityRepository.findAll();
        model.addAttribute("activityDetails", detailsList);
        return "index";
    }
    
    
	@GetMapping("/as")
	public String returnParentsOrganizers(Locale locale, Model model) {
		
		return "admin_panel";
	}
}