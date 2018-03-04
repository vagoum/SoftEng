package gr.ece.ntua.bitsTeam.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import gr.ece.ntua.bitsTeam.jsonClasses.SearchFiltersWrapper;
import gr.ece.ntua.bitsTeam.service.ActivitySearchService;

@RestController
public class SearchControllerRest {

	@Autowired
	private ActivitySearchService activitySearchService;
	
	@RequestMapping(value = "/search", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String search(@RequestBody SearchFiltersWrapper searchFilters) {
		
		return "";
		
	}
	

}
