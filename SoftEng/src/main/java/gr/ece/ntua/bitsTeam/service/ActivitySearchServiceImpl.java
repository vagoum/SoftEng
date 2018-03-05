package gr.ece.ntua.bitsTeam.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gr.ece.ntua.bitsTeam.jsonClasses.SearchFiltersWrapper;
import gr.ece.ntua.bitsTeam.model.Activity;
import gr.ece.ntua.bitsTeam.model.jparepos.ActivityRepository;

@Service
public class ActivitySearchServiceImpl implements ActivitySearchService {

	@Autowired
	private ActivityRepository activityRepository;

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	@Override
	public List<Activity> search(SearchFiltersWrapper searchFiltersWrapper) {
		// TODO Auto-generated method stub

		String text = searchFiltersWrapper.getText();
		String latitude = searchFiltersWrapper.getLatitude();
		String longtitude = searchFiltersWrapper.getLongtitude();
		String proximity = searchFiltersWrapper.getProximity();
		String costMin = searchFiltersWrapper.getCostMin();
		String costMax = searchFiltersWrapper.getCostMax();

		
		//Query q =  entityManagerFactory.createEntityManager().createNativeQuery("SELECT activity.activity_id FROM activity, location_table as l WHERE activity.location_id=l.id and earth_box(ll_to_earth(?, ?), ?) @> ll_to_earth(l.latitude, l.longtitude);").setParameter(1, radius).setParameter(2, location.getLatitude()).setParameter(3, location.getLongtitude());

		Query q = entityManagerFactory.createEntityManager()
				.createNativeQuery("SELECT activity.activity_id FROM activity WHERE activity.name LIKE ? ;")
				.setParameter(1, text);
		List<Long> longList = new ArrayList<>();
		for(Object o : q.getResultList()) {
			BigInteger b = (BigInteger) o;
			longList.add(b.longValueExact());
		}
		List<Activity> activityList = activityRepository.findAll(longList);
		return activityList;

	}

}