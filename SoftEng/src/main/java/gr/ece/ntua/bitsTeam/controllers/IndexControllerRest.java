package gr.ece.ntua.bitsTeam.controllers;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import gr.ece.ntua.bitsTeam.model.Activity;
import gr.ece.ntua.bitsTeam.model.jparepos.ActivityRepository;

@RestController
public class IndexControllerRest {

	@Autowired
	private ActivityRepository activityRepository;
	
	@GetMapping("/lala")
	public String returnParentsOrganizers(Locale locale, Model model) throws JsonProcessingException {
		
		List<Activity> activities = activityRepository.findAll();

        ObjectMapper mapper = new ObjectMapper();
    
        String json = mapper.writeValueAsString(activities);
		return json;
	}
	
}