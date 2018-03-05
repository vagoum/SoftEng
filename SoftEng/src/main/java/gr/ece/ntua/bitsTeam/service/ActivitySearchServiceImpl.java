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

	private final String maxValueCompare = "0";
	private final String minValueCompare = "10000000";

	@Autowired
	private ActivityRepository activityRepository;

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	@Override
	public List<Activity> search(SearchFiltersWrapper searchFiltersWrapper) {
		// TODO Auto-generated method stub

		Integer prox, costmin, costmax;
		Float lat, longt;
		String[] options = new String[10];
		String text = searchFiltersWrapper.getText();
		String latitude = searchFiltersWrapper.getLatitude();
		String longtitude = searchFiltersWrapper.getLongtitude();
		String proximity = searchFiltersWrapper.getProximity();
		String costMin = searchFiltersWrapper.getCostMin();
		String costMax = searchFiltersWrapper.getCostMax();
		String ageMin = searchFiltersWrapper.getAgeMin();
		String ageMax = searchFiltersWrapper.getAgeMax();
		int radius = Integer.parseInt(proximity) * 1000;
		String basequery = "SELECT activity.activity_id FROM activity, location_table as l  WHERE "
				+ "activity.cost > :costmin and activity.cost < :costmax and " +
				// "activity.ageMin > :ageMin and activity.ageMax < :ageMax" +
				"activity.name LIKE :text and "
				+ " activity.location_id=l.id and earth_box(ll_to_earth(:lat, :long), :prox) @> ll_to_earth(l.latitude, l.longtitude)";

		
		Query q;

		lat = Float.parseFloat(latitude);
		longt = Float.parseFloat(longtitude);

		if (costMin.equals("")) {
			costMin = maxValueCompare;
		}
		if (costMax.equals("")) {
			costMax = minValueCompare;
		}
		if (proximity.equals("")) {
			radius = 100000000;
		}
		if (!text.equals("")) {
				basequery += " and activity.name LIKE :text ;";
			
		} else {
			basequery += " ;";
		}

		if (text.equals("")) {
			q = entityManagerFactory.createEntityManager().createNativeQuery(basequery).setParameter("text", text)
				.setParameter("long", longt)
				.setParameter("lat", lat)
				.setParameter("prox", radius)
				.setParameter("costmin", Integer.parseInt(costMin))
				.setParameter("costmax", Integer.parseInt(costMax));
				
		}
		else {
			q = entityManagerFactory.createEntityManager().createNativeQuery(basequery).setParameter("text", text)
					.setParameter("long", longt)
					.setParameter("lat", lat)
					.setParameter("prox", radius)
					.setParameter("costmin", Integer.parseInt(costMin))
					.setParameter("costmax", Integer.parseInt(costMax))
					.setParameter("text", text);
			
		}
		List<Long> longList = new ArrayList<>();
		for (Object o : q.getResultList()) {
			BigInteger b = (BigInteger) o;
			longList.add(b.longValueExact());
		}

		
		return activityRepository.findAll(longList);

	}


}