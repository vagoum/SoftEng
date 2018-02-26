package gr.ece.ntua.bitsTeam.model.test;

import java.util.List;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import gr.ece.ntua.bitsTeam.Application;
import gr.ece.ntua.bitsTeam.model.Activity;
import gr.ece.ntua.bitsTeam.model.jparepos.ActivityRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class MyTest {

	@Autowired
	private ActivityRepository ar;

	@org.junit.Test
	public void newTest() {

		Activity activity = new Activity();
		
		activity.setName("AAAAAAA");
		
		ar.save(activity);
		
		activity = ar.findAll().get(0);
		
		activity.setName("BBBBBBBB");
		ar.save(activity);

	}
}