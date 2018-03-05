package gr.ece.ntua.bitsTeam.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;

import gr.ece.ntua.bitsTeam.model.Activity;
import gr.ece.ntua.bitsTeam.model.jparepos.ActivityRepository;

@RestController
public class ActivityControllerRest {

	@Autowired
	private ActivityRepository activityRepository;

	@GetMapping(value = "/getActivities")
	public List<Activity> getActivities() throws JsonGenerationException, JsonMappingException, IOException {


		List<Activity> activities = activityRepository.findAll();

    
        return activities;
	}

}
