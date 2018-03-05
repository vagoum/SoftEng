package gr.ece.ntua.bitsTeam.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import gr.ece.ntua.bitsTeam.jsonClasses.SearchFiltersWrapper;
import gr.ece.ntua.bitsTeam.model.Activity;
import gr.ece.ntua.bitsTeam.service.ActivitySearchService;

@RestController
public class SearchControllerRest {

	@Autowired
	private ActivitySearchService activitySearchService;
	
	@RequestMapping(value = "/search", method = RequestMethod.POST, consumes = "application/json")
	public List<Activity> search(@RequestBody SearchFiltersWrapper searchFilters) {	
		
		List<Activity> result = activitySearchService.search(searchFilters);
        
		
		for(Activity a: result)
			System.out.println(a);
		return result;
		
	}
	

}