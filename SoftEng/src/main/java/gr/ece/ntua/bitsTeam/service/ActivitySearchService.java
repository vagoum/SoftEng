package gr.ece.ntua.bitsTeam.service;

import java.util.List;

import gr.ece.ntua.bitsTeam.jsonClasses.SearchFiltersWrapper;
import gr.ece.ntua.bitsTeam.model.Activity;

public interface ActivitySearchService {

	
	public List<Activity> search(SearchFiltersWrapper searchFiltersWrapper);
}
