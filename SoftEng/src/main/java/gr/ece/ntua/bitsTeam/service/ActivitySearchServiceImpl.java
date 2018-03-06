package gr.ece.ntua.bitsTeam.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
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

		String text = searchFiltersWrapper.getText();
		String latitude = searchFiltersWrapper.getLatitude();
		String longtitude = searchFiltersWrapper.getLongtitude();
		String proximity = searchFiltersWrapper.getProximity();
		String costMin = searchFiltersWrapper.getCostMin();
		String costMax = searchFiltersWrapper.getCostMax();
		String ageMin = searchFiltersWrapper.getAgeMin();
		String ageMax = searchFiltersWrapper.getAgeMax();
		String sortBy = searchFiltersWrapper.getSortBy();
		String category = searchFiltersWrapper.getCategory();
		int radius;
		String basequery = "SELECT activity.activity_id FROM activity, location_table as l  WHERE "
				+ "activity.cost >= :costmin and activity.cost <= :costmax and "
				+ " activity.age_min >= :agemin and activity.age_max <= :agemax and "
				+ " activity.location_id=l.id and earth_box(ll_to_earth(:lat, :long), :prox) @> ll_to_earth(l.latitude, l.longtitude) "
				+ " and activity.category LIKE :category ";

		Query q;

		lat = Float.parseFloat(latitude);
		longt = Float.parseFloat(longtitude);

		if (ageMin.equals("")) {
			ageMin = "0";
		}
		if (ageMax.equals("")) {
			ageMax = "20";
		}
		if (costMin.equals("")) {
			costMin = maxValueCompare;
		}
		if (costMax.equals("")) {
			costMax = minValueCompare;
		}
		if (!proximity.equals("") && !proximity.equals("0")) {
			radius = Integer.parseInt(proximity) * 1000;
		} else {
			radius = 100000000;
		}
		if (category.equals("Select no category")) {
			category = "%";
		}
		if (!text.equals("")) {
			basequery += " and activity.name LIKE :text ;";

		} else {
			basequery += " ;";
		}

		if (text.equals("")) {
			q = entityManagerFactory.createEntityManager().createNativeQuery(basequery).setParameter("long", longt)
					.setParameter("lat", lat).setParameter("prox", radius)
					.setParameter("agemin", Integer.parseInt(ageMin)).setParameter("agemax", Integer.parseInt(ageMax))
					.setParameter("costmin", Integer.parseInt(costMin))
					.setParameter("costmax", Integer.parseInt(costMax)).setParameter("category", category);

		} else {
			q = entityManagerFactory.createEntityManager().createNativeQuery(basequery).setParameter("long", longt)
					.setParameter("agemin", Integer.parseInt(ageMin)).setParameter("agemax", Integer.parseInt(ageMax))
					.setParameter("lat", lat).setParameter("prox", radius)
					.setParameter("costmin", Integer.parseInt(costMin))
					.setParameter("costmax", Integer.parseInt(costMax)).setParameter("text", text)
					.setParameter("category", category);

		}
		List<Long> longList = new ArrayList<>();
		for (Object o : q.getResultList()) {
			BigInteger b = (BigInteger) o;
			longList.add(b.longValueExact());
		}

		List<Activity> activities = activityRepository.findAll(longList);

		switch (sortBy) {
		case "No Sort":
			break;
		case "Alphabetical Order":
			activities.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));
			break;
		case "Date":
			activities.sort((o1, o2) -> o1.getDate().compareTo(o2.getDate()));
			break;
		case "Cost":
			activities.sort((o1, o2) -> o1.getCost().compareTo(o2.getCost()));
			break;
		default:
			break;
		}

		return activities;

	}

}