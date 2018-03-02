package gr.ece.ntua.bitsTeam.service;

import java.util.List;

import gr.ece.ntua.bitsTeam.model.Activity;
import gr.ece.ntua.bitsTeam.model.Location;

public interface ActivityService {

	
	List<Activity> findInRadius(Location location, int radius);
}
