package gr.ece.ntua.bitsTeam.model.test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import gr.ece.ntua.bitsTeam.Application;
import gr.ece.ntua.bitsTeam.model.Admin;
import gr.ece.ntua.bitsTeam.model.jparepos.AdminRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class MyTest {

	@Autowired
	private AdminRepository adminRepository;

	@org.junit.Test
	public void newTest() {

		Admin n = new Admin();
		n.setName("a");
		adminRepository.save(n);
	}
	
	

}