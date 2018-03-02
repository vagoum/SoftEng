package gr.ece.ntua.bitsTeam.model.test;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import gr.ece.ntua.bitsTeam.Application;
import gr.ece.ntua.bitsTeam.model.Activity;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class UserPersistenceTest {

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	@org.junit.Test
	public void organizerCreate() {
		String costFilter = "";
		costFilter = "activity.cost > minCost and activity.cost < maxCost";
		Query q =  entityManagerFactory.createEntityManager().createNativeQuery("SELECT activity.activity_id FROM activity, location_table as l WHERE activity.location_id=l.id and earth_box(ll_to_earth(10, 10), 10000000) @> ll_to_earth(l.latitude, l.longtitude);");
		List<Activity> l = q.getResultList();
		System.out.println(l);
	}
}