package gr.ece.ntua.bitsTeam.model.test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import gr.ece.ntua.bitsTeam.Application;
import gr.ece.ntua.bitsTeam.model.Organizer;
import gr.ece.ntua.bitsTeam.model.Parent;
import gr.ece.ntua.bitsTeam.model.jparepos.OrganizerRepository;
import gr.ece.ntua.bitsTeam.model.jparepos.ParentRepository;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class UserPersistenceTest {

	@Autowired
	private ParentRepository parentRepository;

	@Autowired
	private OrganizerRepository organizerRepository;
	
	
	@org.junit.Test
	public void parentCreate() {

		Parent parent = new Parent();
		parent.setFirstName("andreas");
		parentRepository.save(parent);
				
	}
	
	
	@org.junit.Test
	public void organizerCreate() {

		Organizer  organizer = new Organizer();
		organizer.setEmail("andreas");
		organizerRepository.save(organizer);
	}
}