package gr.ece.ntua.bitsTeam.service;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;

import gr.ece.ntua.bitsTeam.model.Activity;
import gr.ece.ntua.bitsTeam.model.Location;
import gr.ece.ntua.bitsTeam.model.jparepos.ActivityRepository;

public class ActivityServiceImpl implements ActivityService{

	@Autowired
	private ActivityRepository activityRepository;
	
	@Autowired
	private EntityManagerFactory entityManagerFactory;
	
	@Override
	public List<Activity> findInRadius(Location location, int radius) {
		
		Query q =  entityManagerFactory.createEntityManager().createNativeQuery("SELECT activity.activity_id FROM activity, location_table as l WHERE activity.location_id=l.id and earth_box(ll_to_earth(?, ?), ?) @> ll_to_earth(l.latitude, l.longtitude);").setParameter(1, radius).setParameter(2, location.getLatitude()).setParameter(3, location.getLongtitude());
		List<Long> list = q.getResultList();
		List<Activity> activityList = activityRepository.findAll(list);
		return activityList;
	}

}
