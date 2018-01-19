package gr.ece.ntua.bitsTeam.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import gr.ece.ntua.bitsTeam.model.ActivityDetails;
import gr.ece.ntua.bitsTeam.model.jparepos.ActivityDetailsRepository;

@Controller
public class CreateActivityController {

	@Autowired
	private ActivityDetailsRepository activityDetailsRepository;
	
	@GetMapping("/activity_create")
	public String index(Map<String, Object> model) {
		return "activity_create";
	}

	@PostMapping("/create_activity")
	public String createUser(@ModelAttribute ActivityDetails ad) {
		if (ad != null)
			activityDetailsRepository.save(ad);
		return "activity_create";

	}

}