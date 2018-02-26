package gr.ece.ntua.bitsTeam.controllers;

import java.util.ArrayList;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import gr.ece.ntua.bitsTeam.model.Activity;
import gr.ece.ntua.bitsTeam.model.jparepos.ActivityRepository;

@Controller
public class IndexController {

    @Autowired
    private ActivityRepository activityRepository;
        
    @GetMapping("/index")
    public String index(Locale locale, Model model) {
    	
    	ArrayList<Activity> detailsList = (ArrayList<Activity>) activityRepository.findAll();
        model.addAttribute("activityDetails", detailsList);
        return "index";
    }
    
    
	@GetMapping("/as")
	public String returnParentsOrganizers(Locale locale, Model model) {
		
		return "admin_panel";
	}
}