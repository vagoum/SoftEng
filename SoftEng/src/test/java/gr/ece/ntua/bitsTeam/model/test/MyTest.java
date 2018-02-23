package gr.ece.ntua.bitsTeam.model.test;

import java.util.List;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import gr.ece.ntua.bitsTeam.Application;
import gr.ece.ntua.bitsTeam.model.ActivityDetails;
import gr.ece.ntua.bitsTeam.model.jparepos.ActivityDetailsRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class MyTest {

	@Autowired
	private ActivityDetailsRepository ar;

	@org.junit.Test
	public void newTest() {

		List<ActivityDetails> list = ar.findAll();
		
		System.out.println(list.get(0));
	}
	
	

}