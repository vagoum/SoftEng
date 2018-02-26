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

		List<Activity> list = ar.findAll();
		
		System.out.println(list.get(0));
	}
	
	

}